package de.jpx3.intave.anticheat.check.heuristic.inventory;

import de.jpx3.intave.anticheat.storage.Storable;

public final class InventoryHeuristicStorage extends Storable {
   private int inventoryOpenTicks;
   private boolean inventoryOpen;
   private int rotations;

   static int setInventoryOpenTicks(InventoryHeuristicStorage storage, int ticks) {
      return storage.inventoryOpenTicks = ticks;
   }

   static int increaseOpenTicks(InventoryHeuristicStorage storage) {
      return storage.inventoryOpenTicks++;
   }

   static int increaseRotations(InventoryHeuristicStorage storage) {
      return storage.rotations++;
   }

   static int getRotations(InventoryHeuristicStorage storage) {
      return storage.rotations;
   }

   private void resetRotations() {
      this.rotations = 0;
   }

   static boolean isInventoryOpen(InventoryHeuristicStorage storage) {
      return storage.inventoryOpen;
   }

   static boolean setInventoryOpen(InventoryHeuristicStorage storage, boolean value) {
      return storage.inventoryOpen = value;
   }

   static int getInventoryOpenTicks(InventoryHeuristicStorage storage) {
      return storage.inventoryOpenTicks;
   }

   static void reset(InventoryHeuristicStorage storage) {
      storage.resetRotations();
   }
}
