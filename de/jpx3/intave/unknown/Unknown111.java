package de.jpx3.intave.unknown;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;

class Unknown111 extends ChannelInitializer {
   final Unknown349 this$0;

   protected void initChannel(Channel var1) {
      var1.pipeline().addLast(new ChannelHandler[]{Unknown349.d(this.this$0)});
   }

   Unknown111(Unknown349 var1) {
      this.this$0 = var1;
   }
}
