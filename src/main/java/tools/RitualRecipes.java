package tools;

import baseitems.RitualBaseItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.kazzleinc.ritualSMP.RitualSMP;

public class RitualRecipes {

    public NamespacedKey ritualBladeRecipeKey;

    RitualSMP plugin;
    public RitualRecipes(RitualSMP plugin) {
        this.plugin = plugin;

        ritualBladeRecipeKey = new NamespacedKey(plugin, "ritual_blade_recipe");

        createRitualBladeRecipe();
    }

    public void createRitualBladeRecipe() {
        ShapedRecipe bladeRecipe = new ShapedRecipe(ritualBladeRecipeKey, RitualWeapons.getRitualBlade());
        bladeRecipe.shape(" F ", " F ", " S ");

        bladeRecipe.setIngredient('F', RitualBaseItems.getRitualFragment());
        bladeRecipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(bladeRecipe);
    }
}
