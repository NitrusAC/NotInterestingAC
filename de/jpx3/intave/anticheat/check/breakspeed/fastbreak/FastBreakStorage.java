package de.jpx3.intave.anticheat.check.breakspeed.fastbreak;

import com.comphenix.protocol.wrappers.BlockPosition;
import de.jpx3.intave.anticheat.storage.Storable;

public final class FastBreakStorage extends Storable {
   public float g = 0.0F;
   public double a;
   public BlockPosition destroyingPosition;
   public float f;
   public long lastInteractBlock;
   public boolean destroying;
}
