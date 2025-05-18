package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.version.VersionRange;
import java.util.ArrayList;
import java.util.List;

public final class Unknown208 implements Unknown1 {
   public Unknown314 a(List var1) {
      int var5 = Integer.MIN_VALUE;
      ArrayList var6 = new ArrayList();

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         String var8 = ((String)var1.get(var7)).trim();
         if (!var8.startsWith("#")) {
            if (var8.startsWith("up to")) {
               String[] var9 = var8.split(" ");
               if (var9.length != 5) {
                  System.out.println("Invalid line format: " + var8 + " at line " + var7);
                  Thread.dumpStack();
               } else {
                  int var10 = Integer.parseInt(var9[2]);
                  String var11 = var9[4];
                  var6.add(new VersionRange(var5 + 1, var10, var11));
                  var5 = var10;
               }
            } else {
               String[] var12 = var8.split(" is ");
               if (var12.length != 2) {
                  System.out.println("Invalid line format: " + var8 + " at line " + var7);
                  Thread.dumpStack();
               } else {
                  int var13 = Integer.parseInt(var12[0]);
                  String var14 = var12[1];
                  if (var13 <= var5) {
                     System.out.println("Invalid line format: " + var8 + " at line " + var7);
                     Thread.dumpStack();
                  } else {
                     var6.add(new VersionRange(var13, var13, var14));
                     var5 = var13;
                  }
               }
            }
         }
      }

      return new Unknown314(var6);
   }

   public Object apply(Object var1) {
      return this.a((List)var1);
   }
}
