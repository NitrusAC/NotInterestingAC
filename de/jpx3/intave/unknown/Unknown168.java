package de.jpx3.intave.unknown;

import com.mojang.authlib.GameProfile;
import de.jpx3.intave.anticheat.logger.Logger;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.logging.Level;
import org.bukkit.entity.Player;

final class Unknown168 extends ChannelDuplexHandler {
   public Player a;
   final Unknown349 this$0;

   public void channelRead(ChannelHandlerContext var1, Object var2) {
      Channel var5 = var1.channel();
      this.a(var5, var2);

      try {
         var2 = this.this$0.b(this.a, var5, var2);
      } catch (Exception var7) {
         this.this$0.c.getLogger().log(Level.SEVERE, "Error in onPacketInAsync().", var7);
      }

      if (var2 != null) {
         super.channelRead(var1, var2);
      }

   }

   private void a(Channel var1, Object var2) {
      if (Unknown349.e().isInstance(var2)) {
         GameProfile var6 = (GameProfile)Unknown349.g().b(var2);
         Unknown349.e(this.this$0).put(var6.getName(), var1);
      }

   }

   private Unknown168(Unknown349 var1) {
      this.this$0 = var1;
   }

   public void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) {
      try {
         var2 = this.this$0.a(this.a, var1.channel(), var2);
      } catch (Exception var7) {
         Logger.getLogger().print("[Intave] Exception in channel write handle");
         var7.printStackTrace();
      }

      if (var2 != null) {
         super.write(var1, var2, var3);
      }

   }

   Unknown168(Unknown349 var1, Unknown181 var2) {
      this(var1);
   }
}
