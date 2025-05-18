package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.j0;
import de.jpx3.intave.jt;
import de.jpx3.intave.ju;
import de.jpx3.intave.jz;
import de.jpx3.intave.anticheat.data.PlayerData;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public enum Unknown230 {
   private final Consumer m;
   public static final Unknown230 a = new Unknown230(ju::new, 3, -1, false, false, true);
   private final int i;
   public static final Unknown230 e = new Unknown230(j0::new, 3, 50000, true, false, false);
   public static final Map g;
   public static final Unknown230 f = new Unknown230(ju::new, 4, 10000, true, true, true);
   public static final Unknown230 d = new Unknown230(jt::new, 2, 50000, true, true, false);
   public static final Unknown230 b = new Unknown230(ju::new, 1, -1, false, false, true);
   private final boolean k;
   private final boolean n;
   private final int o;
   public static final Unknown230 c = new Unknown230(jz::new, 1, 20000, false, true, false);
   private final boolean l;
   private static final Unknown230[] j = new Unknown230[]{a, b, c, d, e, f};
   public static final List h = (List)Arrays.stream(values()).filter(Unknown230::c).collect(Collectors.toList());

   public boolean e() {
      return this.l;
   }

   private static boolean c(Unknown230 var0) {
      return !var0.k;
   }

   static {
      Map var0 = (Map)Arrays.stream(values()).collect(Collectors.toMap(Unknown230::a, Unknown230::b, Unknown230::a));
      g = ImmutableMap.copyOf(var0);
   }

   public int a() {
      return this.o;
   }

   public boolean d() {
      return this.k;
   }

   public boolean c() {
      return this.n;
   }

   private static Integer a(Integer var0, Integer var1) {
      return var1;
   }

   private static Unknown230 a(Unknown230 var0) {
      return var0;
   }

   public void a(PlayerData var1) {
      this.m.accept(var1);
   }

   private Unknown230(Consumer var3, int var4, int var5, boolean var6, boolean var7, boolean var8) {
      this.m = var3;
      this.i = var4;
      this.o = var5;
      this.l = var6;
      this.n = var7;
      this.k = var8;
   }

   public static int b(Unknown230 var0) {
      int var5 = 0;
      var5 += var0.b() * 10;
      var5 = (int)((double)var5 * (var0.e() ? 0.8 : 1.0));
      return (int)((double)var5 * (var0.c() ? 0.8 : 1.0));
   }

   public int b() {
      return this.i;
   }
}
