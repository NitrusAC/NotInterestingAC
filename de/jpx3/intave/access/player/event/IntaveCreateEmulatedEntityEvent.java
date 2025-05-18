package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import de.jpx3.intave.unknown.Unknown4;
import java.lang.ref.WeakReference;
import org.bukkit.entity.Player;

public class IntaveCreateEmulatedEntityEvent extends IntaveEvent {
   protected WeakReference player;
   protected int reservedEntityId;

   protected IntaveCreateEmulatedEntityEvent(Player var1, int var2) {
      this.player = new WeakReference(var1);
      this.reservedEntityId = var2;
   }

   public final Player observer() {
      return (Player)this.player.get();
   }

   public final int reservedEntityId() {
      return this.reservedEntityId;
   }

   public void copy(Player var1, int var2) {
      this.player = new WeakReference(var1);
      this.reservedEntityId = var2;
   }

   @Override
   public void referenceInvalidate() {
      this.player.clear();
   }

   public static IntaveCreateEmulatedEntityEvent empty() {
      return construct(null, 0);
   }

   public static IntaveCreateEmulatedEntityEvent construct(Player var0, int var1) {
      return new IntaveCreateEmulatedEntityEvent(var0, var1);
   }

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }
}
