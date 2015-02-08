package test

import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

/**
 *
 *
 * @author TheTemportalist 1/31/15
 */
@Mod(modid = "test", name = "Test", modLanguage = "scala")
object Test {

	@Mod.EventHandler
	def pre(event: FMLPreInitializationEvent): Unit = {
		val config: Configuration = new ConfigJson(event.getModConfigurationDirectory, "Test.json")
		config.load()

		config.get("general", "bool", false, "This is a boolean")
		config.get("general", "int", 1234, "This is an int")
		config.get("general", "double", 2.0D, "double comment")
		config.get("general", "string", "ajsflkdsagjjkl")
		config.get("general", "double[]", Array[Double](.1, .2, .3))

		if (config.hasChanged)
			config.save()

	}

}
