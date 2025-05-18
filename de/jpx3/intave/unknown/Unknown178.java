package de.jpx3.intave.unknown;

import org.ow2.asm.RandomASMClass1;

final class Unknown178 extends RandomASMClass1 {
   final String val$methodName;
   final String val$methodDescription;
   final Unknown62 val$methodTransformer;

   @Override
   public Unknown338 a(int var1, String var2, String var3, String var4, String[] var5) {
      Unknown338 var6 = super.a(var1, var2, var3, var4, var5);
      if (Unknown147.b(var2, var3, this.val$methodName, this.val$methodDescription)) {
         var6 = this.val$methodTransformer.a(var6, var1, var2, var3);
      }

      return var6;
   }

   Unknown178(int var1, RandomASMClass1 var2, String var3, String var4, Unknown62 var5) {
      super(var1, var2);
      this.val$methodName = var3;
      this.val$methodDescription = var4;
      this.val$methodTransformer = var5;
   }
}
