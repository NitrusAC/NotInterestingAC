package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.anticheat.IntavePlugin;
import java.util.Map;

public final class Unknown231 implements Unknown373 {
   private static final String b;

   @Override
   public Map build() {
      String var3 = IntavePlugin.getPrefix();
      return ImmutableMap.of("prefix", var3);
   }
}
