package de.jpx3.intave.anticheat.engine.move;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.move.impl.LegacyMoveHandler;
import de.jpx3.intave.anticheat.engine.move.impl.ModernMoveHandler;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown101;
import de.jpx3.intave.unknown.Unknown155;
import de.jpx3.intave.unknown.Unknown90;
import org.bukkit.entity.Player;

public final class MoveHandlerFactory {
   private static final Unknown155 d = new Unknown90();
   private static final MoveHandler legacyMoveHandler = new LegacyMoveHandler();
   private static final MoveHandler modernMoveHandlerA = new ModernMoveHandler();
   private static final MoveHandler modernMoveHandlerB = new ModernMoveHandler();

   public static Unknown101 a(Player var0, IntaveVector vec, Motion motion) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var0);
      Box var7 = Box.of(var6, vec);
      return var6.f().a(var6, var7, motion);
   }

   public static Unknown101 a(Player var0, double minX, double minY, double minZ, double maxX, double maxY, double max) {
      PlayerData var17 = PlayerDataManager.getPlayerData(var0);
      Box var18 = Box.of(var17, minX, minY, minZ);
      Unknown155 var19 = var17.f();
      return var19.a(var17, var18, maxX, maxY, max);
   }

   private MoveHandlerFactory() {
   }

   public static Unknown155 a(PlayerData data) {
      return d;
   }

   public static MoveHandler getHandler(PlayerData data) {
      VersionHolder var1 = data.getStorage().getVersionHolder();
      if (var1.iss1_14()) {
         return legacyMoveHandler;
      } else {
         return var1.getVersionId() >= VersionHolder.V_1_8_8 ? modernMoveHandlerB : modernMoveHandlerA;
      }
   }

   public static MotionContext computeContext(PlayerData data, Motion motion, boolean var2, double x, double y, double z) {
      return data.getMoveHandler().moveEntity(data, motion, x, y, z, var2);
   }
}
