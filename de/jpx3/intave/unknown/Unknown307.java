package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.util.ReflectionUtil;

public enum Unknown307 {
   private static final Unknown307[] f = new Unknown307[]{Unknown307.a, Unknown307.b, Unknown307.c};
   public static final Unknown307 c = new Unknown307(false);
   public static final Unknown307 b = new Unknown307(true);
   private final boolean d;
   private Object e;
   public static final Unknown307 a = new Unknown307(true);

   private Unknown307(boolean var3) {
      this.d = var3;
   }

   @Deprecated
   public Object a() {
      if (!this.d) {
         throw new IntaveInternalException("Cannot resolve actual fluid tag");
      } else {
         if (this.e == null) {
            this.e = this.b();
         }

         return this.e;
      }
   }

   @Deprecated
   private Object b() {
      try {
         return ReflectionUtil.getField("TagsFluid", this.name()).get(null);
      } catch (IllegalAccessException var4) {
         throw new IntaveInternalException("Cannot access fluid tag", var4);
      }
   }
}
