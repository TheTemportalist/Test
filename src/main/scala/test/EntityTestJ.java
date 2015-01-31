package test;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * @author TheTemportalist 1/31/15
 */
public class EntityTestJ extends EntityAgeable {

	public EntityTestJ(World worldIn) {
		super(worldIn);
	}

	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
}
