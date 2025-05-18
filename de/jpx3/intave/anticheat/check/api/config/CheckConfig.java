package de.jpx3.intave.anticheat.check.api.config;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.access.IntaveBootFailureException;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.access.check.MitigationStrategy;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.unknown.Unknown115;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;

public class CheckConfig {
   private final Unknown115 c;
   private final Map b;
   private final Map a = new HashMap();

   public boolean getBoolean(String path, boolean defaultValue) {
      try {
         return this.get(path, defaultValue);
      } catch (ClassCastException var6) {
         throw new IntaveBootFailureException(
            new InvalidConfigurationException("Expected " + path + " in check " + this.c.a().k() + " to be a boolean expression", var6)
         );
      }
   }

   public List getList(String var1) {
      return (List)this.get(var1, new ArrayList());
   }

   public double a(String var1, double var2, double var4, double var6) {
      return MathUtil2.clamp(var2, this.getDouble(var1, var6), var4);
   }

   public long getLong(String var1, long var2) {
      try {
         return this.get(var1, var2);
      } catch (ClassCastException var5) {
         return Long.parseLong(String.valueOf(this.a(var1, (int)var2)));
      }
   }

   public double getDouble(String var1, double var2) {
      try {
         return this.get(var1, var2);
      } catch (ClassCastException var5) {
         return Double.parseDouble(String.valueOf(this.a(var1, (int)var2)));
      }
   }

   public int a(String var1, int var2, int var3, int var4) {
      return MathUtil2.a(var2, this.a(var1, var4), var3);
   }

   public boolean exists(String var1) {
      return this.b.containsKey(var1);
   }

   public MitigationStrategy getMitigationStrategy() {
      return MitigationStrategy.byName(this.getString("mitigation"));
   }

   public boolean isEnabled() {
      return this.e("enabled");
   }

   private Object get(String var1, Object var2) {
      return this.b.getOrDefault(var1, var2);
   }

   public Map h(String var1) {
      if (this.a.containsKey(var1)) {
         return (Map)this.a.get(var1);
      } else {
         ConfigurationSection var5 = (ConfigurationSection)this.b.get(var1);
         LinkedHashMap var6 = new LinkedHashMap();
         Set var7 = var5.getKeys(false);
         if (var7 == null) {
            throw new IntaveInternalException("Unable to locate threshold section " + var1 + " in check " + this.c.a().k());
         } else {
            for(String var9 : var7) {
               ArrayList var10 = new ArrayList();
               if (var5.isList(var9)) {
                  var10.addAll(var5.getStringList(var9));
               } else {
                  var10.add(var5.getString(var9));
               }

               var6.put(Integer.parseInt(var9), var10);
            }

            this.a.put(var1, var6);
            return var6;
         }
      }
   }

   public int a(String var1, int var2) {
      try {
         return this.get(var1, var2);
      } catch (ClassCastException var6) {
         throw new IntaveBootFailureException(
            new InvalidConfigurationException("Expected " + var1 + " in check " + this.c.a().k() + " to be a numeric expression", var6)
         );
      }
   }

   public double d(String var1) {
      return this.getDouble(var1, 0.0);
   }

   public double a(String var1, double var2, double var4) {
      return this.a(var1, var2, var4, 0.0);
   }

   public boolean e(String var1) {
      return this.getBoolean(var1, false);
   }

   public String a(String var1, String var2) {
      return (String)this.get(var1, var2);
   }

   public long a(String var1, long var2, long var4) {
      return this.a(var1, var2, var4, 0L);
   }

   public Map b() {
      return this.h("thresholds");
   }

   public CheckConfig(Map var1, Unknown115 var2) {
      this.b = ImmutableMap.copyOf(var1);
      this.c = var2;
   }

   public String getString(String var1) {
      return this.a(var1, "");
   }

   public long getLong(String var1) {
      return this.getLong(var1, 0L);
   }

   public int a(String var1, int var2, int var3) {
      return this.a(var1, var2, var3, 0);
   }

   public int g(String var1) {
      return this.a(var1, 0);
   }

   public long a(String var1, long var2, long var4, long var6) {
      return MathUtil2.a(var2, this.getLong(var1, var6), var4);
   }
}
