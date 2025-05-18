package de.jpx3.intave.access.check;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum MitigationStrategy {
   public static final MitigationStrategy AGGRESSIVE = new MitigationStrategy("AGGRESSIVE");
   public static final MitigationStrategy CAREFUL = new MitigationStrategy("CAREFUL");
   public static final MitigationStrategy LENIENT = new MitigationStrategy("LENIENT");
   public static final MitigationStrategy SILENT = new MitigationStrategy("SILENT");
   public static final MitigationStrategy NOT_SUPPORTED = new MitigationStrategy("");
   private static final Map c = new HashMap();
   private final String b;
   private static final MitigationStrategy[] a = new MitigationStrategy[]{AGGRESSIVE, CAREFUL, LENIENT, SILENT, NOT_SUPPORTED};

   public static MitigationStrategy byName(String var0) {
      MitigationStrategy var5 = (MitigationStrategy)c.get(var0.toUpperCase(Locale.ROOT));
      if (var5 == null) {
         var5 = NOT_SUPPORTED;
      }

      return var5;
   }

   private MitigationStrategy(String var3) {
      this.b = var3;
   }

   private static void lambda$static$0(MitigationStrategy var0) {
      MitigationStrategy var10000 = (MitigationStrategy)c.put(var0.b, var0);
   }

   static {
      Arrays.stream(values()).forEach(MitigationStrategy::lambda$static$0);
   }
}
