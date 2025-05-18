package de.jpx3.intave.anticheat.util.reach;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.unknown.Unknown113;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class Interaction {
   private final PacketContainer b;
   private final World e;
   private final PlayerDigType c;
   private final Material itemTypeInHand;
   private final BlockPosition targetBlock;
   private final Unknown113 type;
   private final int targetDirection;
   private boolean entered = false;
   private final Hand hand;
   private final Player f;

   public Player a() {
      return this.f;
   }

   public Hand k() {
      return this.hand;
   }

   public Unknown113 d() {
      return this.type;
   }

   public int j() {
      return this.targetDirection;
   }

   public PlayerDigType g() {
      return this.c;
   }

   public String toString() {
      return "Interaction{targetBlock="
         + this.targetBlock
         + ", targetDirection="
         + this.targetDirection
         + ", type="
         + this.type
         + ", itemTypeInHand="
         + this.itemTypeInHand
         + ", hand="
         + this.hand
         + ", entered="
         + this.entered
         + '}';
   }

   public boolean b() {
      return this.entered;
   }

   public World h() {
      return this.e;
   }

   public Interaction(
      PacketContainer var1, World var2, Player var3, BlockPosition var4, int var5, Unknown113 var6, Material var7, Hand var8, PlayerDigType var9
   ) {
      this.b = var1;
      this.e = var2;
      this.f = var3;
      this.targetBlock = var4;
      this.targetDirection = var5;
      this.type = var6;
      this.itemTypeInHand = var7;
      this.hand = var8;
      this.c = var9;
   }

   public PacketContainer c() {
      return this.b;
   }

   public BlockPosition f() {
      return this.targetBlock;
   }

   public void i() {
      this.entered = true;
   }

   public Material e() {
      return this.itemTypeInHand;
   }
}
