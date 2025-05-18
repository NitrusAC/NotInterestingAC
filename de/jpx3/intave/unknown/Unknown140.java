package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.HitResult;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import java.util.function.Function;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface Unknown140 {
   HitResult a(World var1, Player var2, WrappedVec3d var3, WrappedVec3d var4);

   default HitResult a(World var1, Player var2, WrappedVec3d var3, WrappedVec3d var4, Function var5) {
      return this.a(var1, var2, var3, var4);
   }
}
