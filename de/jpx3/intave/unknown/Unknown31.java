package de.jpx3.intave.unknown;

import de.jpx3.intave.ol;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

final class Unknown31 extends AbstractSet {
   private int b = 0;
   private final Class a;
   private long[] d;
   private final Enum[] c;

   public void b() {
      long[] var4 = Arrays.copyOf(this.d, this.d.length);

      for(int var5 = 0; var5 < var4.length; ++var5) {
         var4[var5] = ~var4[var5];
      }

      var4[var4.length - 1] &= -1L >>> -this.c.length;
      this.d = var4;
      this.b = this.c.length - this.b;
   }

   public boolean addAll(@NotNull Collection var1) {
      if (!(var1 instanceof Unknown31)) {
         return super.addAll(var1);
      } else {
         Unknown31 var5 = (Unknown31)var1;
         long[] var6 = Arrays.copyOf(this.d, this.d.length);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var6[var7] |= var5.d[var7];
         }

         this.d = var6;
         return this.c();
      }
   }

   public void clear() {
      Arrays.fill(this.d, 0L);
      this.b = 0;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof Unknown31)) {
         return super.equals(var1);
      } else {
         Unknown31 var5 = (Unknown31)var1;
         if (var5.a == this.a) {
            return Arrays.equals(var5.d, this.d);
         } else {
            return this.b == 0 && var5.b == 0;
         }
      }
   }

   public boolean containsAll(@NotNull Collection var1) {
      if (!(var1 instanceof Unknown31)) {
         return super.containsAll(var1);
      } else {
         Unknown31 var5 = (Unknown31)var1;
         if (var5.a != this.a) {
            return var5.isEmpty();
         } else {
            for(int var6 = 0; var6 < this.d.length; ++var6) {
               if ((var5.d[var6] & ~this.d[var6]) != 0L) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public Unknown31 a() {
      try {
         Unknown31 var1 = (Unknown31)super.clone();
         var1.d = (long[])var1.d.clone();
         return var1;
      } catch (Exception var2) {
         throw new Error(var2);
      }
   }

   static int b(Unknown31 var0) {
      return var0.b--;
   }

   public boolean retainAll(@NotNull Collection var1) {
      if (!(var1 instanceof Unknown31)) {
         return super.retainAll(var1);
      } else {
         Unknown31 var5 = (Unknown31)var1;
         long[] var6 = Arrays.copyOf(this.d, this.d.length);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var6[var7] &= var5.d[var7];
         }

         this.d = var6;
         return this.c();
      }
   }

   public boolean isEmpty() {
      return this.b == 0;
   }

   public boolean add(Object var1) {
      return this.a((Enum)var1);
   }

   public boolean contains(Object var1) {
      int var5 = ((Enum)var1).ordinal();
      return (this.d[var5 >>> 6] & 1L << var5) != 0L;
   }

   public static Unknown31 a(Class var0) {
      Enum[] var1 = (Enum[])var0.getEnumConstants();
      return new Unknown31(var0, var1);
   }

   public int size() {
      return this.b;
   }

   static long[] a(Unknown31 var0, long[] var1) {
      return var0.d = var1;
   }

   private boolean c() {
      int var4 = this.b;
      this.b = 0;

      for(long var8 : this.d) {
         this.b += Long.bitCount(var8);
      }

      return this.b != var4;
   }

   public boolean removeAll(Collection var1) {
      if (!(var1 instanceof Unknown31)) {
         return super.removeAll(var1);
      } else {
         Unknown31 var5 = (Unknown31)var1;
         long[] var6 = Arrays.copyOf(this.d, this.d.length);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var6[var7] &= ~var5.d[var7];
         }

         this.d = var6;
         return this.c();
      }
   }

   public Object clone() {
      return this.a();
   }

   public boolean a(Enum var1) {
      int var5 = var1.ordinal();
      int var6 = var5 >>> 6;
      long[] var7 = Arrays.copyOf(this.d, this.d.length);
      long var8 = var7[var6];
      var7[var6] |= 1L << var5;
      boolean var10 = var7[var6] != var8;
      this.d = var7;
      if (var10) {
         ++this.b;
      }

      return var10;
   }

   static long[] a(Unknown31 var0) {
      return var0.d;
   }

   public boolean remove(Object var1) {
      long[] var5 = Arrays.copyOf(this.d, this.d.length);
      int var6 = ((Enum)var1).ordinal();
      int var7 = var6 >>> 6;
      long var8 = var5[var7];
      var5[var7] &= ~(1L << var6);
      boolean var10 = var5[var7] != var8;
      if (var10) {
         --this.b;
      }

      this.d = var5;
      return var10;
   }

   @NotNull
   public Iterator iterator() {
      return new ol(this);
   }

   static Enum[] c(Unknown31 var0) {
      return var0.c;
   }

   Unknown31(Class var1, Enum[] var2) {
      this.a = var1;
      this.c = var2;
      this.d = new long[var2.length + 63 >>> 6];
   }

   public void d() {
      Arrays.fill(this.d, -1L);
      long[] var1 = Arrays.copyOf(this.d, this.d.length);
      var1[var1.length - 1] >>>= -this.c.length;
      this.d = var1;
      this.b = this.c.length;
   }
}
