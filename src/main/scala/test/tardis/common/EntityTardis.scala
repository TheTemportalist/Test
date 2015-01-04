package test.tardis.common

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.{AxisAlignedBB, DamageSource}
import net.minecraft.world.World

/**
 *
 *
 * @author TheTemportalist
 */
class EntityTardis(w: World) extends Entity(w) {

	this.setSize(1.3F, 2.5F)

	override def entityInit(): Unit = {
		
	}

	override def writeEntityToNBT(tagCom: NBTTagCompound): Unit = {

	}

	override def readEntityFromNBT(tagCom: NBTTagCompound): Unit = {

	}

	override def attackEntityFrom(source: DamageSource, amount: Float): Boolean = {
		source.getSourceOfDamage match {
			case player: EntityPlayer =>
				if (player.capabilities.isCreativeMode) {
					this.setDead()
					return true
				}
			case _ =>
		}
		false
	}

	override def canBeCollidedWith: Boolean = !this.isDead

	override def canBePushed: Boolean = false

	override def getCollisionBox(entityIn: Entity): AxisAlignedBB = null

	override def getBoundingBox: AxisAlignedBB = this.getEntityBoundingBox

	override def onCollideWithPlayer(player: EntityPlayer): Unit = {
		// todo collision player things
		println ("collision")
	}

}
