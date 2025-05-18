package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Unknown57 {
   private Consumer a;
   private PlayerData data;
   private BiConsumer c;
   private int b;
   private BinaryOperator f;
   private BiConsumer d;

   public Unknown57 a(PlayerData data) {
      this.data = data;
      return this;
   }

   public Unknown57 a(BinaryOperator var1) {
      this.f = var1;
      return this;
   }

   private static Object b(Object var0, Object var1) {
      return var1;
   }

   public Unknown57 a(int var1) {
      this.b = var1;
      return this;
   }

   public Unknown57 a(BiConsumer var1) {
      this.c = var1;
      return this;
   }

   public Unknown57 a(Consumer var1) {
      this.a = var1;
      return this;
   }

   public Unknown57 b() {
      this.f = Unknown57::a;
      return this;
   }

   public Unknown57 b(BiConsumer var1) {
      this.d = var1;
      return this;
   }

   public Unknown135 a() {
      if (this.data == null) {
         throw new IllegalStateException("User must be set");
      } else if (this.c == null) {
         throw new IllegalStateException("Applier must be set");
      } else if (this.a == null) {
         throw new IllegalStateException("Resetter must be set");
      } else {
         if (this.f == null) {
            this.c();
         }

         if (this.b == 0) {
            this.b = Integer.MAX_VALUE;
         }

         return new Unknown135(this.data, this.c, this.d, this.a, this.f, this.b);
      }
   }

   private static Object a(Object var0, Object var1) {
      return var0;
   }

   public Unknown57 c() {
      this.f = Unknown57::b;
      return this;
   }
}
