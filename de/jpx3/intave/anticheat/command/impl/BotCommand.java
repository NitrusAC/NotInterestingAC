package de.jpx3.intave.anticheat.command.impl;

import de.jpx3.intave.fG;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.unknown.Unknown126;
import de.jpx3.intave.unknown.Unknown230;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class BotCommand extends AbstractCommandRegistrar {
   private final IntavePlugin plugin = IntavePlugin.getInstance();
   private static BotCommand instance;

   private BotCommand() {
      super(InternalCommand.of(), "bot");
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Command(
      aliases = {"spawn"},
      e = "<player> <type>",
      d = "intave.command.internals.bot.spawn",
      a = "Summon bots to a specified player"
   )
   public void handleSpawn(CommandSender sender, Player player, Unknown126 var3) {
      PlayerData var7 = PlayerDataManager.getPlayerData(player);
      if (MinecraftVersion.V_1_17.atOrAbove()) {
         sender.sendMessage(IntavePlugin.getPrefix() + "Bots are currently unavailable for your server version. Please wait for upcoming updates.");
      } else if (var7.getStorage().getPlayerHolder().s != null) {
         sender.sendMessage(IntavePlugin.getPrefix() + "This player already has a bot assigned");
      } else {
         switch(fG.a[var3.ordinal()]) {
            case 1:
               Unknown230.c.a(var7);
               break;
            case 2:
               Unknown230.d.a(var7);
               break;
            case 3:
               Unknown230.e.a(var7);
         }

         sender.sendMessage(IntavePlugin.getPrefix() + "Summoned bot to " + ChatColor.RED + var7.getPlayer().getName());
      }
   }

   public static BotCommand of() {
      if (instance == null) {
         instance = new BotCommand();
      }

      return instance;
   }
}
