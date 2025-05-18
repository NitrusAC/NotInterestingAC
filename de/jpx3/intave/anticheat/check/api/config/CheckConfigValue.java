package de.jpx3.intave.anticheat.check.api.config;

import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.unknown.Unknown187;
import java.util.HashMap;
import java.util.Map;

public final class CheckConfigValue {
   private final String d;
   private final AbstractCheck a;
   private final double c;
   private final String b;
   private static final String f;

   public CheckConfigValue(AbstractCheck check, double value) {
      this(check, "thresholds", value);
   }

   private static Object a(Object var0, String var1) {
      return var0;
   }

   public Object a(Map var1, Object var2) {
      return ((Map)var1.computeIfAbsent(this.b, CheckConfigValue::d)).computeIfAbsent(this.d, CheckConfigValue::a);
   }

   private static Map b(String var0) {
      return new HashMap();
   }

   public void a(PlayerData data, double var2) {
      Unknown187 var7 = data.getStorage().e();
      Map var8 = var7.j;
      Map var9 = var7.d;
      Map var10 = var7.l;
      long var11 = this.a(var10, System.currentTimeMillis());
      if (System.currentTimeMillis() - var11 > 1000L) {
         this.b(var9, 0.0);
         this.b(var10, System.currentTimeMillis());
      }

      double var13 = this.a(var9, Double.valueOf(0.0));
      var13 += var2;
      if (!(var13 > this.c)) {
         double var15 = this.a(var8, Double.valueOf(0.0));
         double var17 = MathUtil2.clamp(0.0, var15 - var2, 1000.0);
         this.b(var8, var17);
      }
   }

   public CheckConfigValue(AbstractCheck var1, String var2, double var3) {
      this.a = var1;
      this.b = var1.a();
      this.d = var2;
      this.c = var3;
   }

   public Object b(Map var1, Object var2) {
      return ((Map)var1.computeIfAbsent(this.b, CheckConfigValue::b)).put(this.d, var2);
   }

   private static Map d(String var0) {
      return new HashMap();
   }
}
