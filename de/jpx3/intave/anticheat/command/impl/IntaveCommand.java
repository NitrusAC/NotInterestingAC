package de.jpx3.intave.anticheat.command.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.unknown.Unknown254;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.entity.Player;

public final class IntaveCommand extends Unknown254 {
   private final boolean d;

   private static boolean b(String var0) {
      return !var0.contains("/intave") && !var0.contains("/iac");
   }

   public IntaveCommand(IntavePlugin var1) {
      super("command");
      this.d = var1.getConfig().getBoolean("command.hide", true);
   }

   @PacketListener(
      packetTypes = {ClientPacket.CHAT, ClientPacket.TAB_COMPLETE}
   )
   public void b(PacketEvent var1) {
      Player var6 = var1.getPlayer();
      String var7 = (String)var1.getPacket().getStrings().getValues().get(0);
      String var8 = var7.trim().toLowerCase();
      boolean var9 = PermissionUtil.b(var6, "intave.command");
      if ((var8.startsWith("/iac") || var8.startsWith("/intave")) && !var9) {
         var1.getPacket().getStrings().writeSafely(0, "/intavecommandforward");
      }

   }

   @Override
   protected boolean c() {
      return super.c() || this.d;
   }

   @PacketListener(
      g = {ServerPacket.TAB_COMPLETE}
   )
   public void a(PacketEvent var1) {
      Player var4 = var1.getPlayer();
      PacketContainer var5 = var1.getPacket();
      boolean var6 = PermissionUtil.b(var4, "intave.command");
      if (!var6) {
         String[] var7 = (String[])var5.getStringArrays().readSafely(0);
         if (var7 != null) {
            ArrayList var8 = Lists.newArrayList();
            Arrays.stream(var7).filter(IntaveCommand::b).forEach(var8::add);
            if (var8.size() != var7.length) {
               var5.getStringArrays().writeSafely(0, var8.toArray(new String[0]));
            }
         }

      }
   }
}
