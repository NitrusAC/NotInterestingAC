package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import de.jpx3.intave.anticheat.util.MathUtil2;
import java.util.Map;

public final class Unknown37 implements Unknown373 {
   private final double vlbefore;
   private final double vl;
   private final String checkName;
   private final String detailsRaw;
   private final String message;

   public Unknown37(String checkName, String message, String detailsRaw, double vlbefore, double vl) {
      this.checkName = checkName;
      this.message = message;
      this.detailsRaw = detailsRaw;
      this.vlbefore = vlbefore;
      this.vl = vl;
   }

   @Override
   public Map build() {
      Builder var5 = ImmutableMap.builder();
      var5.put("cheatdetected", this.checkName);
      var5.put("check", this.checkName);
      var5.put("checkname", this.checkName);
      var5.put("message", this.message);
      String var6 = this.detailsRaw;
      if (!var6.isEmpty()) {
         var6 = "(" + var6 + ")";
      }

      var5.put("details", var6);
      var5.put("details-raw", this.detailsRaw);
      var5.put("vlbefore", MathUtil2.getStringRounded(this.vlbefore, 2));
      var5.put("vl", MathUtil2.getStringRounded(this.vl, 2));
      var5.put("vladded", MathUtil2.getStringRounded(this.vl - this.vlbefore, 2));
      return var5.build();
   }
}
