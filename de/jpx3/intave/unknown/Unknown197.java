package de.jpx3.intave.unknown;

public class Unknown197 {
   private static final String e;
   private Unknown278 b;
   private boolean a = true;
   private Unknown70 c;

   public Unknown197 a(Unknown278 var1) {
      if (this.b == null) {
         throw new IllegalStateException("Can not have or operation on empty requirement");
      } else {
         this.b = this.b.b(var1);
         return this;
      }
   }

   public Unknown197 c(Unknown278 var1) {
      this.b = var1;
      return this;
   }

   public Unknown197 b(Unknown278 var1) {
      if (this.b == null) {
         this.b = Unknown277.e();
      }

      this.b = this.b.c(var1);
      return this;
   }

   public Unknown197 a(Unknown70 var1) {
      this.c = var1;
      return this;
   }

   public Unknown328 b() {
      if (this.c == null) {
         this.f();
      }

      if (this.b == null) {
         this.b = Unknown277.e();
      }

      return new Unknown328(this.c, this.b, this.a, null);
   }

   public Unknown197 f() {
      return this.a(Unknown70.g);
   }

   public Unknown197 d() {
      return this.a(Unknown70.j);
   }

   public Unknown197 c() {
      return this.c(Unknown277.b());
   }

   public Unknown197 a() {
      this.a = false;
      return this;
   }

   public Unknown197 e() {
      return this.a(Unknown70.c);
   }
}
