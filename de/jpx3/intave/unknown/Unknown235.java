package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.jpx3.intave.cE;
import de.jpx3.intave.access.player.PlayerClicks;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.FilteredMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import org.bukkit.entity.Player;

public final class Unknown235 {
   private final Map a = Unknown19.a((Map)FilteredMap.b(Maps.newConcurrentMap()));
   private final Map c = Unknown19.a(Maps.newConcurrentMap());
   private final IntavePlugin b;

   private PlayerClicks b(Player var1, UUID var2) {
      return this.a(var1);
   }

   public PlayerClicks b(Player var1) {
      Preconditions.checkNotNull(var1);
      return (PlayerClicks)this.a.computeIfAbsent(var1.getUniqueId(), this::b);
   }

   public Unknown235(IntavePlugin var1) {
      this.b = var1;
   }

   private PlayerClicks a(Player var1) {
      return new cE(this, var1);
   }

   static Map a(Unknown235 var0) {
      return var0.c;
   }

   public void a(Player var1, int var2) {
      List var6 = (List)this.c.get(var1.getUniqueId());
      if (var6 != null) {
         for(Consumer var8 : var6) {
            var8.accept(var2);
         }
      }

   }
}
