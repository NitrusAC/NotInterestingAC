package de.jpx3.intave.anticheat.block.impl;

import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import java.util.Locale;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class CauldronBlock extends Block {
   private static final Boxable modernBoxSet;
   private static final boolean isNewVersion = MinecraftVersion.V_1_13.atOrAbove();
   private static final Boxable legacyBoxSet;
   private static final String f;

   @Override
   public boolean isMaterial(Material material) {
      return material.name().toLowerCase(Locale.ROOT).contains("cauldron");
   }

   static {
      float var5 = 2.0F;
      modernBoxSet = Unknown121.c(
         Lists.newArrayList(
            new Box[]{
               Box.of(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
               Box.of(0.0, 0.0, 0.0, (double)var5, 16.0, 16.0),
               Box.of(0.0, 0.0, 0.0, 16.0, 16.0, (double)var5),
               Box.of((double)(16.0F - var5), 0.0, 0.0, 16.0, 16.0, 16.0),
               Box.of(0.0, 0.0, (double)(16.0F - var5), 16.0, 16.0, 16.0)
            }
         )
      );
      legacyBoxSet = Unknown121.c(
         Lists.newArrayList(
            new Box[]{
               Box.of(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
               Box.of(0.0, 0.0, 0.0, (double)var5, 16.0, 16.0),
               Box.of(0.0, 0.0, 0.0, 16.0, 16.0, (double)var5),
               Box.of((double)(16.0F - var5), 0.0, 0.0, 16.0, 16.0, 16.0),
               Box.of(0.0, 0.0, (double)(16.0F - var5), 16.0, 16.0, 16.0)
            }
         )
      );
   }

   CauldronBlock() {
      super(new Material[0]);
   }

   @Override
   protected Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var12 = PlayerDataManager.getPlayerData(player);
      if (var12.getStorage().getVersionHolder().isNewCollision()) {
         return isNewVersion ? box : legacyBoxSet;
      } else {
         return isNewVersion ? modernBoxSet : box;
      }
   }
}
