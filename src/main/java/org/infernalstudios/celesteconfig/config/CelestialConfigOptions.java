package org.infernalstudios.celesteconfig.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "celeste_config")
public class CelestialConfigOptions implements ConfigData {

	public float moonWidth = 1.0F;
	public float moonHeight = 1.0F;
	public float sunWidth = 1.0F;
	public float sunHeight = 1.0F;

	public static CelestialConfigOptions getInstance() {
		return AutoConfig.getConfigHolder(CelestialConfigOptions.class).getConfig();
	}

}
