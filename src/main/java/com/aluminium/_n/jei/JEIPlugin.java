package com.aluminium._n.jei;

import com.aluminium._n.$N;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        ExclusionArea area = new ExclusionArea();

        $N.LOGGER.info("sldfjskdskkfj: {}", registry.toString());
        registry.addGlobalGuiHandlers(area);
        JEIUpdate.area = area;
    }
}
