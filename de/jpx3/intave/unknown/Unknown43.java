package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.reflection.ClassLocation;
import de.jpx3.intave.anticheat.reflection.FieldLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Unknown43 implements Unknown1 {
   private List a(String var1, Unknown337 var2, List var3) {
      ArrayList var7 = new ArrayList();

      for(String var9 : var3) {
         if (var9.endsWith("}")) {
            break;
         }

         String[] var10 = var9.split("->");
         String var11 = var10[0].trim().replace("\"", "");
         String var12 = var10[1].trim().replace("\"", "");
         var7.add(new Unknown98(var1, var11, var2, var12));
      }

      return var7;
   }

   public Object apply(Object var1) {
      return this.a((List)var1);
   }

   public static Unknown43 a() {
      return new Unknown43();
   }

   private Unknown337 a(String var1) {
      try {
         if (var1.startsWith("[")) {
            if (!var1.endsWith("]")) {
               throw new IllegalStateException();
            } else {
               String[] var5 = var1.substring(1, var1.length() - 1).split("-");
               return Unknown337.a(Integer.parseInt(var5[0]), Integer.parseInt(var5[1]));
            }
         } else {
            return Unknown337.b(Integer.parseInt(var1));
         }
      } catch (Exception var6) {
         throw new IllegalStateException("Unable to resolve matcher from input " + var1);
      }
   }

   private List b(String var1, List var2) {
      if (var2.isEmpty()) {
         return Collections.emptyList();
      } else {
         var2 = new ArrayList(var2);
         ArrayList var6 = new ArrayList();

         while(!var2.isEmpty()) {
            String var7 = (String)var2.remove(0);
            String var8 = var7.split("->")[0].trim();
            int var9 = var2.indexOf("}");
            if (var9 < 0) {
               throw new IllegalStateException("Unable to locate next end block in class " + var1);
            }

            List var10 = var2.subList(0, var9 + 1);
            var6.addAll(this.a(var1, this.a(var8), var10));
            var2.subList(0, var9 + 1).clear();
         }

         return var6;
      }
   }

   private List c(String var1, List var2) {
      if (var2.isEmpty()) {
         return Collections.emptyList();
      } else {
         var2 = new ArrayList(var2);
         ArrayList var6 = new ArrayList();

         while(!var2.isEmpty()) {
            String var7 = (String)var2.remove(0);
            String var8 = var7.split("->")[0].trim();
            int var9 = var2.indexOf("}");
            if (var9 < 0) {
               throw new IllegalStateException("End block expected in " + var1 + " of " + var2);
            }

            List var10 = var2.subList(0, var9 + 1);
            var6.addAll(this.b(var1, this.a(var8), var10));
            var2.subList(0, var9 + 1).clear();
         }

         return var6;
      }
   }

   private List a(String var1, List var2) {
      return (List)var2.stream().map(this::b).collect(Collectors.toList());
   }

   private ClassLocation a(String var1, String var2) {
      String[] var6 = var2.split("->");
      String var7 = var6[0].trim();
      String var8 = var6[1].trim().replace("/", ".");
      if (var8.equals("[nms-default]")) {
         var8 = "net.minecraft.server.{version}." + var1;
      } else {
         var8 = var8.replace("\"", "");
      }

      Unknown337 var9 = this.a(var7);
      return new ClassLocation(var1, var9, var8);
   }

   private ClassLocation b(String var1, String var2) {
      return this.a(var1, var2);
   }

   private List b(String var1, Unknown337 var2, List var3) {
      ArrayList var7 = new ArrayList();

      for(String var9 : var3) {
         if (var9.endsWith("}")) {
            break;
         }

         String[] var10 = var9.split("->");
         String var11 = var10[0].trim().replace("\"", "");
         String var12 = var10[1].trim().replace("\"", "");
         var7.add(new FieldLocation(var1, var11, var2, var12));
      }

      return var7;
   }

   public Unknown264 a(List var1) {
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();

      for(int var9 = 0; var9 < var1.size(); ++var9) {
         String var10 = (String)var1.get(var9);
         if (!var10.isEmpty() && !var10.startsWith("#") && !var10.trim().isEmpty()) {
            try {
               int var12 = var10.indexOf(" ");
               String var11 = var10.substring(0, var12);
               ArrayList var13 = new ArrayList();
               ArrayList var14 = new ArrayList();
               ArrayList var15 = new ArrayList();
               boolean var16 = false;
               boolean var17 = false;

               while(true) {
                  ++var9;
                  if ((var10 = (String)var1.get(var9)).equals("}")) {
                     var6.addAll(this.a(var11, var13));
                     var7.addAll(this.c(var11, var14));
                     var8.addAll(this.b(var11, var15));
                     break;
                  }

                  if (var10.startsWith("  methods {")) {
                     if (var16) {
                        throw new IllegalStateException("Method scope entrance whilst field scope still active");
                     }

                     var17 = true;
                  } else if (var10.startsWith("  fields {")) {
                     if (var16) {
                        throw new IllegalStateException("Field scope entrance whilst method scope still active");
                     }

                     var16 = true;
                  } else if (var10.startsWith("  }")) {
                     var17 = false;
                     var16 = false;
                  } else if (var16) {
                     var14.add(var10.trim());
                  } else if (var17) {
                     var15.add(var10.trim());
                  } else {
                     var13.add(var10.trim());
                  }
               }
            } catch (Exception var18) {
               Logger.getLogger().severe("Unable to compile line " + var9 + ": " + var10);
               var18.printStackTrace();
            }
         }
      }

      return new Unknown264(new Unknown238(var6), new Unknown117(var7), new Unknown9(var8));
   }
}
