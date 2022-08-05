/**
 * Copyright 2022 Infernal Studios
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.infernalstudios.celesteconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

import net.minecraftforge.fml.common.Mod;

@Mod("celesteconfig")
public class CelestialConfiguration {
	public static final String NAME = "Celestial Configuration";
	public static final String MOD_ID = "celesteconfig";
	public static final Logger LOGGER = LogManager.getLogger(NAME);

	public CelestialConfiguration() {
		CelestialConfigOptions.init();
	}

}
