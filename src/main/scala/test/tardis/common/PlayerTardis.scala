package test.tardis.common

import com.temportalist.origin.library.common.nethandler.PacketHandler
import com.temportalist.origin.wrapper.common.extended.{ExtendedEntity, ExtendedEntityHandler}
import net.minecraft.client.Minecraft
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

/**
 *
 *
 * @author TheTemportalist
 */
class PlayerTardis(p: EntityPlayer) extends ExtendedEntity(p) {

	private var tardisDim: Int = 0
	private var tardisID: Int = -1
	private var originalPOV: Int = -1

	override def saveNBTData(tagCom: NBTTagCompound): Unit = {

	}

	override def loadNBTData(tagCom: NBTTagCompound): Unit = {

	}

	def setTardis(tDim: Int, tID: Int): Unit = {
		this.tardisDim = tDim
		this.tardisID = tID
		this.syncEntity()
	}

	def setTardis(tardis: EntityTardis): Unit = {
		if (tardis == null) this.setTardis(0, -1)
		else this.setTardis(tardis.getEntityWorld.provider.getDimensionId, tardis.getEntityId)
	}

	def isControllingTardis(): Boolean = this.tardisID >= 0

	def getTardis(): EntityTardis = {
		if (this.isControllingTardis()) {
			val world: World = DimensionManager.getWorld(this.tardisDim)
			val entity: Entity = world.getEntityByID(this.tardisID)
			if (entity != null) entity match {
				case tardis: EntityTardis => return tardis
				case _ =>
			}
		}
		null
	}

	@SideOnly(value = Side.CLIENT)
	def openRender(): Unit = {
		if (this.isControllingTardis()) {
			// todo WARNING: we need to make sure the tardis is chunk loaded
			val tardis: EntityTardis = this.getTardis()
			if (tardis != null) {
				this.originalPOV = Minecraft.getMinecraft.gameSettings.thirdPersonView
				Minecraft.getMinecraft.setRenderViewEntity(tardis)
				Minecraft.getMinecraft.gameSettings.thirdPersonView = 1
			}
		}
	}

	@SideOnly(value = Side.CLIENT)
	def closeRender(): Unit = {
		if (this.isControllingTardis()) {
			Minecraft.getMinecraft.setRenderViewEntity(Minecraft.getMinecraft.thePlayer)
			Minecraft.getMinecraft.gameSettings.thirdPersonView = this.originalPOV
			this.originalPOV = -1
		}
	}

}

object PlayerTardis {

	def get(player: EntityPlayer): PlayerTardis = {
		ExtendedEntityHandler.getExtended(player, classOf[PlayerTardis]).asInstanceOf[PlayerTardis]
	}

	def open(tardis: EntityTardis, player: EntityPlayer): Unit = {
		PacketHandler.sendToPlayer(Tardis.MODID,
			new PacketTardisController("open",
				tardis.getEntityWorld.provider.getDimensionId, tardis.getEntityId
			), player
		)
	}

	def close(player: EntityPlayer): Unit = {
		PacketHandler.sendToPlayer(Tardis.MODID, new PacketTardisController("close"), player)
	}

}
