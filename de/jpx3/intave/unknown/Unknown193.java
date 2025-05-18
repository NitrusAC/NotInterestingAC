package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.jpx3.intave.cf;
import de.jpx3.intave.access.player.PlayerConnection;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.FilteredMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.bukkit.entity.Player;

public final class Unknown193 {
   private final Map e;
   private final Map d = Unknown19.a((Map)FilteredMap.b(Maps.newConcurrentMap()));
   private final IntavePlugin c;

   public synchronized PlayerConnection a(Player var1) {
      Preconditions.checkNotNull(var1);
      return (PlayerConnection)this.d.computeIfAbsent(var1.getUniqueId(), this::a);
   }

   static Map a(Unknown193 var0) {
      return var0.e;
   }

   public Unknown193(IntavePlugin var1) {
      this.e = Unknown19.a(Maps.newConcurrentMap());
      this.c = var1;
   }

   private static void b(int var0, int var1, BiConsumer var2) {
      var2.accept(var0, var1);
   }

   private PlayerConnection a(Player var1, UUID var2) {
      return this.b(var1);
   }

   public void a(Player var1, int var2, int var3) {
      List var7 = (List)this.e.get(var1.getUniqueId());
      if (var7 != null) {
         var7.forEach(Unknown193::b);
      }

   }

   private PlayerConnection b(Player var1) {
      return new cf(this, var1);
   }
}
