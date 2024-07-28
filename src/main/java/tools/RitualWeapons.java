package tools;

import com.google.common.collect.Multimap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataType;
import org.kazzleinc.ritualSMP.ParticleUtils;
import org.kazzleinc.ritualSMP.PlayerTracer;
import org.kazzleinc.ritualSMP.RitualSMP;

import java.util.Arrays;
import java.util.UUID;

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

        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        //§c is red character

        item.setItemMeta(meta);

        return item;
    }


    public void RitualBladeAction(Player player) {
        ParticleUtils.createParticleLine(player.getEyeLocation(), player.getEyeLocation().getDirection(), 30, 3, Particle.FLAME);

        Player targetPlayer = PlayerTracer.getTargetPlayer(player);

        if (targetPlayer != null && player.getLocation().distance(targetPlayer.getLocation()) < 30) {
            player.sendActionBar(ChatColor.YELLOW + "You hit " + ChatColor.BOLD + targetPlayer.getName() + ChatColor.RESET + "" + ChatColor.YELLOW + "!");
        } else {
            player.sendActionBar(ChatColor.RED + "No players were hit.");
        }
    }
}
