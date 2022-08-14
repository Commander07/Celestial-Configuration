package org.infernalstudios.celesteconfig;

import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class CelestialConfiguration implements ModInitializer {

	@Override
	public void onInitialize(ModContainer mod) {
		AutoConfig.register(CelestialConfigOptions.class, GsonConfigSerializer::new);
	}

}
