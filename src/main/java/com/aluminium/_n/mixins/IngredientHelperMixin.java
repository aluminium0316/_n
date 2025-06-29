package com.aluminium._n.mixins;

import com.github.vfyjxf.jeiutilities.helper.IngredientHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = IngredientHelper.class, remap = false)
public class IngredientHelperMixin {
    /**
     * @author \n
     * @reason list multiple
     */
    @Overwrite
    public static boolean ingredientEquals(Object ingredient1, Object ingredient2) {
        return false;
    }
}