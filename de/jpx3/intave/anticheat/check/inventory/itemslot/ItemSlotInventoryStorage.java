package de.jpx3.intave.anticheat.check.inventory.itemslot;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public final class ItemSlotInventoryStorage extends Storable {
   private long d;
   private int e;
   private long f;
   private int a;
   List getSlotChangeTimes = new ArrayList();

   static int b(ItemSlotInventoryStorage storage, int var1) {
      return storage.e = var1;
   }

   static int a(ItemSlotInventoryStorage storage, int var1) {
      return storage.a = var1;
   }

   static long getLastSlotChange(ItemSlotInventoryStorage storage) {
      return storage.d;
   }

   static long c(ItemSlotInventoryStorage storage) {
      return storage.f;
   }

   static long a(ItemSlotInventoryStorage storage, long var1) {
      return storage.d = var1;
   }

   static int b(ItemSlotInventoryStorage storage) {
      return storage.e;
   }

   static int a(ItemSlotInventoryStorage storage) {
      return storage.a;
   }

   static long b(ItemSlotInventoryStorage storage, long var1) {
      return storage.f = var1;
   }
}
