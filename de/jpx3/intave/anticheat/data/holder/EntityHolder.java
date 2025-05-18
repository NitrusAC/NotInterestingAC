package de.jpx3.intave.anticheat.data.holder;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedAttribute;
import com.comphenix.protocol.wrappers.WrappedAttributeModifier;
import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.engine.util.GameMode;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import org.bukkit.entity.Player;

@Relocate
public final class EntityHolder {
   private GameMode playerData = GameMode.UNKNOWN;
   private boolean flying;
   private boolean allowFlight;
   private final Map cache;
   public boolean l;
   private float walkSpeed;
   private GameMode e = GameMode.UNKNOWN;
   public int lastHealthUpdate;
   private static final double j = 1000.0;
   public float playerHealth;
   public int foodLevel;
   public static final Predicate movementSpeed = EntityHolder::d;
   private float flySpeed = 0.05F;
   private static final boolean m = MinecraftVersion.V_1_16.atOrAbove();
   public float playerMaxHealth;
   private static final Map h;
   private final Player player;
   private static final UUID c = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
   private final Map attributeMap;

   public void setMovementSpeed(float speed) {
      this.setAttribute("generic.movementSpeed", (double)speed);
   }

   private static boolean a(int var0, GameMode var1) {
      return var1.getGameMode() == var0;
   }

   private double round(double value) {
      return (double)Math.round(value * 1000.0) / 1000.0;
   }

   private void updateAttribute(String name, double value) {
      name = this.c(name);
      PacketContainer var4 = ProtocolLibrary.getProtocolManager().createPacket(Server.UPDATE_ATTRIBUTES);
      WrappedAttribute var5 = WrappedAttribute.newBuilder().attributeKey(name).baseValue(value).packet(var4).build();
      this.attributeMap.put(name, this._createAttribute(var5));
      this.cache.put(name, new CopyOnWriteArrayList());
   }

   public boolean isGamemode(GameMode var1) {
      return this.playerData == var1 || this.e == var1;
   }

   public void c(GameMode var1) {
      if (this.playerData == GameMode.SPECTATOR && var1 == GameMode.CREATIVE) {
         this.setAllowFlight(true);
         this.setFlying(true);
      }

      this.playerData = var1;
   }

   public void a(GameMode var1) {
      this.e = var1;
   }

   public WrappedAttribute getAttribute(String var1) {
      var1 = this.c(var1);
      return (WrappedAttribute)this.attributeMap.get(var1);
   }

   public double getAttribute(String var1, Predicate var2) {
      var1 = this.c(var1);

      for(Entry var4 : this.cache.entrySet()) {
         WrappedAttribute var5 = (WrappedAttribute)this.attributeMap.get(var4.getKey());
         if (var5 != null && this.c(var5.getAttributeKey()).equals(var1)) {
            List var6 = (List)var4.getValue();
            if (!var6.isEmpty()) {
               var6 = new ArrayList(var6);
               var6.removeIf(var2.negate());
               var5 = var5.withModifiers(var6);
            }

            return var5.getFinalValue();
         }
      }

      return Double.NaN;
   }

   private WrappedAttribute _createAttribute(WrappedAttribute var1) {
      double var2 = this.round(var1.getBaseValue());
      return WrappedAttribute.newBuilder(var1).baseValue(var2).build();
   }

   public float getFlySpeed() {
      return this.flySpeed;
   }

   public boolean canFly() {
      return this.flying || this.player.getAllowFlight();
   }

   public double a(String var1) {
      return this.getAttribute(var1, EntityHolder::b);
   }

   public void setFlySpeed(float flySpeed) {
      this.flySpeed = flySpeed;
   }

   public void setAllowFlight(boolean allowFlight) {
      this.allowFlight = allowFlight;
   }

   public void setFlying(boolean flying) {
      this.flying = flying;
   }

   private String c(String var1) {
      return m ? (String)h.getOrDefault(var1, var1) : var1;
   }

   public void resetSpeed() {
      boolean var3 = MinecraftVersion.V_1_16.atOrAbove();
      this.updateAttribute("generic.movementSpeed", var3 ? 0.1F : 0.1);
   }

   public boolean isSpectator() {
      return this.isGamemode(GameMode.SPECTATOR) || this.l;
   }

   public boolean d() {
      return this.allowFlight;
   }

   static {
      HashMap var11 = new HashMap();
      var11.put("generic.maxHealth", "generic.max_health");
      var11.put("generic.followRange", "generic.follow_range");
      var11.put("generic.knockbackResistance", "generic.knockback_resistance");
      var11.put("generic.movementSpeed", "generic.movement_speed");
      var11.put("generic.attackDamage", "generic.attack_damage");
      var11.put("generic.attackSpeed", "generic.attack_speed");
      var11.put("generic.armorToughness", "generic.armor_toughness");
      var11.put("generic.attackKnockback", "generic.attack_knockback");
      var11.put("horse.jumpStrength", "horse.jump_strength");
      var11.put("zombie.spawnReinforcements", "zombie.spawn_reinforcements");
      h = ImmutableMap.copyOf(var11);
   }

   public boolean isGameMode(org.bukkit.GameMode gameMode) {
      return this.playerData.getGameMode() == gameMode.getValue();
   }

   public boolean isGamemodeWtf(GameMode gameMode) {
      return this.playerData == gameMode;
   }

   public EntityHolder(Player player) {
      this.walkSpeed = 0.1F;
      this.attributeMap = new ConcurrentHashMap();
      this.cache = new ConcurrentHashMap();
      this.player = player;
      boolean var2 = player != null;
      if (var2) {
         this.allowFlight = player.getAllowFlight();
         this.flying = player.isFlying();
         this.playerMaxHealth = (float)player.getHealth();
         this.playerHealth = this.playerMaxHealth;
         this.foodLevel = player.getFoodLevel();
         this.setGameMode(player.getGameMode());
         this.walkSpeed = player.getWalkSpeed() / 2.0F;
         this.flySpeed = player.getFlySpeed() / 2.0F;
         this.resetSpeed();
      } else {
         this.allowFlight = this.flying = false;
         this.playerMaxHealth = 20.0F;
         this.playerHealth = this.playerMaxHealth;
      }

   }

   private static boolean b(WrappedAttributeModifier var0) {
      return true;
   }

   public List b(WrappedAttribute var1) {
      return (List)this.cache.get(this.c(var1.getAttributeKey()));
   }

   public void setAttribute(String var1, double var2) {
      var1 = this.c(var1);
      WrappedAttribute var4 = this.getAttribute(var1);
      if (var4 != null) {
         this.attributeMap.put(var1, WrappedAttribute.newBuilder(var4).baseValue(var2).modifiers(Collections.emptyList()).build());
         List var5 = this.b(var4);
         this.cache.remove(var1);
         this.cache.put(var1, var5);
      }

   }

   private void setGameMode(org.bukkit.GameMode var1) {
      if (var1 == null) {
         Logger.getLogger().warn("Player " + this.player.getName() + " has no game mode set, this is quite dangerous and may lead to unexpected behaviour.");
      }

      int var4 = var1 == null ? -1 : var1.getValue();
      this.playerData = (GameMode)Arrays.stream(GameMode.values()).filter(EntityHolder::a).findFirst().orElse(GameMode.UNKNOWN);
      this.e = this.playerData;
   }

   private static boolean d(WrappedAttributeModifier var0) {
      return !var0.getUUID().equals(c);
   }
}
