package com.aluminium._n.mixins;

import com.aluminium._n.$N;
import com.github.vfyjxf.jeiutilities.gui.bookmark.BookmarkInputHandler;
import mezz.jei.Internal;
import mezz.jei.gui.ingredients.IIngredientListElement;
import mezz.jei.gui.overlay.IngredientGrid;
import mezz.jei.gui.overlay.bookmarks.BookmarkOverlay;
import mezz.jei.input.ClickedIngredient;
import mezz.jei.input.MouseHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = BookmarkInputHandler.class, remap = false)
public class BookmarkInputHandlerMixin {
    /**
     * @author \n
     * @reason java.lang.IndexOutOfBoundsException
     */
    @Overwrite
    private int getInsertIndex() {
        BookmarkOverlay overlay = (BookmarkOverlay) Internal.getRuntime().getBookmarkOverlay();
        ClickedIngredient<?> ingredient = null;

        IIngredientListElement<?> dragged = BookmarkInputHandler.getInstance().getDraggedElement();
        List<IIngredientListElement> list = new ArrayList<>(Internal.getBookmarkList().getIngredientList());

        if (!list.remove(dragged)) {
            return -1;
        }

        boolean beforeLine = true;

        for (int x = MouseHelper.getX(); x >= 0; x -= IngredientGrid.INGREDIENT_WIDTH, beforeLine = false) {
            ingredient = (ClickedIngredient<?>) overlay.getIngredientUnderMouse(x, MouseHelper.getY());
            if (ingredient != null) break;
        }
        if (ingredient == null) return list.size();

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIngredient() == ingredient.getValue()) {
                index = i;
                break;
            }
        }

        if (beforeLine && MouseHelper.getX() > ingredient.getArea().width / 2 + ingredient.getArea().x) {
            index += 1;
        }

        if (index > list.size()) {
            index = list.size();
        }

//        $N.LOGGER.info("lksdlldlfls: {}", index);

        return index;
    }
}
