package de.jpx3.intave.anticheat.unknown;

import de.jpx3.intave.unknown.Unknown154;

public class Entry extends Unknown154 {
   public final int C;
   public Entry D;

   public String toString() {
      return "Entry{index="
         + this.index
         + ", tag="
         + this.tag
         + ", owner='"
         + this.owner
         + '\''
         + ", name='"
         + this.name
         + '\''
         + ", value='"
         + this.value
         + '\''
         + ", data="
         + this.data
         + ", info="
         + this.info
         + '}';
   }

   public Entry(int var1, int var2, String var3, long var4, int var6) {
      super(var1, var2, null, null, var3, var4);
      this.C = var6;
   }

   public Entry(int var1, int var2, String var3, String var4, int var5) {
      super(var1, var2, null, var3, var4, 0L);
      this.C = var5;
   }

   public Entry(int var1, int var2, String var3, String var4, String var5, long var6, int var8) {
      super(var1, var2, var3, var4, var5, var6);
      this.C = var8;
   }

   public Entry(int var1, int var2, String var3, int var4) {
      super(var1, var2, null, null, var3, 0L);
      this.C = var4;
   }

   public Entry(int var1, int var2, long var3, int var5) {
      super(var1, var2, null, null, null, var3);
      this.C = var5;
   }
}
