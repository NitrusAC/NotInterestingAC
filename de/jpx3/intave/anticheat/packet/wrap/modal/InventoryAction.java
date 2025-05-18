package de.jpx3.intave.anticheat.packet.wrap.modal;

public enum InventoryAction {
   public static final InventoryAction QUICK_MOVE = new InventoryAction();
   public static final InventoryAction PICKUP_ALL = new InventoryAction();
   private static final InventoryAction[] values = new InventoryAction[]{
      InventoryAction.PICKUP, QUICK_MOVE, InventoryAction.SWAP, InventoryAction.CLONE, InventoryAction.THROW, InventoryAction.QUICK_CRAFT, PICKUP_ALL
   };
   public static final InventoryAction SWAP = new InventoryAction();
   public static final InventoryAction QUICK_CRAFT = new InventoryAction();
   public static final InventoryAction PICKUP = new InventoryAction();
   public static final InventoryAction THROW = new InventoryAction();
   public static final InventoryAction CLONE = new InventoryAction();
}
