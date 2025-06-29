package com.aluminium._n.mixins;

import mezz.jei.bookmarks.BookmarkList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = BookmarkList.class, remap = false)
public class BookmarkListMixin {
    /**
     * @author \n
     * @reason list multiple
     */
    @Overwrite
    private boolean contains(Object ingredient) {
        return false;
    }
}
