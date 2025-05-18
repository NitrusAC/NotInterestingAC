package de.jpx3.intave.anticheat.check.clickspeed;

import com.comphenix.protocol.PacketType;
import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public final class ClickSpeedStorage extends Storable {
   long a;
   PacketType h;
   int[] f;
   private long c;
   List e = new ArrayList();
   int g;
   int d;

   static long a(ClickSpeedStorage storage) {
      return storage.c;
   }

   public ClickSpeedStorage() {
      this.f = new int[20];
      this.g = 0;
      this.a = System.currentTimeMillis();
   }

   static long a(ClickSpeedStorage var0, long var1) {
      return var0.c = var1;
   }
}
