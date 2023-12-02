package org.infernalstudios.celesteconfig;

import net.fabricmc.api.ModInitializer;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class CelestialConfiguration implements ModInitializer {

	@Override
	public void onInitialize() {
		AutoConfig.register(CelestialConfigOptions.class, GsonConfigSerializer::new);
	}
}
