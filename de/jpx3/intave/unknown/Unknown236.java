package de.jpx3.intave.unknown;

import de.jpx3.intave.d1;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.util.collision.BoundingBoxBuilder;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

final class Unknown236 implements Interactable {
   private final Interactable a;

   @Override
   public void a(Material var1) {
      this.a.a(var1);
   }

   public Unknown236(Interactable var1) {
      this.a = var1;
   }

   public List a(Material var1, int var2) {
      if (var1 == IntaveMaterial.END_PORTAL) {
         d1 var8 = d1.b();
         var8.a(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
         boolean var7 = (var2 & 4) != 0;
         if (var7) {
            var8.a(4.0, 13.0, 4.0, 12.0, 16.0, 12.0);
         }

         return var8.c();
      } else {
         if (var1 == IntaveMaterial.SKULL) {
            BoundingBoxBuilder var6 = BoundingBoxBuilder.of();
            switch(var2 & 7) {
               case 1:
                  var6.bounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
                  break;
               case 2:
                  var6.bounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
                  break;
               case 3:
                  var6.bounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
                  break;
               case 4:
                  var6.bounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
                  break;
               case 5:
                  var6.bounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
            }
         }

         return null;
      }
   }

   @Override
   public Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7) {
      List var11 = this.a(var3, var4);
      return var11 != null ? Unknown121.c(var11).b(var5, var6, var7) : this.a.interact(var1, var2, var3, var4, var5, var6, var7);
   }
}
