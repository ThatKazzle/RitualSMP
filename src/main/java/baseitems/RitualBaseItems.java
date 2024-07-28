package baseitems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.kazzleinc.ritualSMP.RitualSMP;

import java.util.Arrays;

public class RitualBaseItems {
    RitualSMP plugin;

    public static NamespacedKey ritualFragmentKey;
    public static NamespacedKey ritualCoreKey;

    public RitualBaseItems(RitualSMP plugin) {
        this.plugin = plugin;

        ritualFragmentKey = new NamespacedKey(plugin, "ritual_fragment");
        ritualCoreKey = new NamespacedKey(plugin, "ritual_core");

    }

    public static ItemStack getRitualFragment() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Ritual Fragment");

        meta.setLore(Arrays.asList("", "" + ChatColor.GOLD + "a " + ChatColor.BOLD + "Ritual Fragment" + ChatColor.RESET + ChatColor.GOLD + ", gained by killing a player.", ChatColor.GOLD + " - This item can be used to craft " + ChatColor.BOLD + "Ritual Cores" + ChatColor.RESET + ChatColor.GOLD + "."));

        meta.getPersistentDataContainer().set(ritualFragmentKey, PersistentDataType.BOOLEAN, true);

        //§c is red character

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRitualCore() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Ritual Core");

        meta.setLore(Arrays.asList("", "" + ChatColor.GOLD + "a " + ChatColor.BOLD + "Ritual Core" + ChatColor.RESET + ChatColor.GOLD + ", gained by crafting 8 diamonds and a Ritual Fragment.", ChatColor.GOLD + " - This item can be used to craft special items."));

        meta.getPersistentDataContainer().set(ritualCoreKey, PersistentDataType.BOOLEAN, true);

        //§c is red character

        item.setItemMeta(meta);

        return item;
    }
}
