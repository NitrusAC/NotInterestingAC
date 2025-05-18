package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

public abstract class Unknown119 {
   private final int d;
   private final WrappedDataWatcher b = new WrappedDataWatcher();
   private final WrappedGameProfile a;

   protected Unknown119(int var1, WrappedGameProfile var2) {
      this.d = var1;
      this.a = var2;
   }

   public WrappedGameProfile c() {
      return this.a;
   }

   public int a() {
      return this.d;
   }

   public WrappedDataWatcher b() {
      return this.b;
   }
}
