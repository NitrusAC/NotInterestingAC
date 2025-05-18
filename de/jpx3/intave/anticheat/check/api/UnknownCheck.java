package de.jpx3.intave.anticheat.check.api;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.unknown.Unknown328;

public abstract class UnknownCheck implements Check {
   protected IntavePlugin plugin;
   private Unknown328 d;

   public IntavePlugin getPlugin() {
      return this.plugin;
   }

   public Unknown328 b() {
      return this.d;
   }

   public void a(Unknown328 var1) {
      this.d = var1;
   }

   public void refreshConfig() {
   }

   public void setPlugin(IntavePlugin plugin) {
      this.plugin = plugin;
   }

   protected UnknownCheck() {
   }

   public void e() {
   }
}
