package test.tardis.client

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.MouseEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.{Side, SideOnly}
import test.tardis.common.PlayerTardis

/**
 *
 *
 * @author TheTemportalist
 */
@SideOnly(value = Side.CLIENT)
object TardisController {

	@SubscribeEvent
	def mouseEvent(event: MouseEvent): Unit = {
		val player: PlayerTardis = PlayerTardis.get(Minecraft.getMinecraft.thePlayer)
		if (!player.isControllingTardis()) return

		//event.setCanceled(true)
		// todo control tardis

	}

}
