package de.jpx3.intave.unknown;

import java.lang.reflect.Field;

final class Unknown276 implements Unknown46 {
   final Field val$field;

   @Override
   public boolean a(Object var1) {
      return this.val$field.getDeclaringClass().isAssignableFrom(var1.getClass());
   }

   @Override
   public Object b(Object var1) {
      try {
         return this.val$field.get(var1);
      } catch (IllegalAccessException var5) {
         throw new RuntimeException("Cannot access reflection.", var5);
      }
   }

   Unknown276(Field var1) {
      this.val$field = var1;
   }

   @Override
   public void a(Object var1, Object var2) {
      try {
         this.val$field.set(var1, var2);
      } catch (IllegalAccessException var6) {
         throw new RuntimeException("Cannot access reflection.", var6);
      }
   }
}
