package de.jpx3.intave.unknown;

public abstract class Unknown154 {
   public final String name;
   static final int o = 20;
   static final int t = 9;
   public final String owner;
   static final int g = 16;
   static final int z = 7;
   static final int A = 5;
   static final int a = 128;
   public final int tag;
   static final int n = 17;
   static final int p = 1;
   static final int c = 19;
   public int info;
   public final String value;
   static final int f = 12;
   static final int s = 8;
   static final int u = 64;
   static final int l = 3;
   public final long data;
   static final int v = 18;
   static final int m = 129;
   static final int h = 6;
   static final int r = 15;
   public final int index;
   static final int b = 10;
   static final int x = 130;
   static final int j = 4;
   static final int y = 11;

   int a() {
      if (this.info == 0) {
         this.info = Unknown357.d(this.value);
      }

      return this.info;
   }

   public Unknown154(int var1, int var2, String var3, String var4, String var5, long var6) {
      this.index = var1;
      this.tag = var2;
      this.owner = var3;
      this.name = var4;
      this.value = var5;
      this.data = var6;
   }
}
