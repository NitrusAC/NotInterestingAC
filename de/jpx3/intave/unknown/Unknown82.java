package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.anticheat.util.TPSUtil;
import java.util.Map;

public final class Unknown82 implements Unknown373 {
   private static final String b;

   @Override
   public Map build() {
      return ImmutableMap.of("tps", TPSUtil.a());
   }
}
