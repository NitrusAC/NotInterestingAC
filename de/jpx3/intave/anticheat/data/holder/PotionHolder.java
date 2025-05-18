package de.jpx3.intave.anticheat.data.holder;

import de.jpx3.intave.Relocate;
import java.util.Collection;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

@Relocate
public final class PotionHolder {
   private int slownessEffectAmplifier;
   public int slownessEffectDuration;
   public int speedEffectDuration;
   private int speedEffectAmplifier = 0;
   public int jumpBoostEffectDuration;
   private int jumpBoostEffectAmplifier;

   public int getSlownessAmplifiier() {
      return this.slownessEffectAmplifier;
   }

   public PotionHolder(Player var1) {
      this.speedEffectDuration = 0;
      this.slownessEffectAmplifier = 0;
      this.slownessEffectDuration = 0;
      this.jumpBoostEffectAmplifier = 0;
      this.jumpBoostEffectDuration = 0;
      if (var1 != null) {
         this.addPotionEffects(var1.getActivePotionEffects());
      }

   }

   private void addPotionEffect(PotionEffect var1) {
      int var2 = var1.getDuration();
      int var3 = var1.getAmplifier();
      switch(var1.getType().getId()) {
         case 1:
            this.speedEffectDuration = var2;
            this.speedEffectAmplifier = var3;
            break;
         case 2:
            this.slownessEffectDuration = var2;
            this.slownessEffectAmplifier = var3;
            break;
         case 8:
            this.jumpBoostEffectDuration = var2;
            this.jumpBoostEffectAmplifier = var3;
      }

   }

   public void resetEffects() {
      this.speedEffectDuration = 0;
      this.speedEffectAmplifier = 0;
      this.slownessEffectDuration = 0;
      this.slownessEffectAmplifier = 0;
      this.jumpBoostEffectDuration = 0;
      this.jumpBoostEffectAmplifier = 0;
   }

   public void setSlownessAmplifier(int var1) {
      this.slownessEffectAmplifier = var1;
   }

   public int getJumpBoostAmplifier() {
      return this.jumpBoostEffectAmplifier;
   }

   public void setSpeedAmplifier(int var1) {
      this.speedEffectAmplifier = var1;
   }

   public int getSpeedAmplifier() {
      return this.speedEffectAmplifier;
   }

   private void addPotionEffects(Collection var1) {
      for(PotionEffect var3 : var1) {
         this.addPotionEffect(var3);
      }

   }

   public void setJumpBoostAmplifier(int var1) {
      this.jumpBoostEffectAmplifier = var1;
   }
}
