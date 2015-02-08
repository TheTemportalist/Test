package test

import net.minecraft.command.ICommandSender
import net.minecraft.entity.Entity
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

/**
 *
 *
 * @author TheTemportalist 2/8/15
 */
class EntityTestS(world: World) extends Entity(world) with ICommandSender {

	override def entityInit(): Unit = {}

	override def writeEntityToNBT(tagCompound: NBTTagCompound): Unit = {}

	override def readEntityFromNBT(tagCompound: NBTTagCompound): Unit = {}

}
