package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.packet.PacketRegistry;
import de.jpx3.intave.mG;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.IPacketHandler;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.adapter.ForwardingPacketAdapter;
import de.jpx3.intave.unknown.Unknown116;
import de.jpx3.intave.unknown.Unknown172;
import de.jpx3.intave.unknown.Unknown173;
import de.jpx3.intave.unknown.Unknown23;
import de.jpx3.intave.unknown.Unknown233;
import de.jpx3.intave.unknown.Unknown357;
import de.jpx3.intave.unknown.Unknown5;
import de.jpx3.intave.unknown.Unknown51;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.IntFunction;

@mG
public final class Check8 extends UnknownCheck {
   private final Map e = new ConcurrentHashMap();
   private final Map a = new ConcurrentHashMap();
   private static final boolean j = false;
   private final List g;
   private Unknown233 f;
   private final List h = new ArrayList();
   private final IntavePlugin i;

   private void a(Unknown173 var1) {
      ProtocolLibrary.getProtocolManager().addPacketListener(var1);
   }

   private PacketType a(ClientPacket var1) {
      return this.a(this.a(ConnectionSide.CLIENT_SIDE), var1.getType());
   }

   private void a(Module var1, IntaveListenerPriority var2, PacketType[] var3, boolean var4, String var5, IPacketHandler var6) {
      if (var3.length != 0) {
         for(PacketType var10 : var3) {
            Unknown172 var11 = new Unknown172(this.i, var1, var2, new PacketType[]{var10}, var5, var6, var4);
            ((Unknown51)this.a.computeIfAbsent(var10, Check8::b)).a(var11);
         }

      }
   }

   private PacketType[] a(PacketType[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         PacketType var3 = var1[var2];
         if (this.c(var3)) {
            var1[var2] = null;
         }
      }

      return var1;
   }

   private boolean a(Method var1) {
      return var1.getAnnotation(PacketListener.class) != null;
   }

   public void b() {
      ProtocolLibrary.getProtocolManager().removePacketListeners(this.i);

      for(PacketType var2 : this.a.keySet()) {
         this.a(var2, (Unknown51)this.a.get(var2));
      }

      for(Unknown173 var4 : this.g) {
         this.a(var4);
      }

      this.f.c();
      this.e.forEach(this.f::a);
   }

   private boolean c(Method var1) {
      return this.a(var1) && this.b(var1) && this.d(var1);
   }

   private IPacketHandler a(Module var1, Method var2, String var3) {
      String var6 = this.a(this.b(Module.class));
      String var7 = this.a(this.b(var1.getClass()));
      String var8 = this.a(this.b(PacketEvent.class));
      Class var9 = Unknown23.a(
         Check8.class.getClassLoader(),
         IPacketHandler.class,
         "<generated>",
         "invoke",
         "(L" + var6 + ";L" + var8 + ";)V",
         "(L" + var7 + ";L" + var8 + ";)V",
         var7,
         var2.getName(),
         Unknown357.a(var2),
         false,
         false
      );
      return (IPacketHandler)this.a(var9);
   }

   private PacketType[] b(ClientPacket[] var1, ServerPacket[] var2) {
      PacketType[] var3 = this.a(var1);
      PacketType[] var4 = this.a(var2);
      return (PacketType[])a(var3, var4);
   }

   private PacketType a(Collection var1, String var2) {
      return (PacketType)var1.stream().filter(this::a).findFirst().orElse(null);
   }

   private boolean a(PacketType var1, String var2) {
      return var1.name().equalsIgnoreCase(var2);
   }

   private PacketType[] a(ClientPacket[] var1) {
      return var1.length == 1 && var1[0].getType().equals("*")
         ? (PacketType[])PacketRegistry.getClientPacketTypes().toArray(new PacketType[0])
         : (PacketType[])Arrays.stream(var1).map(this::a).toArray(Check8::a);
   }

   private static Unknown51 b(PacketType var0) {
      return new Unknown51();
   }

   private Object a(Class var1) {
      try {
         return var1.newInstance();
      } catch (IllegalAccessException | InstantiationException var3) {
         throw new Error(var3);
      }
   }

   private PacketType[] a(ServerPacket[] var1) {
      return var1.length == 1 && var1[0].getName().equals("*")
         ? (PacketType[])PacketRegistry.getClientPacketTypes().toArray(new PacketType[0])
         : (PacketType[])Arrays.stream(var1).map(this::a).toArray(Check8::b);
   }

   private boolean a(String var1, PacketType var2) {
      return this.a(var2, var1);
   }

   private boolean d(Method var1) {
      int var2 = var1.getModifiers();
      return !Modifier.isStatic(var2) && Modifier.isPublic(var2);
   }

   private void a(Module var1, Method var2) {
      PacketListener var3 = (PacketListener)var2.getAnnotation(PacketListener.class);
      IPacketHandler var4 = this.a(var1, var2, var3.f());
      String var5 = var2.getName();
      IntaveListenerPriority var6 = var3.priority();
      PacketType[] var7 = this.a(var3.packetTypes(), var3.g());
      boolean var8 = var3.c();
      if (var3.e() == Unknown5.b) {
         this.c(var1, var6, var7, var8, var5, var4);
      } else if (var3.b() == Unknown116.a) {
         this.a(var1, var6, var7, var8, var5, var4);
      } else {
         this.b(var1, var6, var7, var8, var5, var4);
      }

   }

   private void b(Unknown173 var1) {
      ProtocolLibrary.getProtocolManager().removePacketListener(var1);
   }

   public void a(Module var1) {
      for(Unknown51 var3 : this.a.values()) {
         var3.removeIf(Check8::a);
      }

   }

   private boolean b(Method var1) {
      return var1.getParameterCount() == 1 && var1.getParameterTypes()[0] == PacketEvent.class;
   }

   @Override
   public void e() {
      for(Unknown173 var2 : this.h) {
         this.b(var2);
         var2.a();
      }

      this.h.clear();

      for(Unknown173 var4 : this.g) {
         this.b(var4);
         var4.a();
      }

      this.g.clear();
      ProtocolLibrary.getProtocolManager().removePacketListeners(this.i);
      this.a.values().forEach(Unknown51::clear);
      this.a.clear();
      this.e.values().forEach(Unknown51::clear);
      this.e.clear();
      this.f.c();
      this.f.d();
   }

   private static boolean a(Module var0, Unknown172 var1) {
      return var1.a() == var0;
   }

   private String b(Class var1) {
      return var1.getCanonicalName();
   }

   public Check8(IntavePlugin var1) {
      this.g = new ArrayList();
      this.i = var1;
   }

   private boolean c(PacketType var1) {
      return false;
   }

   private PacketType[] a(ClientPacket[] var1, ServerPacket[] var2) {
      return (PacketType[])this.a(this.a(this.b(var1, var2)), Check8::c);
   }

   @Override
   public void refreshConfig() {
      this.f = new Unknown233(this.i);
   }

   private static PacketType[] c(int var0) {
      return new PacketType[var0];
   }

   private Object[] a(Object[] var1, IntFunction var2) {
      return Arrays.stream(var1).filter(Objects::nonNull).distinct().toArray(var2);
   }

   private static PacketType[] a(int var0) {
      return new PacketType[var0];
   }

   private void b(Module var1, IntaveListenerPriority var2, PacketType[] var3, boolean var4, String var5, IPacketHandler var6) {
      if (var3.length != 0) {
         Unknown172 var7 = new Unknown172(this.i, var1, var2, var3, var5, var6, var4);
         this.a(var7);
         this.g.add(var7);
      }
   }

   private void c(Module var1, IntaveListenerPriority var2, PacketType[] var3, boolean var4, String var5, IPacketHandler var6) {
      if (var3.length != 0) {
         Unknown172 var7 = new Unknown172(this.i, var1, var2, var3, var5, var6, var4);

         for(PacketType var11 : var3) {
            Unknown51 var12 = (Unknown51)this.e.computeIfAbsent(var11, Check8::a);
            var12.a(var7);
         }

      }
   }

   private static PacketType[] b(int var0) {
      return new PacketType[var0];
   }

   private String a(String var1) {
      return var1.replaceAll("\\.", "/");
   }

   private static Unknown51 a(PacketType var0) {
      return new Unknown51();
   }

   private static Object[] a(Object[] var0) {
      return var0 == null ? null : var0.clone();
   }

   private static Object[] a(Object[] var0, Object[] var1) {
      if (var0 == null) {
         return a(var1);
      } else if (var1 == null) {
         return a(var0);
      } else {
         Object[] var4 = Array.newInstance(var0.getClass().getComponentType(), var0.length + var1.length);
         System.arraycopy(var0, 0, var4, 0, var0.length);

         try {
            System.arraycopy(var1, 0, var4, var0.length, var1.length);
            return var4;
         } catch (ArrayStoreException var8) {
            Class var6 = var0.getClass().getComponentType();
            Class var7 = var1.getClass().getComponentType();
            if (!var6.isAssignableFrom(var7)) {
               throw new IllegalArgumentException("Cannot store " + var7.getName() + " in an array of " + var6.getName());
            } else {
               throw var8;
            }
         }
      }
   }

   private void a(PacketType var1, Unknown51 var2) {
      ForwardingPacketAdapter var3 = new ForwardingPacketAdapter(this.i, var1, var2);
      this.h.add(var3);
      this.a(var3);
   }

   private Collection a(ConnectionSide var1) {
      HashSet var2 = new HashSet();
      if (var1.isForServer()) {
         var2.addAll(PacketRegistry.getServerPacketTypes());
      }

      if (var1.isForClient()) {
         var2.addAll(PacketRegistry.getClientPacketTypes());
      }

      return var2;
   }

   public void b(Module var1) {
      for(Method var5 : var1.getClass().getMethods()) {
         if (this.c(var5)) {
            this.a(var1, var5);
         }
      }

   }

   private PacketType a(ServerPacket var1) {
      return this.a(this.a(ConnectionSide.SERVER_SIDE), var1.getName());
   }
}
