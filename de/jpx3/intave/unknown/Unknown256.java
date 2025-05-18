package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

final class Unknown256 implements Interactable {
   private final Set b = Unknown31.a(Material.class);
   private final Interactable a;
   private final Set c = Unknown31.a(Material.class);
   private static final String e;

   public static boolean a(World var0, int var1, int var2) {
      return var0.isChunkLoaded(var1 >> 4, var2 >> 4);
   }

   public boolean a(Material var1) {
      return this.c.contains(var1);
   }

   public boolean b(Material var1) {
      return this.b.contains(var1);
   }

   public void a() {
      for(Material var7 : Material.values()) {
         String var8 = var7.name();
         if (var8.contains("SLAB")) {
            this.c.add(var7);
         }
      }

   }

   @Override
   public Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7) {
      if (this.b(var3)) {
         Unknown258.a();
         return Unknown121.a(var5, var6, var7);
      } else if (this.a(var3)) {
         return this.a.interact(var1, var2, var3, var4, var5, var6, var7);
      } else {
         Boxable var11 = this.a.interact(var1, var2, var3, var4, var5, var6, var7);
         if (a(var1, var5, var7)) {
            if (var11.c()) {
               this.a(var3);
               this.b.add(var3);
            } else {
               this.c.add(var3);
            }
         }

         return var11;
      }
   }

   @Override
   public void a(Material var1) {
      this.b.remove(var1);
      this.c.remove(var1);
      this.a.a(var1);
   }

   public Unknown256(Interactable var1) {
      this.a = var1;
      this.a();
   }
}
