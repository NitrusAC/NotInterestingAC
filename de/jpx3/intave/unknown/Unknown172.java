package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.access.UnsupportedFallbackOperationException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.IPacketHandler;
import de.jpx3.intave.unknown.what.What1;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Unknown172 extends Unknown173 implements Comparable {
   private final Module e;
   private final IPacketHandler b;
   private final IntaveListenerPriority f;
   private static final boolean a = Arrays.stream(PacketEvent.class.getMethods()).anyMatch(Unknown172::b);
   private static final char[] h = "AEIOU".toCharArray();
   private final boolean g;
   private final String d;
   private final Map c = new ConcurrentHashMap();

   public int a(Unknown172 var1) {
      return Integer.compare(this.b().getPriority(), var1.b().getPriority());
   }

   public IntaveListenerPriority b() {
      return this.f;
   }

   public int compareTo(Object var1) {
      return this.a((Unknown172)var1);
   }

   private String a(String var1) {
      if (var1.isEmpty()) {
         return "";
      } else {
         char var5 = var1.toUpperCase(Locale.ROOT).toCharArray()[0];
         boolean var6 = false;

         for(char var10 : h) {
            if (var10 == var5) {
               var6 = true;
               break;
            }
         }

         return var6 ? "An" : "A";
      }
   }

   public void onPacketReceiving(PacketEvent var1) {
      if (this.a(var1)) {
         Unknown125 var5 = (Unknown125)this.c.computeIfAbsent(var1.getPacketType(), What1::a);

         try {
            What1.l.h();
            var5.h();
            PlayerData var6 = PlayerDataManager.getPlayerData(var1.getPlayer());
            if (!var6.v()) {
               this.b.invoke(this.e, var1);
               return;
            }
         } catch (UnsupportedFallbackOperationException var12) {
            return;
         } catch (RuntimeException var13) {
            this.a(var1.getPacketType(), var13);
            return;
         } catch (Error var14) {
            this.a(var1.getPacketType(), var14);
            return;
         } finally {
            var5.g();
            What1.l.g();
         }

      }
   }

   public Unknown172(IntavePlugin var1, Module var2, IntaveListenerPriority var3, PacketType[] var4, String var5, IPacketHandler var6, boolean var7) {
      super(var1, var3.convert(), var4);
      this.e = var2;
      this.d = var5;
      this.f = var3;
      this.b = var6;
      this.g = var7;
   }

   private void a(PacketType var1, RuntimeException var2) {
      String var5 = var2.getClass().getSimpleName();
      Logger.getLogger()
         .print(
            "[Intave] "
               + this.a(var5)
               + " "
               + var5
               + " occurred while processing a "
               + var1.name()
               + " packet ("
               + this.e.getClass().getSimpleName()
               + "."
               + this.d
               + ")"
         );
      var2.printStackTrace();
   }

   public void onPacketSending(PacketEvent var1) {
      if (this.a(var1)) {
         try {
            PlayerData var5 = PlayerDataManager.getPlayerData(var1.getPlayer());
            if (var5.m()) {
               return;
            }

            this.b.invoke(this.e, var1);
         } catch (UnsupportedFallbackOperationException var6) {
         } catch (RuntimeException var7) {
            var7.getStackTrace();
            this.a(var1.getPacketType(), var7);
         } catch (Error var8) {
            this.a(var1.getPacketType(), var8);
         }

      }
   }

   private static boolean b(Method var0) {
      return var0.getName().equalsIgnoreCase("isPlayerTemporary");
   }

   private boolean a(PacketEvent var1) {
      if (a && var1.isPlayerTemporary()) {
         return false;
      } else {
         return var1.getPlayer() != null && (this.g || !var1.isCancelled()) && PlayerDataManager.isInjected(var1.getPlayer());
      }
   }

   public String toString() {
      return "FilteringPacketAdapter{methodName='"
         + this.d
         + '\''
         + ", subscriber="
         + this.e
         + ", receivingWhitelist="
         + this.receivingWhitelist
         + ", sendingWhitelist="
         + this.sendingWhitelist
         + '}';
   }

   public Module a() {
      return this.e;
   }

   private void a(PacketType var1, Error var2) {
      String var5 = var2.getClass().getSimpleName();
      Logger.getLogger()
         .print(
            "[Intave] "
               + this.a(var5)
               + " "
               + var5
               + " occurred while processing a "
               + var1.name()
               + " packet ("
               + this.e.getClass().getSimpleName()
               + "."
               + this.d
               + ")"
         );
      var2.printStackTrace();
   }
}
