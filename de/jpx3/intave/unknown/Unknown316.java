package de.jpx3.intave.unknown;

import com.google.common.collect.Sets;
import de.jpx3.intave.cw;
import de.jpx3.intave.mo;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.world.WorldInitEvent;

public final class Unknown316 extends UnknownCheck {
   private static final boolean a = !MinecraftVersion.V_1_14.atOrAbove();

   @BukkitEventListener
   public void a(WorldInitEvent var1) {
      this.a(var1.getWorld());
   }

   public Unknown316() {
      if (a) {
         ClassLoader var3 = IntavePlugin.class.getClassLoader();
         Unknown152.a(var3, "de.jpx3.intave.unknown.Unknown45");
      }

   }

   public void a(World var1) {
      if (a) {
         String var5 = "Unknown";

         try {
            Field var6 = this.a();
            if (var6 == null) {
               return;
            }

            if (!var6.isAccessible()) {
               var6.setAccessible(true);
            }

            String var7 = var6.getType().getName();
            Object var8 = Unknown239.a(var1);
            Object var9 = var6.get(var8);

            Iterator var10;
            try {
               Class var10000 = var9.getClass();
               Class[] var10003 = new Class[0];
               var10 = (Iterator)var10000.getMethod(qd.b("iterator", var10000, var10003), var10003).invoke(var9);
            } catch (Exception var12) {
               var10 = Collections.emptyIterator();
            }

            if (var7.contains("dsi.fastutil.longs")) {
               if (var7.endsWith("LongArraySet")) {
                  var5 = "s(dsi/ls)";
                  cw var11 = new cw();
                  var6.set(var8, var11);
                  var10.forEachRemaining(var11::add);
               } else {
                  var5 = "s(dsi/lhs)";
                  mo var18 = new mo();
                  var6.set(var8, var18);
                  var10.forEachRemaining(var18::add);
               }
            } else if (var7.endsWith("util.LongHashSet")) {
               var5 = "s(ut/lhs)";
               Unknown45 var19 = new Unknown45();
               var6.set(var8, var19);
               var10.forEachRemaining(var19::add);
            } else {
               var5 = "s(java/hs)";
               Unknown211 var20 = new Unknown211(Sets.newHashSet());
               var6.set(var8, var20);
               var10.forEachRemaining(var20::add);
            }
         } catch (Error | Exception var13) {
            Logger.getLogger().info("Failed to patch chunk unload queue of \"" + var1.getName() + " with \"" + var5 + "\": " + var13.getMessage());
            var13.printStackTrace();
         }

      }
   }

   private Field a() {
      try {
         Class var10000 = ReflectionUtil.getClazz("ChunkProviderServer");
         String var10003 = qd.c(var10000, "unloadQueue");
         String var10002 = "unloadQueue";
         return var10000.getField(var10003);
      } catch (NoSuchFieldException var4) {
         return null;
      }
   }

   @Override
   public void refreshConfig() {
      Bukkit.getWorlds().forEach(this::a);
   }
}
