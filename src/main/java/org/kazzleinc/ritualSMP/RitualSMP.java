package org.kazzleinc.ritualSMP;

import baseitems.RitualBaseItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import tools.RitualRecipes;
import tools.RitualWeapons;

public final class RitualSMP extends JavaPlugin implements Listener {

    RitualBaseItems baseItemsClass = new RitualBaseItems(this);

    RitualWeapons ritualWeaponsClass = new RitualWeapons(this);

    RitualRecipes ritualRecipesClass = new RitualRecipes(this);

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

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = player.getInventory().getItemInMainHand();

        if (event.getAction().isRightClick()) {
            //This is for the **Ritual Blade**
            if (mainHand.getItemMeta().getPersistentDataContainer().has(RitualWeapons.ritualBladeKey)) {
                ritualWeaponsClass.RitualBladeAction(player);
            }
        }
    }
}
