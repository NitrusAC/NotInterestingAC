package de.jpx3.intave.access.server;

import de.jpx3.intave.unknown.Unknown4;
import java.util.function.DoubleConsumer;

public interface ServerHealthStatisticAccess {
   double tickAverageOver(ServerHealthStatisticAccess.TimeSpan var1);

   void subscribeToTick(ServerHealthStatisticAccess.TimeSpan var1, DoubleConsumer var2);

   public static enum TimeSpan {
      public static final ServerHealthStatisticAccess.TimeSpan LAST_MINUTE = new ServerHealthStatisticAccess.TimeSpan();
      public static final ServerHealthStatisticAccess.TimeSpan LAST_FIVE_MINUTES = new ServerHealthStatisticAccess.TimeSpan();
      public static final ServerHealthStatisticAccess.TimeSpan LAST_TEN_MINUTES = new ServerHealthStatisticAccess.TimeSpan();
      private static final ServerHealthStatisticAccess.TimeSpan[] c = new ServerHealthStatisticAccess.TimeSpan[]{
         LAST_MINUTE, LAST_FIVE_MINUTES, LAST_TEN_MINUTES
      };

      private static Unknown4 a(Unknown4 var0) {
         return var0;
      }
   }
}
