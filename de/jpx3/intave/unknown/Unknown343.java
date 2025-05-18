package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class Unknown343 implements Unknown335 {
   private final Map f = new ConcurrentHashMap();
   private static final int g = 2;
   private long c;
   private final List a = new ArrayList();
   private static final String e;
   private final UUID d;

   private Object c(Class var1) {
      try {
         return var1.newInstance();
      } catch (InstantiationException | IllegalAccessException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      byte var5 = var1.readByte();
      if (var5 == 2) {
         long var6 = var1.readLong();
         long var8 = var1.readLong();
         UUID var10 = new UUID(var6, var8);
         if (!var10.equals(this.d)) {
            String var11 = String.format("Invalid entry fetched, expected %s but received id %s", this.d, var10);
            throw new IllegalStateException(var11);
         } else {
            this.c = var1.readLong();
            this.a.forEach(Unknown343::b);
         }
      }
   }

   void b(Class var1) {
      Unknown335 var2 = (Unknown335)this.c(var1);
      this.f.put(var1, var2);
      this.a.add(var2);
   }

   Unknown343(UUID var1) {
      this.d = var1;
      this.c = System.currentTimeMillis();
   }

   private static void b(ByteArrayDataInput var0, Unknown335 var1) {
      var1.a(var0);
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeByte(2);
      var1.writeLong(this.d.getMostSignificantBits());
      var1.writeLong(this.d.getLeastSignificantBits());
      var1.writeLong(this.c);
      this.a.forEach(Unknown343::a);
   }

   private static void a(ByteArrayDataOutput var0, Unknown335 var1) {
      var1.a(var0);
   }

   public Unknown335 a(Class var1) {
      return (Unknown335)this.f.get(var1);
   }
}
