package org.kazzleinc.ritualSMP;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class ParticleUtils {

    RitualSMP plugin;
    public ParticleUtils(RitualSMP plugin) {
        this.plugin = plugin;
    }

    public static void createParticleLine(Location startLocation, Vector direction, double distance, double density, Particle particle) {
        World world = startLocation.getWorld();
        if (world == null) return;

        // Normalize the direction vector to ensure it's a unit vector
        direction = direction.normalize();

        // Calculate the total number of particles based on distance and density
        int numberOfParticles = (int) (distance * density);
        double interval = distance / numberOfParticles;

        for (int i = 0; i <= numberOfParticles; i++) {
            // Calculate the position for each particle
            Vector offset = direction.clone().multiply(i * interval);
            Location particleLocation = startLocation.clone().add(offset);

            // Spawn the particle
            world.spawnParticle(particle, particleLocation, 1, 0, 0, 0, 0);
        }
    }

}
