package de.jpx3.intave.anticheat.util.http;

import de.jpx3.intave.unknown.Unknown83;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public interface HTTPRequest extends IHTTPRequest {
   String h;

   default HTTPRequest a(File var1) {
      return Unknown83.a(var1.getAbsolutePath(), this);
   }

   default void a(byte[] var1) {
      this.stream(new ByteArrayInputStream(var1));
   }

   boolean c();

   default Object a(Collector var1) {
      Supplier var4 = var1.supplier();
      BiConsumer var5 = var1.accumulator();
      Function var6 = var1.finisher();
      Object var7 = var4.get();

      try {
         InputStream var8 = this.stream();
         Throwable var9 = null;

         Object var10;
         try {
            if (var8 != null) {
               Scanner var24 = new Scanner(var8, "UTF-8");

               while(var24.hasNextLine()) {
                  var5.accept(var7, var24.nextLine());
               }

               return var6.apply(var7);
            }

            var10 = var6.apply(var7);
         } catch (Throwable var21) {
            var9 = var21;
            throw var21;
         } finally {
            if (var8 != null) {
               if (var9 != null) {
                  try {
                     var8.close();
                  } catch (Throwable var20) {
                     var9.addSuppressed(var20);
                  }
               } else {
                  var8.close();
               }
            }

         }

         return var10;
      } catch (IOException var23) {
         var23.printStackTrace();
         return var6.apply(var7);
      }
   }

   long d();

   default HTTPRequest a(int var1) {
      return Unknown83.a(this, var1);
   }

   void b();

   default String f() {
      return (String)this.a(Collectors.joining());
   }

   default HTTPRequest h() {
      return Unknown83.b(this);
   }

   @Override
   InputStream stream();

   void stream(InputStream var1);

   default HTTPRequest g() {
      return Unknown83.a(this);
   }

   default HTTPRequest b(File var1) {
      return Unknown83.a(var1, this);
   }

   default List e() {
      return (List)this.a(Collectors.toList());
   }
}
