package tools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.kazzleinc.ritualSMP.RitualSMP;

import java.util.Arrays;

public class RitualWeapons {

    public static NamespacedKey ritualBladeKey;

    RitualSMP plugin;
    public RitualWeapons(RitualSMP plugin) {
        this.plugin = plugin;

        ritualBladeKey = new NamespacedKey(plugin, "ritual_blade");
    }

    public static ItemStack getRitualBlade() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Ritual Blade");
        meta.setLore(Arrays.asList("", ChatColor.RED + "The " + ChatColor.BOLD + "Ritual Blade" + ChatColor.RESET + ChatColor.RED + " allows you to (TBD)"));
        meta.getPersistentDataContainer().set(ritualBladeKey, PersistentDataType.BOOLEAN, true);
        //§c is red character

        item.setItemMeta(meta);

        return item;
    }
}
