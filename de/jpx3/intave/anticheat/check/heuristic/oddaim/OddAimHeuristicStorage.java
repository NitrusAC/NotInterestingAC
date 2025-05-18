package de.jpx3.intave.anticheat.check.heuristic.oddaim;

import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.storage.Storable;
import java.util.List;

public final class OddAimHeuristicStorage extends Storable {
   private final List deltaYaws = Lists.newArrayList();
   private final List samples = Lists.newArrayList();

   static List getDeltaSamples(OddAimHeuristicStorage storage) {
      return storage.samples;
   }

   static List getDeltaYaws(OddAimHeuristicStorage storage) {
      return storage.deltaYaws;
   }
}
