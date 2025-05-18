package de.jpx3.intave.anticheat.packet.wrap.modal;

import de.jpx3.intave.unknown.Unknown120;

public enum EntityAction {
   public static final EntityAction RIDING_JUMP = new EntityAction();
   public static final EntityAction PRESS_SHIFT_KEY = new EntityAction();
   public static final EntityAction STOP_SPRINTING = new EntityAction();
   public static final EntityAction STOP_SLEEPING = new EntityAction();
   public static final EntityAction START_FALL_FLYING = new EntityAction();
   public static final EntityAction OPEN_INVENTORY = new EntityAction();
   public static final EntityAction START_SNEAKING = new EntityAction();
   public static final EntityAction RELEASE_SHIFT_KEY = new EntityAction();
   public static final EntityAction START_RIDING_JUMP = new EntityAction();
   public static final EntityAction START_SPRINTING = new EntityAction();
   public static final EntityAction STOP_RIDING_JUMP = new EntityAction();
   private static final EntityAction[] values = new EntityAction[]{
      PRESS_SHIFT_KEY,
      RELEASE_SHIFT_KEY,
      START_SNEAKING,
      EntityAction.STOP_NSEAKING,
      STOP_SLEEPING,
      START_SPRINTING,
      STOP_SPRINTING,
      START_RIDING_JUMP,
      STOP_RIDING_JUMP,
      OPEN_INVENTORY,
      START_FALL_FLYING,
      RIDING_JUMP
   };
   public static final EntityAction STOP_NSEAKING = new EntityAction();

   public boolean isSneak() {
      switch(Unknown120.a[this.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 4:
            return true;
         default:
            return false;
      }
   }
}
