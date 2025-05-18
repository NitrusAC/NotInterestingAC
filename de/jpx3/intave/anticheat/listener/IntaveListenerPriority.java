package de.jpx3.intave.anticheat.listener;

import com.comphenix.protocol.events.ListenerPriority;
import de.jpx3.intave.unknown.Unknown110;

public enum IntaveListenerPriority {
   private static final IntaveListenerPriority[] values = new IntaveListenerPriority[]{
      IntaveListenerPriority.LOWEST,
      IntaveListenerPriority.LOW,
      IntaveListenerPriority.NORMAL,
      IntaveListenerPriority.HIGH,
      IntaveListenerPriority.HIGHEST,
      IntaveListenerPriority.MONITOR
   };
   final int priority;
   public static final IntaveListenerPriority LOWEST = new IntaveListenerPriority(1);
   public static final IntaveListenerPriority NORMAL = new IntaveListenerPriority(3);
   public static final IntaveListenerPriority HIGH = new IntaveListenerPriority(4);
   public static final IntaveListenerPriority HIGHEST = new IntaveListenerPriority(5);
   public static final IntaveListenerPriority LOW = new IntaveListenerPriority(2);
   public static final IntaveListenerPriority MONITOR = new IntaveListenerPriority(6);

   private IntaveListenerPriority(int var3) {
      this.priority = var3;
   }

   public int getPriority() {
      return this.priority;
   }

   public ListenerPriority convert() {
      switch(Unknown110.a[this.ordinal()]) {
         case 1:
            return ListenerPriority.LOWEST;
         case 2:
            return ListenerPriority.LOW;
         case 3:
            return ListenerPriority.NORMAL;
         case 4:
            return ListenerPriority.HIGH;
         case 5:
            return ListenerPriority.HIGHEST;
         case 6:
            return ListenerPriority.MONITOR;
         default:
            return null;
      }
   }
}
