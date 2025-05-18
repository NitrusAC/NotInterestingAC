package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.access.IntaveResourceCompilationException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bukkit.Material;

public final class Unknown6 implements Unknown150 {
   private final Pattern a = Pattern.compile("^from ([0-9]+(\\.[0-9]+)+) down to ([0-9]+(\\.[0-9]+)+) interpret$", 2);

   private static boolean b(String var0) {
      return var0.startsWith("#");
   }

   public Unknown402 a(List var1) {
      var1.removeIf(String::isEmpty);
      var1.removeIf(Unknown6::b);
      MinecraftVersion var6 = null;
      MinecraftVersion var7 = null;
      ArrayList var8 = new ArrayList();

      for(String var10 : var1) {
         boolean var11 = var10.startsWith("  ");

         try {
            if (var11) {
               if (var6 == null) {
                  throw new IntaveResourceCompilationException("Mapping entered without selector");
               }

               String[] var12 = var10.trim().split(" as ");
               String var13 = var12[0];
               String var14 = var12[1];
               Material var15 = c(var13);
               Material var16 = c(var14);
               if (var15 != null && var16 != null) {
                  var8.add(new Unknown39(var6, var7, var15, var16));
               }
            } else {
               if (!this.a.matcher(var10).matches()) {
                  throw new IntaveResourceCompilationException("Invalid selector pattern");
               }

               int var18 = a(var10, "from ");
               int var19 = var10.indexOf(" ", var18);
               var6 = new MinecraftVersion(var10.substring(var18, var19));
               int var20 = a(var10, "to ");
               int var21 = var10.indexOf(" ", var20);
               var7 = new MinecraftVersion(var10.substring(var20, var21));
            }
         } catch (IntaveResourceCompilationException var17) {
            throw new IntaveResourceCompilationException("Failed to compile line " + var10 + ": " + var17.getMessage());
         }
      }

      return Unknown402.a(var8);
   }

   private static Material c(String var0) {
      Material var4 = Material.matchMaterial(var0);
      if (var4 == null) {
         var4 = Material.getMaterial(var0);
         if (var4 == null && de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_14.atOrAbove()) {
            var4 = Material.matchMaterial("LEGACY_" + var0);
            if (var4 == null) {
               var4 = Material.getMaterial("LEGACY_" + var0);
            }
         }
      }

      return var4;
   }

   public Object apply(Object var1) {
      return this.a((List)var1);
   }

   private static int a(String var0, String var1) {
      return var0.indexOf(var1) + var1.length();
   }
}
