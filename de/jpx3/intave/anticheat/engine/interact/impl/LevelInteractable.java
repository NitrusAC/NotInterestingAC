package de.jpx3.intave.anticheat.engine.interact.impl;

import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown104;
import de.jpx3.intave.unknown.Unknown121;
import de.jpx3.intave.unknown.Unknown258;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class LevelInteractable implements Interactable {
   private final Interactable a;

   @Override
   public void a(Material var1) {
      this.a.a(var1);
   }

   @Override
   public Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7) {
      if (this.isPassthrough(var3)) {
         Unknown258.a();
         return Unknown121.a();
      } else {
         return this.a.interact(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   private boolean isPassthrough(Material var1) {
      if (MaterialUtil.isLiquid(var1)) {
         return true;
      } else {
         switch(Unknown104.a[var1.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
               return true;
            default:
               return false;
         }
      }
   }

   public LevelInteractable(Interactable var1) {
      this.a = var1;
   }
}
