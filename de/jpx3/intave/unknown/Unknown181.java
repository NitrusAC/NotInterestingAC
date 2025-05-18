package de.jpx3.intave.unknown;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import java.util.logging.Level;

class Unknown181 extends ChannelInitializer {
   private static final String b;
   final Unknown349 this$0;

   protected void initChannel(Channel var1) {
      try {
         synchronized(Unknown349.a(this.this$0)) {
            if (!this.this$0.v) {
               var1.eventLoop().submit(this::b);
            }
         }
      } catch (Exception var8) {
         this.this$0.c.getLogger().log(Level.SEVERE, "Could not inject incoming channel " + var1, var8);
      }

   }

   private Unknown168 b(Channel var1) {
      return Unknown349.a(this.this$0, var1);
   }

   Unknown181(Unknown349 var1) {
      this.this$0 = var1;
   }
}
