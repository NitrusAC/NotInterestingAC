package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.GameMode;
import de.jpx3.intave.anticheat.util.EnchantUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class Unknown159 {
   private static final Set i = Sets.newHashSet();
   private static final Set e = Sets.newHashSet();
   private static final Set a = Sets.newHashSet();
   private static final Set d = Sets.newHashSet();
   private static final Set b = Sets.newHashSet();
   private static final Set f = Sets.newHashSet();
   public static final Material g = d("TRIDENT");
   private static final Set c = Sets.newHashSet();

   private static void a(List var0, Set var1) {
      var0.stream().map(Unknown159::d).forEach(var1::add);
   }

   public static boolean b(Player var0, Material var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var0);
      EntityHolder var6 = var5.getStorage().getEntityHolder();
      boolean var7 = var6.isGamemodeWtf(GameMode.CREATIVE);
      if (var7) {
         return false;
      } else if (e.contains(var1)) {
         return var5.getPlayer().getFoodLevel() < 20;
      } else {
         return b.contains(var1);
      }
   }

   private static void e() {
      f.add(Material.POTION);
      f.add(d("SPLASH_POTION"));
   }

   public static boolean a(Player var0, @k3 ItemStack var1) {
      Material var5 = var1 == null ? Material.AIR : var1.getType();
      if (g != null && var5 == g) {
         PlayerData var9 = PlayerDataManager.getPlayerData(var0);
         return a(var9, var1);
      } else if (var5 == Material.BOW && !a(var0, i)) {
         return false;
      } else {
         boolean var6 = c.contains(var5);
         boolean var7 = f.contains(var5);
         boolean var8 = a.contains(var5);
         return var8 || var6 || var7 || b(var0, var5);
      }
   }

   private static Material d(String var0) {
      Material var1 = Material.getMaterial(var0);
      return var1 != null ? var1 : (Material)Arrays.stream(Material.values()).filter(Unknown159::b).findFirst().orElse(null);
   }

   public static boolean b(Material var0) {
      return f.contains(var0);
   }

   private static boolean b(String var0, Material var1) {
      return var1.name().equalsIgnoreCase(var0);
   }

   private static boolean a(Player var0, Collection var1) {
      PlayerInventory var5 = var0.getInventory();

      for(ItemStack var9 : var5.getContents()) {
         if (var9 != null && var1.contains(var9.getType())) {
            return true;
         }
      }

      return false;
   }

   private static boolean a(Player var0, Material var1) {
      PlayerInventory var5 = var0.getInventory();

      for(ItemStack var9 : var5.getContents()) {
         if (var9 != null && var9.getType() == var1) {
            return true;
         }
      }

      return false;
   }

   public static void a() {
      try {
         MinecraftVersion var0 = ServerUtil.getServerVersion();
         a(var0);
         e();
         d();
         c();
      } catch (Exception var1) {
         throw new IllegalStateException(var1);
      }
   }

   private static boolean a(String var0, Material var1) {
      return var1.name().toLowerCase().contains(var0.toLowerCase());
   }

   public static boolean a(@k3 ItemStack var0) {
      Material var4 = var0 == null ? Material.AIR : var0.getType();
      return a.contains(var4);
   }

   private static List c(String var0) {
      return (List)Arrays.stream(Material.values()).filter(Unknown159::a).collect(Collectors.toList());
   }

   private static void d() {
      ArrayList var2 = Lists.newArrayList(
         new String[]{
            "apple",
            "bread",
            "porkchop",
            "cooked_porkchop",
            "pork",
            "grilled_pork",
            "cookie",
            "melon",
            "beef",
            "raw_beef",
            "cooked_beef",
            "chicken",
            "cooked_chicken",
            "rotten_flesh",
            "spider_eye",
            "baked_potato",
            "poisonous_potato",
            "golden_carrot",
            "pumpkin_pie",
            "rabbit",
            "cooked_rabbit",
            "mutton",
            "cooked_mutton",
            "mushroom_soup",
            "raw_fish",
            "cooked_fish",
            "raw_chicken",
            "carrot_item",
            "potato_item",
            "rabbit_stew"
         }
      );
      ArrayList var3 = Lists.newArrayList(new String[]{"golden_apple", "enchanted_golden_apple"});
      a(var2, e);
      a(var3, b);
   }

   public static boolean a(Material var0) {
      return d.contains(var0);
   }

   private static void a(MinecraftVersion var0) {
      if (var0.isAtLeast(de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_13)) {
         c.add(d("TRIDENT"));
      }

      if (var0.isAtLeast(de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_9)) {
         c.add(d("SHIELD"));
      }

      d.addAll(c("TRAP_DOOR"));
      d.addAll(c("TRAPDOOR"));
      a.addAll(c("SWORD"));
      c.add(Material.BOW);
   }

   public static boolean c(Material var0) {
      return var0 == Material.BOW;
   }

   private static void c() {
      i.addAll(c("ARROW"));
   }

   private static boolean a(PlayerData var0, ItemStack var1) {
      Player var5 = var0.getPlayer();
      World var6 = var5.getWorld();
      BukkitEnginePlayer var7 = var0.getStorage().getPhysicsHolder();
      if (!EnchantUtil.hasRiptide(var1)) {
         return true;
      } else {
         return var7.inWater || var6.isThundering() || var6.hasStorm();
      }
   }
}
