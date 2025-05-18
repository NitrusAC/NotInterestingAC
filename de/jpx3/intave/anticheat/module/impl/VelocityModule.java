package de.jpx3.intave.anticheat.module.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.unknown.Unknown148;
import java.util.List;
import org.bukkit.entity.Player;

public final class VelocityModule implements Module {
   private static final double compressAmount = 8000.0;
   private final List a = Lists.newArrayList();
   private final List c = Lists.newArrayList();

   private void b(double var1) {
      if (!this.c.contains(var1)) {
         this.c.add(var1);
      }

   }

   private void a(double var1) {
      if (!this.a.contains(var1)) {
         this.a.add(var1);
      }

   }

   private void a(Unknown148 var1, double var2, double var4, double var6) {
      var1.a(var2, var4, var6);
   }

   public List d() {
      return this.a;
   }

   public List c() {
      return this.c;
   }

   public VelocityModule(IntavePlugin var1) {
      var1.b().b(this);
   }

   @PacketListener(
      g = {ServerPacket.ENTITY_VELOCITY}
   )
   public void a(PacketEvent var1) {
      Player var6 = var1.getPlayer();
      PlayerData var7 = PlayerDataManager.getPlayerData(var6);
      Unknown148 var8 = var7.getStorage().getPlayerHolder().b();
      PacketContainer var9 = var1.getPacket();
      Integer var10 = (Integer)var9.getIntegers().read(0);
      double var11 = (double)((Integer)var9.getIntegers().readSafely(1)).intValue() / 8000.0;
      double var13 = (double)((Integer)var9.getIntegers().readSafely(2)).intValue() / 8000.0;
      double var15 = (double)((Integer)var9.getIntegers().readSafely(3)).intValue() / 8000.0;
      if (this.a.size() < 10) {
         this.a(var11);
         this.a(var15);
      }

      if (this.c.size() < 10) {
         this.b(var13);
      }

      if (var8 != null && var10 == var6.getEntityId()) {
         this.a(var8, var11, var13, var15);
      }

   }
}
