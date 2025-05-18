package de.jpx3.intave.access.check.event;

import com.google.common.base.Preconditions;
import de.jpx3.intave.IntaveAccessor;
import de.jpx3.intave.access.IntaveEvent;
import de.jpx3.intave.access.check.Check;
import de.jpx3.intave.access.player.PlayerAccess;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public final class IntaveViolationEvent extends IntaveEvent implements Cancellable {
   private Player h;
   private String f;
   private String d;
   private String i;
   private double b;
   private double j;
   private IntaveViolationEvent.Reaction g = IntaveViolationEvent.Reaction.INTERRUPT_AND_REPORT;
   private static final double c = 1000.0;

   private IntaveViolationEvent() {
   }

   public void copy(Player var1, String var2, String var3, String var4, double var5, double var7) {
      this.h = var1;
      this.f = var2;
      this.d = var3;
      this.i = var4;
      this.b = var5;
      this.j = var7;
      this.g = IntaveViolationEvent.Reaction.INTERRUPT_AND_REPORT;
      this.setCancelled(false);
   }

   public Player player() {
      return this.h;
   }

   public PlayerAccess playerAccess() {
      return IntaveAccessor.unsafeAccess().player(this.player());
   }

   @Deprecated
   public String check() {
      return this.f;
   }

   public String checkName() {
      return this.f;
   }

   public Check checkEnum() {
      return Check.fromName(this.f);
   }

   public String message() {
      return this.i.isEmpty() ? this.d : this.d + " (" + this.i.trim() + ")";
   }

   public String details() {
      return this.i;
   }

   public String compactMessage() {
      return this.d;
   }

   public double addedViolationPoints() {
      return this.reducePrecision(this.j - this.b);
   }

   private double reducePrecision(double var1) {
      return (double)Math.round(var1 * 1000.0) / 1000.0;
   }

   public double violationLevelBeforeViolation() {
      return this.b;
   }

   public double violationLevelAfterViolation() {
      return this.j;
   }

   @Deprecated
   public boolean isCancelled() {
      return this.g != IntaveViolationEvent.Reaction.INTERRUPT_AND_REPORT;
   }

   @Deprecated
   public void setCancelled(boolean var1) {
      this.suggestReaction(var1 ? IntaveViolationEvent.Reaction.IGNORE : IntaveViolationEvent.Reaction.INTERRUPT_AND_REPORT);
   }

   public void suggestReaction(IntaveViolationEvent.Reaction var1) {
      Preconditions.checkNotNull(var1);
      this.g = var1;
   }

   public IntaveViolationEvent.Reaction reaction() {
      return this.g;
   }

   @Override
   public void referenceInvalidate() {
      this.h = null;
   }

   public String toString() {
      return "IntaveViolationEvent{punished="
         + this.h
         + ", checkName='"
         + this.f
         + '\''
         + ", message='"
         + this.d
         + '\''
         + ", details='"
         + this.i
         + '\''
         + ", vlBefore="
         + this.b
         + ", vlAfter="
         + this.j
         + ", reaction="
         + this.g
         + '}';
   }

   public static IntaveViolationEvent empty() {
      return new IntaveViolationEvent();
   }

   public static enum Reaction {
      public static final IntaveViolationEvent.Reaction IGNORE = new IntaveViolationEvent.Reaction();
      public static final IntaveViolationEvent.Reaction INTERRUPT = new IntaveViolationEvent.Reaction();
      public static final IntaveViolationEvent.Reaction INTERRUPT_AND_REPORT = new IntaveViolationEvent.Reaction();
      private static final IntaveViolationEvent.Reaction[] a = new IntaveViolationEvent.Reaction[]{IGNORE, INTERRUPT, INTERRUPT_AND_REPORT};
   }
}
