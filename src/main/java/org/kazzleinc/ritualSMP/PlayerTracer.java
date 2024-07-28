package org.kazzleinc.ritualSMP;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class PlayerTracer {

    // Maximum range to detect players
    private static final double MAX_DISTANCE = 50.0;

    // Offset to start the trace in front of the player to avoid self-detection
    private static final double OFFSET = 0.5;

    public static Player getTargetPlayer(Player player) {
        // Get the player's eye location and direction
        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection().normalize();

        // Offset the start location to avoid hitting the player themselves
        Location start = eyeLocation.add(direction.clone().multiply(OFFSET));
        Location end = start.clone().add(direction.clone().multiply(MAX_DISTANCE));

        // Perform the ray trace
        ArrayList<Entity> entities = (ArrayList<Entity>) start.getWorld().getNearbyEntities(start, MAX_DISTANCE, MAX_DISTANCE, MAX_DISTANCE);

        Player targetPlayer = null;
        double closestDistance = Double.MAX_VALUE;

        for (Entity entity : entities) {
            if (entity instanceof Player && entity != player) {
                // Calculate the distance along the direction vector
                double distance = start.distance(entity.getLocation());
                if (distance < closestDistance) {
                    closestDistance = distance;
                    targetPlayer = (Player) entity;
                }
            }
        }

        return targetPlayer;
    }
}
