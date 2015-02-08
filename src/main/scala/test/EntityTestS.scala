package test

import net.minecraft.command.CommandResultStats.Type
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import net.minecraft.entity.Entity

/**
 *
 *
 * @author TheTemportalist 2/8/15
 */
class EntityTestS(world: World) extends Entity(world) {

	override def setCommandStat(`type`: Type, amount: Int): Unit = {}

	override def entityInit(): Unit = {}

	override def writeEntityToNBT(tagCompound: NBTTagCompound): Unit = {}

	override def readEntityFromNBT(tagCompund: NBTTagCompound): Unit = {}

}
