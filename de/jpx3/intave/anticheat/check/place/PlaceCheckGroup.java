package de.jpx3.intave.anticheat.check.place;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown4;

public final class PlaceCheckGroup extends AbstractCheck {
   private final IntavePlugin plugin;
   public static final String m;

   public PlaceCheckGroup(IntavePlugin intavePlugin) {
      super("PlacementAnalysis", "placementanalysis");
      this.plugin = intavePlugin;
      this.a();
   }

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }

   public void a(PlayerData var1, String var2) {
      var1.a(Unknown227.CANCEL_FIRST, var2);
      var1.a(Unknown227.HT_MEDIUM, var2);
   }

   public native void a();
}
