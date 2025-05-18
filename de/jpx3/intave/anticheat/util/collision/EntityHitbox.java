package de.jpx3.intave.anticheat.util.collision;

import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.reach.ReachEntityType;
import de.jpx3.intave.unknown.Unknown346;
import java.util.HashMap;
import java.util.Map;

public final class EntityHitbox implements Unknown346 {
   private static final Map cache = new HashMap();

   private static void addItem(int var0, String var1, HitboxSize size) {
      cache.put(var0, new ReachEntityType(var1, size, var0, false, 10));
   }

   public static void create() {
      addItem(1, "Item", HitboxSize.of(0.25F, 0.25F));
      addItem(2, "XPOrb", HitboxSize.of(0.5F, 0.5F));
      addItem(8, "LeashKnot", HitboxSize.of(0.5F, 0.5F));
      addItem(9, "Painting", HitboxSize.of(0.5F, 0.5F));
      addItem(10, "Arrow", HitboxSize.of(0.5F, 0.5F));
      addItem(11, "Snowball", HitboxSize.of(0.25F, 0.25F));
      addItem(12, "Fireball", HitboxSize.of(3.0F, 3.0F));
      addItem(13, "SmallFireball", HitboxSize.of(1.0F, 1.0F));
      addItem(14, "ThrownEnderpearl", HitboxSize.of(0.25F, 0.25F));
      addItem(15, "EyeOfEnderSignal", HitboxSize.of(0.25F, 0.25F));
      addItem(16, "ThrownPotion", HitboxSize.of(0.25F, 0.25F));
      addItem(17, "ThrownExpBottle", HitboxSize.of(0.25F, 0.25F));
      addItem(18, "ItemFrame", HitboxSize.of(0.5F, 0.5F));
      addItem(19, "WitherSkull", HitboxSize.of(0.3125F, 0.3125F));
      addItem(20, "PrimedTnt", HitboxSize.of(0.98F, 0.98F));
      addItem(21, "FallingSand", HitboxSize.of(0.98F, 0.98F));
      addItem(22, "FireworksRocketEntity", HitboxSize.of(0.25F, 0.25F));
      addItem(30, "ArmorStand", HitboxSize.of(0.5F, 1.975F));
      addItem(41, "Boat", HitboxSize.of(1.5F, 0.6F));
      addItem(42, "Minecart", HitboxSize.of(0.98F, 0.7F));
      addItem(43, "MinecartChest", HitboxSize.of(0.98F, 0.7F));
      addItem(44, "MinecartFurnace", HitboxSize.of(0.98F, 0.7F));
      addItem(45, "MinecartTNT", HitboxSize.of(0.98F, 0.7F));
      addItem(46, "MinecartHopper", HitboxSize.of(0.98F, 0.7F));
      addItem(47, "MinecartMobSpawner", HitboxSize.of(0.98F, 0.7F));
      addItem(40, "MinecartCommandBlock", HitboxSize.of(0.98F, 0.7F));
      addEntity(48, "Mob", HitboxSize.of(0.0F, 0.0F));
      addEntity(49, "Monster", HitboxSize.of(0.0F, 0.0F));
      addEntity(50, "Creeper", HitboxSize.of(0.6F, 1.95F));
      addEntity(51, "Skeleton", HitboxSize.of(0.6F, 1.95F));
      addEntity(52, "Spider", HitboxSize.of(1.4F, 0.9F));
      addEntity(53, "Giant", HitboxSize.of(3.6000001F, 11.700001F));
      addEntity(54, "Zombie", HitboxSize.of(0.6F, 1.95F));
      addEntity(55, "Slime", HitboxSize.of(0.51000005F, 0.51000005F));
      addEntity(56, "Ghast", HitboxSize.of(4.0F, 4.0F));
      addEntity(57, "PigZombie", HitboxSize.of(0.6F, 1.95F));
      addEntity(58, "Enderman", HitboxSize.of(0.6F, 2.9F));
      addEntity(59, "CaveSpider", HitboxSize.of(0.7F, 0.5F));
      addEntity(60, "Silverfish", HitboxSize.of(0.4F, 0.3F));
      addEntity(61, "Blaze", HitboxSize.of(0.6F, 1.95F));
      addEntity(62, "LavaSlime", HitboxSize.of(0.51000005F, 0.51000005F));
      addEntity(63, "EnderDragon", HitboxSize.of(16.0F, 8.0F));
      addEntity(64, "WitherBoss", HitboxSize.of(0.9F, 3.5F));
      addEntity(65, "Bat", HitboxSize.of(0.5F, 0.9F));
      addEntity(66, "Witch", HitboxSize.of(0.6F, 1.95F));
      addEntity(67, "Endermite", HitboxSize.of(0.4F, 0.3F));
      addEntity(68, "Guardian", HitboxSize.of(0.85F, 0.85F));
      addEntity(90, "Pig", HitboxSize.of(0.9F, 0.9F));
      addEntity(91, "Sheep", HitboxSize.of(0.9F, 1.3F));
      addEntity(92, "Cow", HitboxSize.of(0.9F, 1.3F));
      addEntity(93, "Chicken", HitboxSize.of(0.4F, 0.7F));
      addEntity(94, "Squid", HitboxSize.of(0.95F, 0.95F));
      addEntity(95, "Wolf", HitboxSize.of(0.6F, 0.8F));
      addEntity(96, "MushroomCow", HitboxSize.of(0.9F, 1.3F));
      addEntity(97, "SnowMan", HitboxSize.of(0.7F, 1.9F));
      addEntity(98, "Ozelot", HitboxSize.of(0.6F, 0.7F));
      addEntity(99, "VillagerGolem", HitboxSize.of(1.4F, 2.9F));
      addEntity(100, "Horse", HitboxSize.of(1.4F, 1.6F));
      addEntity(101, "Rabbit", HitboxSize.of(0.6F, 0.7F));
      addEntity(105, "Player", HitboxSize.of(0.6F, 1.8F));
      addEntity(120, "Villager", HitboxSize.of(0.6F, 1.8F));
      addItem(200, "EnderCrystal", HitboxSize.of(2.0F, 2.0F));
   }

   @Override
   public ReachEntityType a(int var1, boolean var2) {
      return var1 != -1 ? (ReachEntityType)cache.get(var1) : null;
   }

   private static void addEntity(int typeId, String name, HitboxSize size) {
      cache.put(typeId, new ReachEntityType(name, size, typeId, true, 9));
   }
}
