package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.bukkit.configuration.file.YamlConfiguration;

public final class Unknown106 implements Unknown237 {
   private final Map a = new HashMap();

   private static Integer a(Integer var0, Integer var1) {
      return var1;
   }

   private void a(String var1, List var2) {
      TrustFactor[] var3 = TrustFactor.values();
      EnumMap var4 = (EnumMap)IntStream.range(0, var3.length).boxed().collect(Collectors.toMap(Unknown106::a, var2::get, Unknown106::a, Unknown106::b));
      this.a.put(var1, var4);
   }

   private void a(YamlConfiguration var1) {
      for(Entry var6 : var1.getValues(true).entrySet()) {
         if (var6.getValue() instanceof ArrayList) {
            List var7 = (List)var6.getValue();
            this.a((String)var6.getKey(), var7);
         }
      }

   }

   private static TrustFactor a(TrustFactor[] var0, Integer var1) {
      return var0[var1];
   }

   private static EnumMap b() {
      return new EnumMap(TrustFactor.class);
   }

   public Unknown106(YamlConfiguration var1) {
      this.a(var1);
   }

   @Override
   public int a(String var1, TrustFactor var2) {
      EnumMap var6 = (EnumMap)this.a.get(var1.toLowerCase(Locale.ROOT));
      if (var6 == null) {
         return 0;
      } else {
         try {
            return var6.get(var2);
         } catch (NullPointerException var8) {
            throw new IntaveInternalException("Unable to fetch trustfactor setting " + var1 + " for trustfactor " + var2.name(), var8);
         }
      }
   }
}
