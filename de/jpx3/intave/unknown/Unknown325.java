package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.google.common.collect.ImmutableList;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeamBase.EnumNameTagVisibility;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

@Unknown61
public final class Unknown325 {
   @Unknown61
   public static void a(Player var0, String var1, WrappedGameProfile var2, boolean var3) {
      PlayerConnection var4 = ((CraftPlayer)var0).getHandle().playerConnection;
      ImmutableList var5 = ImmutableList.of(var2.getName());
      ScoreboardTeam var6 = new ScoreboardTeam(new Scoreboard(), var1);
      PacketPlayOutScoreboardTeam var7 = new PacketPlayOutScoreboardTeam(var6, var5, 3);
      var4.sendPacket(var7);
      if (var3) {
         var6.setNameTagVisibility(EnumNameTagVisibility.NEVER);
         var4.sendPacket(new PacketPlayOutScoreboardTeam(var6, 2));
      }

   }
}
