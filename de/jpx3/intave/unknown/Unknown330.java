package de.jpx3.intave.unknown;

import java.util.function.BinaryOperator;

final class Unknown330 extends Unknown337 {
   final Unknown337[] val$matchers;
   final Unknown7 val$operation;

   @Override
   public boolean a(int var1) {
      if (this.val$matchers.length == 1) {
         return this.val$matchers[0].a(var1);
      } else {
         BinaryOperator var5 = this.val$operation.b();
         boolean var6 = var5.apply(this.val$matchers[0].a(var1), this.val$matchers[1].a(var1));

         for(int var7 = 1; var7 < this.val$matchers.length; ++var7) {
            var6 = var5.apply(var6, this.val$matchers[var7].a(var1));
         }

         return var6;
      }
   }

   public String toString() {
      StringBuilder var4 = new StringBuilder();

      for(int var5 = 0; var5 < this.val$matchers.length; ++var5) {
         Unknown337 var6 = this.val$matchers[var5];
         boolean var7 = var5 + 1 == this.val$matchers.length;
         var4.append(var6.toString()).append(" ");
         if (!var7) {
            var4.append(this.val$operation.f).append(" ");
         }
      }

      return "(" + var4 + ")";
   }

   Unknown330(Unknown337[] var1, Unknown7 var2) {
      this.val$matchers = var1;
      this.val$operation = var2;
   }
}
