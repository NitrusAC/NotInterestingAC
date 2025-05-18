package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.IntaveState;

public final class Unknown260 {
   private final long d;
   private final IntaveState f;
   private final int e;
   private final String c;

   public IntaveState a() {
      return this.f;
   }

   public long f() {
      return this.d;
   }

   public String c() {
      return this.c;
   }

   public Unknown260(String var1, long var2, IntaveState var4) {
      this.c = var1;
      this.d = var2;
      this.f = var4;
      int var5 = 0;

      try {
         var5 = this.a(var1);
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      this.e = var5;
   }

   public boolean b() {
      return this.f == IntaveState.OUTDATED;
   }

   private int a(String var1) {
      int var5 = 0;
      if (var1.contains("-b")) {
         String[] var6 = var1.split("-b");
         var1 = var6[0];
         var5 = Integer.parseInt(var6[1]);
      } else if (var1.contains("-u")) {
         String[] var12 = var1.split("-u");
         var1 = var12[0];
         var5 = Integer.parseInt(var12[1]);
      } else if (var1.contains("-pre")) {
         String[] var13 = var1.split("-pre");
         var1 = var13[0];
         var5 = Integer.parseInt(var13[1]);
      }

      String[] var14 = var1.split("\\.");
      int var7 = 0;

      for(String var11 : var14) {
         var7 = var7 * 10 + Integer.parseInt(var11);
      }

      return var7 * 10 + var5;
   }
}
