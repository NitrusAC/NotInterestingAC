package de.jpx3.intave.anticheat.check.heuristic.autoblock;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public final class AutoBlockHeuristicStorage extends Storable {
   public boolean e;
   private final List f = new ArrayList();
   public int g;
   private int c;
   public int h;
   public boolean swinging;
   public int i;
   public int d;

   static int a(AutoBlockHeuristicStorage var0, int var1) {
      return var0.c = var1;
   }

   static List a(AutoBlockHeuristicStorage var0) {
      return var0.f;
   }

   static int c(AutoBlockHeuristicStorage var0) {
      return var0.c++;
   }

   static int b(AutoBlockHeuristicStorage var0) {
      return var0.c;
   }
}
