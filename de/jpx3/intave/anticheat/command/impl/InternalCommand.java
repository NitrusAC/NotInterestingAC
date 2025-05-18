package de.jpx3.intave.anticheat.command.impl;

import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.unknown.Unknown199;
import de.jpx3.intave.unknown.Unknown22;
import de.jpx3.intave.unknown.Unknown94;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public final class InternalCommand extends AbstractCommandRegistrar {
   private final WrappedDataWatcher j;
   private static InternalCommand instance;
   private final IntavePlugin plugin = IntavePlugin.getInstance();

   @Command(
      aliases = {"entitylag"},
      e = "<player>",
      d = "intave.command.internals.entitylag",
      a = "Causes severe lag to a user"
   )
   public void handleEntityLag(CommandSender sender, Player player) {
      int[] var5 = new int[]{0};
      var5[0] = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this.plugin, this::a, 40L, 20L);
      Unknown22.a(var5[0]);
      sender.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + player.getName() + " " + IntavePlugin.l() + "will now slowly begin to lag");
   }

   private void b(Player var1) {
      PacketContainer var2 = new PacketContainer(Server.SPAWN_ENTITY_LIVING);
      var2.getIntegers()
         .write(0, ThreadLocalRandom.current().nextInt(100000000, 200000000))
         .write(1, Integer.valueOf(EntityType.ARMOR_STAND.getTypeId()))
         .write(2, (int)(var1.getLocation().getX() * 32.0))
         .write(3, -64)
         .write(4, (int)(var1.getLocation().getZ() * 32.0));
      var2.getDataWatcherModifier().write(0, this.j);
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      var3.D();
      ProtocolManager.sendPacket(var1, var2);
      var3.q();
   }

   private static String a(String var0) {
      return var0 + " ";
   }

   private InternalCommand() {
      super(NotifyCommand.of(), "internals");
      this.j = this.a((World)Bukkit.getWorlds().get(0), EntityType.ARMOR_STAND);
   }

   private WrappedDataWatcher a(World var1, EntityType var2) {
      Entity var3 = var1.spawnEntity(new Location(var1, 0.0, (double)Unknown94.MAX_HEIGHT, 0.0), var2);
      WrappedDataWatcher var4 = WrappedDataWatcher.getEntityWatcher(var3).deepClone();
      var3.remove();
      return var4;
   }

   private static String c(String var0) {
      return var0 + " ";
   }

   public static InternalCommand of() {
      if (instance == null) {
         instance = new InternalCommand();
      }

      return instance;
   }

   private void a(Player var1, int[] var2) {
      if (!var1.isOnline()) {
         Bukkit.getScheduler().cancelTask(var2[0]);
         Unknown22.b(var2[0]);
      } else {
         IntaveScheduler.runTask(this::a);
      }
   }

   @Command(
      aliases = {"sendnotify"},
      e = "<message...>",
      d = "intave.command.internals.sendnotify",
      a = "Send notifications"
   )
   public void handleSendNotify(CommandSender sender, String[] args) {
      String var3 = ((String)Arrays.stream(args).map(InternalCommand::a).collect(Collectors.joining())).trim();
      MoudleLoader.violations().a(var3);
   }

   private void a(Player var1) {
      for(int var5 = 0; var5 < 1000; ++var5) {
         this.b(var1);
      }

      var1.closeInventory();
   }

   @Command(
      aliases = {"collectivekick"},
      e = "<player> <message>",
      d = "intave.command.internals.collectivekick",
      a = "Kicks all players with the same ip as the target player"
   )
   public void handleCollectiveKick(CommandSender sender, Player player, String[] args) {
      String var7 = ((String)Arrays.stream(args).map(InternalCommand::c).collect(Collectors.joining())).trim();

      for(Player var9 : Bukkit.getOnlinePlayers()) {
         if (!var9.equals(player) && var9.getAddress().equals(player.getAddress())) {
            String var10 = ChatColor.translateAlternateColorCodes('&', var7);
            IntaveScheduler.runTask(InternalCommand::b);
         }
      }

   }

   @Command(
      aliases = {"bot"},
      e = "<player> <type>",
      a = "Bot related commands",
      d = "intave.command.internals.bot"
   )
   @Unknown199(
      a = BotCommand.class
   )
   public void b(CommandSender var1) {
   }

   private static void b(Player var0, String var1) {
      var0.kickPlayer(var1);
   }
}
