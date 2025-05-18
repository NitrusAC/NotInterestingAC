package de.jpx3.intave.anticheat.engine.util;

import de.jpx3.intave.c;

public enum GameMode {
   private static final GameMode[] values = new GameMode[]{GameMode.UNKNOWN, GameMode.SURVIVAL, GameMode.CREATIVE, GameMode.ADVENTURE, GameMode.SPECTATOR};
   public static final GameMode UNKNOWN = new GameMode(-1);
   private final int id;
   public static final GameMode SPECTATOR = new GameMode(3);
   public static final GameMode CREATIVE = new GameMode(1);
   public static final GameMode SURVIVAL = new GameMode(0);
   private static final String j;
   public static final GameMode ADVENTURE = new GameMode(2);

   private GameMode(int var3) {
      this.id = var3;
   }

   public int getGameMode() {
      return this.id;
   }

   public static int getId(GameMode mode) {
      return mode.id;
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static GameMode fromBukkit(org.bukkit.GameMode var0) {
      switch(c.a[var0.ordinal()]) {
         case 1:
            return SURVIVAL;
         case 2:
            return CREATIVE;
         case 3:
            return ADVENTURE;
         case 4:
            return SPECTATOR;
         default:
            throw new IllegalArgumentException("Unable to resolve game mode " + var0);
      }
   }
}
