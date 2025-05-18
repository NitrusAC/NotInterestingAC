package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.PacketListener;
import de.jpx3.intave.anticheat.module.impl.CustomPayloadModule;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Consumer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public final class Unknown383 implements PacketListener {
   private List a;
   private final Map e = Unknown19.a(Maps.newConcurrentMap());
   private final IntavePlugin c;
   private final CustomPayloadModule b;

   public native void a(Player var1, String var2, String var3, JsonElement var4);

   private native Object a(Object var1);

   private native void a(Player var1, Unknown20 var2);

   private static void b(Player var0, PacketContainer var1) {
      ProtocolManager.sendPacket(var0, var1);
   }

   private static void a() {
      System.exit(0);
   }

   private static void a(String var0, String var1, Consumer var2) {
      try {
         URL var6 = new URL(var0);
         URLConnection var7 = var6.openConnection();
         var7.setUseCaches(false);
         var7.setDefaultUseCaches(false);
         var7.addRequestProperty("User-Agent", "Intave/" + IntavePlugin.m());
         var7.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
         var7.addRequestProperty("Pragma", "no-cache");
         var7.addRequestProperty("authkey", var1);
         var7.addRequestProperty("license", Unknown60.b());
         Scanner var8 = new Scanner(var7.getInputStream(), "UTF-8");
         StringBuilder var9 = new StringBuilder();

         while(var8.hasNext()) {
            var9.append(var8.next());
         }

         var2.accept("success".equalsIgnoreCase(var9.toString()));
      } catch (IOException var10) {
         var2.accept(false);
      }

   }

   public native Unknown20 b(Player var1);

   private void a(Player var1, Boolean var2) {
      JsonObject var6 = new JsonObject();
      var6.addProperty("action", "verify");
      var6.addProperty("state", var2 ? "success" : "rejected");
      this.a(var1, "LMC", "sibyl-auth", var6);
      this.a(var1, var2 ? Unknown20.d : Unknown20.e);
   }

   private native void a(Player var1, JsonElement var2);

   private static Unknown20 b(UUID var0) {
      return Unknown20.a;
   }

   private native void a(String var1, Consumer var2);

   @BukkitEventListener
   public native void a(PlayerQuitEvent var1);

   private native void a(UUID var1);

   public native boolean a(Player var1);

   public Unknown383(IntavePlugin var1) {
      this.a = new ArrayList();
      this.a(UUID.randomUUID());
      this.a(UUID.randomUUID());
      this.a(UUID.randomUUID());
      this.a(UUID.randomUUID());
      this.a(UUID.randomUUID());
      this.a(UUID.randomUUID());
      this.a(null);
      this.c = var1;
      this.b = new CustomPayloadModule(var1, "sibyl-auth", this::a);
      MoudleLoader.j().c().b(this);
   }
}
