package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.unknown.Unknown362;
import de.jpx3.intave.unknown.Unknown370;
import de.jpx3.intave.unknown.Unknown375;

public abstract class EventVisitor {
   public void visit() {
   }

   public void visit(PlayerMoveEvent event) {
      this.visit((Event)event);
   }

   public void visit(Event event) {
   }

   public void visit(Unknown362 var1) {
      this.visit((Event)var1);
   }

   public void visit(EntityAttackEntityEvent var1) {
      this.visit((Event)var1);
   }

   public void visit(Unknown370 var1) {
      this.visit((Event)var1);
   }

   public void visit(EntityMoveEvent var1) {
      this.visit((Event)var1);
   }

   public void visit(Unknown375 var1) {
      this.visit((Event)var1);
   }

   public void visit(ArmSwingEvent var1) {
      this.visit((Event)var1);
   }

   public void parse(Event event) {
      if (event instanceof EntityAttackEntityEvent) {
         this.visit((EntityAttackEntityEvent)event);
      } else if (event instanceof ArmSwingEvent) {
         this.visit((ArmSwingEvent)event);
      } else if (event instanceof EntityMoveEvent) {
         this.visit((EntityMoveEvent)event);
      } else if (event instanceof Unknown362) {
         this.visit((Unknown362)event);
      } else if (event instanceof PlayerMoveEvent) {
         this.visit((PlayerMoveEvent)event);
      } else if (event instanceof Unknown370) {
         this.visit((Unknown370)event);
      } else if (event instanceof Unknown375) {
         this.visit((Unknown375)event);
      }

   }
}
