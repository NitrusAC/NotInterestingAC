package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import org.bukkit.entity.Player;

public final class Unknown90 implements Unknown155 {
   @Override
   public Unknown101 a(PlayerData var1, Box var2, double var3, double var5, double var7) {
      Player var12 = var1.getPlayer();
      Boxable var13 = CollisionUtil.d(var12, var2.addCoord(var3, var5, var7));
      double var20 = var13.calculateOffset(Direction.Y, var2, var5);
      var2 = var2.add(0.0, var20, 0.0);
      boolean var16 = var5 != var20 && var5 < 0.0;
      var3 = var13.calculateOffset(Direction.X, var2, var3);
      var2 = var2.add(var3, 0.0, 0.0);
      var7 = var13.calculateOffset(Direction.Z, var2, var7);
      return new Unknown101(var3, var20, var7, var16, var5 != var20);
   }

   @Override
   public Unknown101 a(PlayerData var1, Box var2, Motion var3) {
      Player var8 = var1.getPlayer();
      double var9 = var3.motionX;
      double var11 = var3.motionY;
      double var13 = var3.motionZ;
      Boxable var15 = CollisionUtil.d(var8, var2.addCoord(var9, var11, var13));
      double var22 = var15.calculateOffset(Direction.Y, var2, var11);
      var2 = var2.add(0.0, var22, 0.0);
      boolean var18 = var11 != var22 && var11 < 0.0;
      var9 = var15.calculateOffset(Direction.X, var2, var9);
      var2 = var2.add(var9, 0.0, 0.0);
      var13 = var15.calculateOffset(Direction.Z, var2, var13);
      return new Unknown101(var9, var22, var13, var18, var11 != var22);
   }
}
