package test.tardis.server

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import test.tardis.common.ProxyCommon

/**
 *
 *
 * @author TheTemportalist
 */
class ProxyServer() extends ProxyCommon {

	override def getServerElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int,
			z: Int, tileEntity: TileEntity): AnyRef = {
		null
	}

}
