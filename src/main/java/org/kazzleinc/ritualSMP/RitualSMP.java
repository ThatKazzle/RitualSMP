package org.kazzleinc.ritualSMP;

import baseitems.RitualBaseItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RitualSMP extends JavaPlugin implements Listener {

    RitualBaseItems baseItemsClass = new RitualBaseItems(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPlauerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getPlayer();

        player.getWorld().dropItemNaturally(player.getLocation(), baseItemsClass.getRitualFragment());
    }
}
