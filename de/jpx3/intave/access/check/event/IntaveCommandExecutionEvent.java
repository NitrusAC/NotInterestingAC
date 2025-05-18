package de.jpx3.intave.access.check.event;

import com.google.common.base.Preconditions;
import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public final class IntaveCommandExecutionEvent extends IntaveEvent implements Cancellable {
   private Player player;
   private String command;
   private String violationCheck;
   private String violationMessage;
   private String violationDetails;
   private double activationVL;
   private boolean delayedExecute;
   private boolean cancelled;

   private IntaveCommandExecutionEvent() {
   }

   public void copy(Player var1, String var2, String var3, String var4, String var5, double var6, boolean var8) {
      this.player = var1;
      this.command = var2;
      this.violationCheck = var3;
      this.violationMessage = var4;
      this.violationDetails = var5;
      this.activationVL = var6;
      this.delayedExecute = var8;
      this.setCancelled(false);
   }

   public Player player() {
      return this.player;
   }

   public String command() {
      return this.command;
   }

   public void setCommand(String command) {
      Preconditions.checkNotNull(command);
      this.command = command;
   }

   public String violationCheck() {
      return this.violationCheck;
   }

   public String violationMessage() {
      return this.violationMessage;
   }

   public String violationDetails() {
      return this.violationDetails;
   }

   public double activationVL() {
      return this.activationVL;
   }

   public boolean delayedExecute() {
      return this.delayedExecute;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   @Override
   public void referenceInvalidate() {
      this.player = null;
   }

   public String toString() {
      return "IntaveCommandExecutionEvent{punished="
         + this.player
         + ", command='"
         + this.command
         + '\''
         + ", check='"
         + this.violationCheck
         + '\''
         + ", violationMessage='"
         + this.violationMessage
         + '\''
         + ", violationDetails='"
         + this.violationDetails
         + '\''
         + ", activationVL="
         + this.activationVL
         + ", delayedExecution="
         + this.delayedExecute
         + ", cancelled="
         + this.cancelled
         + '}';
   }

   public static IntaveCommandExecutionEvent empty() {
      return new IntaveCommandExecutionEvent();
   }
}
