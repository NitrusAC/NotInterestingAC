package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm1;
import de.jpx3.intave.unknown.asm.Asm28;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Unknown371 implements ListIterator {
   final Asm28 this$0;
   Asm1 b;
   Asm1 c;
   Asm1 a;

   public void set(Object var1) {
      if (this.b != null) {
         this.this$0.b(this.b, (Asm1)var1);
         if (this.b == this.a) {
            this.a = (Asm1)var1;
         } else {
            this.c = (Asm1)var1;
         }

      } else {
         throw new IllegalStateException();
      }
   }

   public boolean hasPrevious() {
      return this.a != null;
   }

   public void remove() {
      if (this.b != null) {
         if (this.b == this.c) {
            this.c = this.c.e;
         } else {
            this.a = this.a.k;
         }

         this.this$0.d(this.b);
         this.b = null;
      } else {
         throw new IllegalStateException();
      }
   }

   public Object next() {
      if (this.c == null) {
         throw new NoSuchElementException();
      } else {
         Asm1 var4 = this.c;
         this.a = var4;
         this.c = var4.e;
         this.b = var4;
         return var4;
      }
   }

   public void add(Object var1) {
      if (this.c != null) {
         this.this$0.c(this.c, (Asm1)var1);
      } else if (this.a != null) {
         this.this$0.a(this.a, (Asm1)var1);
      } else {
         this.this$0.a((Asm1)var1);
      }

      this.a = (Asm1)var1;
      this.b = null;
   }

   public boolean hasNext() {
      return this.c != null;
   }

   public Unknown371(Asm28 var1, int var2) {
      this.this$0 = var1;
      if (var2 == var1.g()) {
         this.c = null;
         this.a = var1.d();
      } else {
         this.c = var1.a(var2);
         this.a = this.c.k;
      }

   }

   public Object previous() {
      if (this.a == null) {
         throw new NoSuchElementException();
      } else {
         Asm1 var4 = this.a;
         this.c = var4;
         this.a = var4.k;
         this.b = var4;
         return var4;
      }
   }

   public int previousIndex() {
      if (this.a == null) {
         return -1;
      } else {
         if (this.this$0.a == null) {
            this.this$0.a = this.this$0.f();
         }

         return this.a.t;
      }
   }

   public int nextIndex() {
      if (this.c == null) {
         return this.this$0.g();
      } else {
         if (this.this$0.a == null) {
            this.this$0.a = this.this$0.f();
         }

         return this.c.t;
      }
   }
}
