package de.jpx3.intave.unknown.what;

import com.comphenix.protocol.PacketType;
import com.google.common.collect.Maps;
import de.jpx3.intave.unknown.Unknown125;
import de.jpx3.intave.unknown.Unknown132;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import org.bukkit.event.Event;

public class What1 {
   private static final Map h = Maps.newConcurrentMap();
   public static final Unknown125 m = Unknown125.a("Check/Physics/Proc/Bia/Pred", "Check/Physics/Proc/Bia");
   public static final Unknown125 p = Unknown125.a("Service/Raytracer/Block", "Exe/Netty");
   private static final Map e = Maps.newConcurrentMap();
   public static final Unknown125 d = Unknown125.a("Check/Physics/Proc/Bia", "Check/Physics/Proc");
   public static final Unknown125 j = Unknown125.a("Check/Physics/Eval", "Check/Physics/ProcTot");
   private static final Map c = Maps.newConcurrentMap();
   private static final List k = new CopyOnWriteArrayList();
   public static final Unknown125 f = Unknown125.a("Check/Physics/Proc/Itr", "Check/Physics/Proc/Tot");
   public static final Unknown125 l = Unknown125.a("Exe/Netty");
   public static final Unknown125 i = Unknown125.a("Exe/Server");
   public static final Unknown125 b = Unknown125.a("Service/Raytracer/Entity", "Exe/Netty");
   public static final Map a = new Unknown132();
   public static final Unknown125 q = Unknown125.a("Service/Lookup/Type");
   public static final Unknown125 n = Unknown125.a("Check/Physics/Proc/Bia/lK", "Check/Physics/Proc/Bia");
   public static final Unknown125 g = Unknown125.a("Exe/Background");
   public static final Unknown125 o = Unknown125.a("Check/Physics/Proc", "Exe/Netty");

   public static Unknown125 a(PacketType var0) {
      String var1 = var0.name();
      return (Unknown125)c.computeIfAbsent(var1, What1::b);
   }

   public static String d(String var0) {
      return var0.substring(0, 1).toUpperCase() + var0.substring(1).toLowerCase();
   }

   private static boolean a(String var0, Unknown125 var1) {
      return var1.getName().equalsIgnoreCase(var0);
   }

   private static Unknown125 b(String var0) {
      String var4 = !var0.contains("_") ? d(var0) : (String)Arrays.stream(var0.split("_")).map(What1::d).collect(Collectors.joining());
      Unknown125 var5 = Unknown125.a("Packet/" + var4);
      var5.j();
      return var5;
   }

   public static List a() {
      return k;
   }

   public static Unknown125 c(String var0) {
      return (Unknown125)k.stream().filter(What1::a).findFirst().orElse(null);
   }

   private static Unknown125 a(String var0) {
      Unknown125 var3 = Unknown125.a("Event/" + var0);
      var3.p();
      return var3;
   }

   public static void a(Unknown125 var0) {
      k.add(var0);
   }

   private static String a(Event var0, Class var1) {
      return var0.getClass().getSimpleName();
   }

   public static Unknown125 a(Event var0) {
      String var1 = (String)e.computeIfAbsent(var0.getClass(), What1::a);
      return (Unknown125)h.computeIfAbsent(var1, What1::a);
   }
}
