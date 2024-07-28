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

    NamespacedKey ritualFragmentKey;

    public RitualBaseItems(RitualSMP plugin) {
        this.plugin = plugin;

        ritualFragmentKey = new NamespacedKey(plugin, "ritual_fragment");
    }

    public ItemStack getRitutalFragment() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Ritual Fragment");

        meta.setLore(Arrays.asList("" + ChatColor.RED + "a " + ChatColor.BOLD + "Ritual Fragment" + ChatColor.RESET + ChatColor.RED + ", gained by killing a player.", ChatColor.RED + " - This item can be used to craft special items."));

        meta.getPersistentDataContainer().set(ritualFragmentKey, PersistentDataType.BOOLEAN, true);

        //§c is red character

        item.setItemMeta(meta);

        return item;
    }
}
