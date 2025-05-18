package de.jpx3.intave.anticheat.check.heuristic;

import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.storage.Storable;
import java.util.List;

public class HeuristicCheckStorage extends Storable {
   public long a;
   public int c;
   public List d = Lists.newCopyOnWriteArrayList();

   public HeuristicCheckStorage() {
      this.c = 0;
      this.a = Long.MAX_VALUE;
   }
}
