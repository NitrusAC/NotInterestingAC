package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public final class Unknown16 implements Unknown335 {
   private Unknown205 a = new Unknown205();
   private static final long d = TimeUnit.DAYS.toMillis(7L);
   private static final long c = 256L;
   private static final long b = TimeUnit.MINUTES.toMillis(10L);
   private static final long e = TimeUnit.MINUTES.toMillis(3L);

   @Override
   public void a(ByteArrayDataInput var1) {
      this.a.a(var1);
      this.b();
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      this.b();
      this.a.a(var1);
   }

   public Unknown205 a() {
      return this.a;
   }

   private void a(Unknown194 var1) {
      this.a.a(var1);
   }

   public void a(ImmutableViolation var1) {
      Violation var5 = var1.l();
      String var6 = var5.getCheck().k();
      String var7 = var5.h();
      int var8 = (int)var1.j();
      if (this.a(var6, var7, var8)) {
         Optional var9 = this.a(var6);
         long var10 = var9.map(Unknown194::b).orElseGet(System::currentTimeMillis);
         if (var10 > b) {
            if ((long)this.a.d() < 256L) {
               Unknown194 var12 = new Unknown194(
                  var6.toLowerCase(Locale.ROOT), var7.toLowerCase(Locale.ROOT), IntavePlugin.m().toLowerCase(Locale.ROOT), var8, System.currentTimeMillis()
               );
               this.a(var12);
            }
         } else if (var10 < e && var9.isPresent()) {
            Unknown194 var13 = (Unknown194)var9.get();
            if (var8 > var13.f()) {
               var13.a(var8);
               var13.a(System.currentTimeMillis());
            }
         }
      }

   }

   public boolean a(String var1, String var2, int var3) {
      String var7 = var1.toLowerCase(Locale.ROOT);
      switch(var7) {
         case "attackraytrace":
            return var3 > 100;
         case "heuristics":
            return var2.contains("!");
         case "physics":
         case "placementanalysis":
            return var3 > 500;
         default:
            return false;
      }
   }

   private Optional a(String var1) {
      return this.a.a().filter(Unknown16::b).max(Comparator.comparingLong(Unknown194::c));
   }

   private void b() {
      this.a = this.a.a(d, TimeUnit.MILLISECONDS);
   }

   private static boolean b(String var0, Unknown194 var1) {
      return var1.e().equalsIgnoreCase(var0);
   }
}
