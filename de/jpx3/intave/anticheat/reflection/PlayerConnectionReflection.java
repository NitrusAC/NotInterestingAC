package de.jpx3.intave.anticheat.reflection;

import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.Unknown179;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class PlayerConnectionReflection {
   private static final boolean modern = MinecraftVersion.V_1_17.atOrAbove();
   private final Method b;

   public PlayerConnectionReflection() {
      try {
         Class var4 = ReflectionUtil.getClazz("PlayerConnection");
         if (modern) {
            Class[] var10005 = new Class[]{Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE, Set.class, Boolean.TYPE};
            this.b = var4.getDeclaredMethod(qd.b("internalTeleport", var4, var10005), var10005);
         } else {
            Class[] var6 = new Class[]{Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE, Set.class};
            this.b = var4.getDeclaredMethod(qd.b("internalTeleport", var4, var6), var6);
         }

         if (!this.b.isAccessible()) {
            this.b.setAccessible(true);
         }

      } catch (NoSuchMethodException var5) {
         throw new IntaveInternalException(var5);
      }
   }

   public void a(Player var1, Location var2, float yaw, float pitch, boolean flags) {
      try {
         PlayerData var9 = PlayerDataManager.getPlayerData(var1);
         if (!var9.exists()) {
            return;
         }

         Object var10 = var9.b();
         Set var11 = flags ? Unknown179.a() : Collections.emptySet();
         double var12 = var2.getX();
         double var14 = var2.getY();
         double var16 = var2.getZ();
         if (modern) {
            this.b.invoke(var10, var12, var14, var16, yaw, pitch, var11, false);
         } else {
            this.b.invoke(var10, var12, var14, var16, yaw, pitch, var11);
         }
      } catch (IllegalAccessException | InvocationTargetException var18) {
         var18.printStackTrace();
      }

   }
}
