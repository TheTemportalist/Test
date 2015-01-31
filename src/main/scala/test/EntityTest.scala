package test

import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

/**
 *
 *
 * @author TheTemportalist 1/30/15
 */
class EntityTest(world: World) extends EntityAgeable(world) {

	override def createChild(ageable: EntityAgeable): EntityAgeable = null

}
