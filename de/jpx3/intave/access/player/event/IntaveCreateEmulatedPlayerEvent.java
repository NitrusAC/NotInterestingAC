package de.jpx3.intave.access.player.event;

import java.lang.ref.WeakReference;
import java.util.UUID;
import org.bukkit.entity.Player;

public final class IntaveCreateEmulatedPlayerEvent extends IntaveCreateEmulatedEntityEvent {
   private String e;
   private UUID f;
   private static final String h;

   protected IntaveCreateEmulatedPlayerEvent(Player var1, int var2, String var3, UUID var4) {
      super(var1, var2);
      this.e = var3;
      this.f = var4;
   }

   public String name() {
      return this.e;
   }

   public UUID id() {
      return this.f;
   }

   public void copy(Player var1, int var2, String var3, UUID var4) {
      this.player = new WeakReference(var1);
      this.reservedEntityId = var2;
      this.e = var3;
      this.f = var4;
   }

   @Override
   public void referenceInvalidate() {
      this.player.clear();
   }

   public static IntaveCreateEmulatedPlayerEvent empty() {
      return construct(null, 0, "error", null);
   }

   public static IntaveCreateEmulatedPlayerEvent construct(Player var0, int var1, String var2, UUID var3) {
      return new IntaveCreateEmulatedPlayerEvent(var0, var1, var2, var3);
   }
}
