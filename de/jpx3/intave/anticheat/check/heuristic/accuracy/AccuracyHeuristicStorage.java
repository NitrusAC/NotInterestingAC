package de.jpx3.intave.anticheat.check.heuristic.accuracy;

import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.storage.Storable;
import java.util.List;

public final class AccuracyHeuristicStorage extends Storable {
   public double buffer;
   public double armTicks;
   public final List lookOffsets;
   public double attackTicks;
   public final List entityOffsets = Lists.newArrayList();

   public AccuracyHeuristicStorage() {
      this.lookOffsets = Lists.newArrayList();
   }
}
