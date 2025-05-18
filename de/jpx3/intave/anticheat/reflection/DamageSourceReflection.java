package de.jpx3.intave.anticheat.reflection;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import org.bukkit.entity.Player;

@Relocate
public final class DamageSourceReflection {
   private final MethodHandle handle;
   private final Object sourceField;

   public void getDamageSource(Player var1, float var2) {
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      Object var4 = var3.s();

      try {
         if (MinecraftVersion.V_1_17.atOrAbove()) {
            this.handle.invoke(var4, var2, 1.0F, this.sourceField);
         } else {
            this.handle.invoke(var4, var2, 1.0F);
         }
      } catch (Throwable var6) {
         var6.printStackTrace();
      }

   }

   public DamageSourceReflection() {
      Class var3 = ReflectionUtil.getClazz("EntityLiving");
      String var4 = "e";
      if (MinecraftVersion.V_1_17.atOrAbove()) {
         var4 = "a";
      } else if (MinecraftVersion.V_1_14.atOrAbove()) {
         var4 = "b";
      } else if (MinecraftVersion.V_1_13.atOrAbove()) {
         var4 = "c";
      }

      MethodType var5;
      if (MinecraftVersion.V_1_17.atOrAbove()) {
         Class var6 = ReflectionUtil.getClazz("DamageSource");
         var5 = MethodType.methodType(Boolean.TYPE, Float.TYPE, Float.TYPE, var6);
      } else if (MinecraftVersion.V_1_15.atOrAbove()) {
         var5 = MethodType.methodType(Boolean.TYPE, Float.TYPE, Float.TYPE);
      } else {
         var5 = MethodType.methodType(Void.TYPE, Float.TYPE, Float.TYPE);
      }

      try {
         this.handle = MethodHandles.lookup().findVirtual(var3, qd.b(var4, var3, var5.parameterArray()), var5);
      } catch (IllegalAccessException | NoSuchMethodException var8) {
         throw new IllegalStateException(var8);
      }

      if (MinecraftVersion.V_1_17.atOrAbove()) {
         try {
            Class var10001 = ReflectionUtil.getClazz("DamageSource");
            String var10004 = qd.c(var10001, "k");
            String var10003 = "k";
            this.sourceField = var10001.getField(var10004).get(null);
         } catch (Exception var7) {
            throw new IntaveInternalException(var7);
         }
      } else {
         this.sourceField = null;
      }

   }
}
