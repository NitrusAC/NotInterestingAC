package de.jpx3.intave.unknown;

import java.util.HashMap;
import java.util.Map;

public interface Unknown373 {
   Map build();

   default Unknown373 a(Unknown373 var1) {
      Map var5 = this.build();
      Map var6 = var1.build();
      if (var5.isEmpty()) {
         return var1;
      } else if (var6.isEmpty()) {
         return this;
      } else {
         HashMap var7 = new HashMap();
         var7.putAll(var5);
         var7.putAll(var6);
         return Unknown373::b;
      }
   }

   private static Map b(Map var0) {
      return var0;
   }
}
