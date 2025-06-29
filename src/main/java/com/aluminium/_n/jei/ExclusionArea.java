package com.aluminium._n.jei;

import mezz.jei.Internal;
import mezz.jei.api.gui.IGlobalGuiHandler;
import mezz.jei.gui.ingredients.IIngredientListElement;
import mezz.jei.gui.overlay.IngredientGrid;
import mezz.jei.gui.overlay.bookmarks.BookmarkOverlay;
import mezz.jei.input.ClickedIngredient;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ExclusionArea implements IGlobalGuiHandler {

    public ArrayList<Rectangle> exclusionAreas = new ArrayList<>();
    static int i = 0;

    @Override
    public Collection<Rectangle> getGuiExtraAreas() {
        return exclusionAreas;
    }

    public void exclude() {
//        List<IIngredientListElement> list = Internal.getBookmarkList().getIngredientList();
//
//        int k = 0;
//        for (IIngredientListElement ingredient: list) {
//            IIngredientListElementMixin item = (IIngredientListElementMixin) ingredient;
//            if (item.n$getBookmarkIndex() == null) {
//                item.n$setBookmarkIndex(UUID.randomUUID());
//            }
//            Object ingredient = iile.getIngredient();
//            if (ingredient instanceof ItemStack) {
//                ItemStack item = (ItemStack) ingredient;
//                NBTTagCompound tag = new NBTTagCompound();
//                NBTTagList tag2 = new NBTTagList();
//                tag2.appendTag(new NBTTagString(Integer.toString(k)));
//                tag.setTag("Lore", tag2);
//                item.setTagInfo("display", tag);
//            }
//            if (ingredient instanceof RecipeInfo) {
//                RecipeInfo item = (RecipeInfo) ingredient;
//                Object ingredient2 = item.getIngredient();
//                if (ingredient2 instanceof ItemStack) {
//                    ItemStack item2 = (ItemStack) ingredient2;
//                    NBTTagCompound tag = new NBTTagCompound();
//                    NBTTagList tag2 = new NBTTagList();
//                    tag2.appendTag(new NBTTagString(Integer.toString(k)));
//                    tag.setTag("Lore", tag2);
//                    item2.setTagInfo("display", tag);
//                }
//            }
//            k++;
//        }

        exclusionAreas.clear();
        if (Internal.getRuntime() != null) {
            BookmarkOverlay overlay = (BookmarkOverlay) Internal.getRuntime().getBookmarkOverlay();
            for (int j = 0; j < Minecraft.getMinecraft().displayHeight; j += IngredientGrid.INGREDIENT_HEIGHT) {
                for (int i = 0; i < Minecraft.getMinecraft().displayWidth; i += IngredientGrid.INGREDIENT_WIDTH) {
                    ClickedIngredient<?> ingredient = (ClickedIngredient<?>) overlay.getIngredientUnderMouse(i, j);
                    if (ingredient != null) {
                        Object value = ingredient.getValue();
                        if (value instanceof ItemStack) {
                            ItemStack item = (ItemStack) value;
//                            $N.LOGGER.info("lkslkdk: {} {}", item.getTagCompound(), item.getItem().getTranslationKey());
//                            if (item.getItem().getTranslationKey().equals("item.fish")) {
//                            if (ExclusionArea.i > 40) {
//                                $N.LOGGER.info(item.getTagCompound());
//                            }
                            if (item.getTagCompound() != null && item.getTagCompound().getCompoundTag("display").getString("Name").equals("\\n")) {
//                                $N.LOGGER.info("lkslkdk: {} {}", item.getTagCompound(), ingredient.getArea());
                                Rectangle area = new Rectangle(ingredient.getArea());
                                area.x += 20;
                                area.width += Minecraft.getMinecraft().displayWidth / 4 - area.x;
                                exclusionAreas.add(area);
                            }
                        }
                    }
                }
            }
        }

        if (i > 40) {
            i = 0;
        }
        i++;
//        BookmarkInputHandler.getInstance()
    }

//    @Nullable
//    @Override
//    public Object getIngredientUnderMouse(int mouseX, int mouseY) {
//        return IGlobalGuiHandler.super.getIngredientUnderMouse(mouseX, mouseY);
//    }
}
