package com.aluminium._n.jei;

import com.aluminium._n.$N;
import com.aluminium._n.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class JEIUpdate {

    public static ExclusionArea area;

    @SubscribeEvent
    public static void exclude(TickEvent.RenderTickEvent event) {
        if (area != null) {
            area.exclude();
        }
    }
}
