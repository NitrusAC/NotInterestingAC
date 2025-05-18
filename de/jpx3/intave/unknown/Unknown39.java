package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import org.bukkit.Material;

public final class Unknown39 {
   private final MinecraftVersion b;
   private final Material d;
   private final MinecraftVersion a;
   private final Material c;

   public Unknown39(MinecraftVersion var1, MinecraftVersion var2, Material var3, Material var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public MinecraftVersion getVersion() {
      return this.a;
   }

   public MinecraftVersion a() {
      return this.b;
   }

   public Material c() {
      return this.d;
   }

   public Material d() {
      return this.c;
   }
}
