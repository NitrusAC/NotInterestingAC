package de.jpx3.intave.access;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class IntaveEvent extends Event {
   private static final HandlerList a = new HandlerList();

   public IntaveEvent() {
      super(true);
   }

   public abstract void referenceInvalidate();

   public HandlerList getHandlers() {
      return a;
   }

   public static HandlerList getHandlerList() {
      return a;
   }
}
