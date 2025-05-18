package de.jpx3.intave.anticheat.util.version;

public class VersionRange implements Comparable {
   private final String version;
   private final int from;
   private final int to;

   public String getVersion() {
      return this.version;
   }

   public VersionRange(int var1, int var2, String var3) {
      this.from = var1;
      this.to = var2;
      this.version = var3;
   }

   public boolean a(int var1) {
      return this.from <= var1 && var1 <= this.to;
   }

   public int compareTo(Object var1) {
      return this.a((VersionRange)var1);
   }

   public int a(VersionRange var1) {
      return this.to - var1.to;
   }

   public int getFrom() {
      return this.from;
   }

   public int getTo() {
      return this.to;
   }

   public String toString() {
      return "version " + this.version + " from " + this.from + " to " + this.to;
   }
}
