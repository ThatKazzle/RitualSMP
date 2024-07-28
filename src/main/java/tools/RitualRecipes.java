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
        createRitualCoreRecipe();
    }

    public void createRitualBladeRecipe() {
        ShapedRecipe bladeRecipe = new ShapedRecipe(ritualBladeRecipeKey, RitualWeapons.getRitualBlade());
        bladeRecipe.shape(" C ", " C ", " S ");

        bladeRecipe.setIngredient('C', RitualBaseItems.getRitualCore());
        bladeRecipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(bladeRecipe);
    }

    public void createRitualCoreRecipe() {
        ShapedRecipe coreRecipe = new ShapedRecipe(new NamespacedKey(plugin, "ritual_core_recipe"), RitualBaseItems.getRitualCore());
        coreRecipe.shape("DDD", "DFD", "DDD");

        coreRecipe.setIngredient('D', Material.DIAMOND);
        coreRecipe.setIngredient('F', RitualBaseItems.getRitualFragment());

        Bukkit.addRecipe(coreRecipe);
    }
}
