package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Unknown27 extends Storable {
   public boolean c;
   public final List d = new CopyOnWriteArrayList();
   public long e;
   public boolean a;

   public Unknown27() {
      this.c = false;
      this.a = false;
      this.e = 0L;
   }
}
