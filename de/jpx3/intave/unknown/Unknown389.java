package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.jpx3.intave.e7;
import de.jpx3.intave.access.player.PlayerAccess;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.FilteredMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

public final class Unknown389 {
   private final Map a = Unknown19.a((Map)FilteredMap.b(Maps.newConcurrentMap()));
   private final Unknown235 b;
   private static final Map e = new HashMap();
   private final IntavePlugin c;
   private final Unknown193 d;

   static Map c() {
      return e;
   }

   static IntavePlugin b(Unknown389 var0) {
      return var0.c;
   }

   public synchronized PlayerAccess b(Player var1) {
      Preconditions.checkNotNull(var1);
      return (PlayerAccess)this.a.computeIfAbsent(var1.getUniqueId(), this::b);
   }

   static Unknown193 a(Unknown389 var0) {
      return var0.d;
   }

   private PlayerAccess b(Player var1, UUID var2) {
      return this.a(var1);
   }

   static Unknown235 c(Unknown389 var0) {
      return var0.b;
   }

   private PlayerAccess a(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      Map var3 = var2.getStorage().e().j;
      return new e7(this, var2, var1, var3);
   }

   public Unknown235 b() {
      return this.b;
   }

   public Unknown389(IntavePlugin var1) {
      this.c = var1;
      this.d = new Unknown193(var1);
      this.b = new Unknown235(var1);
   }

   public Unknown193 a() {
      return this.d;
   }
}
