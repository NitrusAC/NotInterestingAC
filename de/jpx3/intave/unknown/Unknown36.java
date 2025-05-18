package de.jpx3.intave.unknown;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

class Unknown36 extends ChannelInboundHandlerAdapter {
   final Unknown349 this$0;

   public void channelRead(ChannelHandlerContext var1, Object var2) {
      Channel var3 = (Channel)var2;

      try {
         var3.pipeline().addFirst(new ChannelHandler[]{Unknown349.b(this.this$0)});
      } catch (Exception var5) {
         System.out.println(var3.pipeline().names());
         var5.printStackTrace();
      }

      var1.fireChannelRead(var2);
   }

   Unknown36(Unknown349 var1) {
      this.this$0 = var1;
   }
}
