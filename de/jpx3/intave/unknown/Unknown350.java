package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

final class Unknown350 extends Unknown361 implements Boxable {
   private Reference f;
   private static final String h;
   private final Boxable[] e;
   private static final Reference a = new WeakReference(null);

   @Override
   public boolean a() {
      for(Boxable var7 : this.e) {
         if (!var7.a()) {
            return false;
         }
      }

      return true;
   }

   @Override
   public List b() {
      if (this.f.get() == null) {
         ArrayList var4 = null;

         for(Boxable var8 : this.e) {
            List var9 = var8.b();
            if (!var9.isEmpty()) {
               if (var4 == null) {
                  var4 = new ArrayList(this.e.length);
               }

               if (var9.size() == 1) {
                  var4.add(var9.get(0));
               } else {
                  var4.addAll(var9);
               }
            }
         }

         Object var10 = var4 == null ? Collections.emptyList() : var4;
         this.f = new WeakReference(var10);
      }

      return (List)this.f.get();
   }

   @Override
   public Boxable a(int var1, int var2, int var3) {
      ArrayList var7 = new ArrayList();

      for(Boxable var11 : this.e) {
         var7.add(var11.a(var1, var2, var3));
      }

      return new Unknown350(var7);
   }

   public String toString() {
      return "(" + (String)Arrays.stream(this.e).map(Object::toString).collect(Collectors.joining(", ")) + ")";
   }

   @Override
   public double b(Direction var1) {
      double var5 = -2.14748365E9F;
      boolean var7 = false;

      for(Boxable var11 : this.e) {
         var5 = Math.max(var11.a(var1), var5);
         var7 = true;
      }

      return var7 ? var5 : 0.0;
   }

   @Override
   public boolean isInside(Box other) {
      for(Boxable var8 : this.e) {
         if (var8.isInside(other)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean c() {
      return this.e.length == 1 ? this.e[0].c() : false;
   }

   @Override
   public double calculateOffset(Direction var1, Box var2, double var3) {
      for(Boxable var11 : this.e) {
         var3 = var11.calculateOffset(var1, var2, var3);
      }

      return var3;
   }

   public Unknown350(List var1) {
      this.f = a;
      this.e = (Boxable[])var1.toArray(new Boxable[0]);
   }

   @Override
   public Boxable b(int var1, int var2, int var3) {
      ArrayList var7 = new ArrayList();

      for(Boxable var11 : this.e) {
         var7.add(var11.b(var1, var2, var3));
      }

      return new Unknown350(var7);
   }

   @Override
   public BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook) {
      BlockRaytrace var6 = null;

      for(Boxable var10 : this.e) {
         BlockRaytrace var11 = var10.raytrace(eyePosition, eyeLook);
         if (var11 != BlockRaytrace.getDefaultRaytrace()) {
            if (var6 == null) {
               var6 = var11;
            } else {
               var6 = var6.a(var11);
            }
         }
      }

      return var6;
   }

   @Override
   public double a(Direction var1) {
      double var5 = 2.147483647E9;
      boolean var7 = false;

      for(Boxable var11 : this.e) {
         var5 = Math.min(var11.a(var1), var5);
         var7 = true;
      }

      return var7 ? var5 : 0.0;
   }
}
