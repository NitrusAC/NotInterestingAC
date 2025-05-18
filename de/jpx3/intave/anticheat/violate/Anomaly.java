package de.jpx3.intave.anticheat.violate;

import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.unknown.Unknown185;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Anomaly {
   private final String key;
   private final long e;
   private static final long b = TimeUnit.MINUTES.toMillis(5L);
   private final CombatCheckType d;
   private final long time;
   private final String description;
   private final Certainty confidence;
   private final int options;

   public boolean j() {
      return Unknown185.a(this.options, 1024);
   }

   public String getKey() {
      return this.key;
   }

   public static Anomaly of(String var0, Certainty confidence, CombatCheckType var2, String var3, int var4, long var5) {
      return new Anomaly(var0, confidence, var2, var3, var4, var5);
   }

   public int h() {
      return Unknown185.a(this.options);
   }

   public boolean c() {
      return Unknown185.a(this.options, 16);
   }

   public CombatCheckType l() {
      return this.d;
   }

   private Anomaly(String key, Certainty confidence, CombatCheckType var3, String description, int options, long var6) {
      this.key = key;
      this.time = System.currentTimeMillis();
      this.description = description.toLowerCase(Locale.ROOT);
      this.confidence = confidence;
      this.d = var3;
      this.options = options;
      this.e = var6;
   }

   public String getDescription() {
      return this.description;
   }

   public int g() {
      return Unknown185.b(this.options);
   }

   public boolean e() {
      return Unknown185.a(this.options, 32);
   }

   public static Anomaly of(String key, Certainty confidence, CombatCheckType var2, String description) {
      return new Anomaly(key, confidence, var2, description, 2, b);
   }

   public boolean a() {
      return System.currentTimeMillis() - this.time > (long)Unknown185.a(this.options) * 1000L;
   }

   public boolean k() {
      return System.currentTimeMillis() - this.time > this.e;
   }

   public String toString() {
      return "Anomaly{key='"
         + this.key
         + '\''
         + ", description='"
         + this.description
         + '\''
         + ", confidence="
         + this.confidence
         + ", options="
         + this.options
         + '}';
   }

   public static Anomaly of(String key, Certainty var1, CombatCheckType var2, String description, int options) {
      return new Anomaly(key, var1, var2, description, options, b);
   }

   public long getTime() {
      return this.time;
   }

   public Certainty getConfidence() {
      return this.confidence;
   }
}
