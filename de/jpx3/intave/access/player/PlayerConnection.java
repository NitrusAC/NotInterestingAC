package de.jpx3.intave.access.player;

import java.util.function.BiConsumer;

public interface PlayerConnection {
   int latency();

   int latencyJitter();

   void subscribe(BiConsumer var1);

   long packetSentByClient();

   long packetSentToClient();
}
