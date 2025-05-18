package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.event.EntityMoveEvent;
import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.io.DataInputStream;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public final class Unknown396 extends Unknown400 implements Runnable {
   private boolean i = false;
   private final Consumer k;
   private final Executor j;

   @Override
   public Map a() {
      return super.a();
   }

   @Override
   public boolean a(String var1) {
      return super.a(var1);
   }

   private static void b(Unknown400 var0) {
   }

   @Override
   public boolean a(int var1) {
      return super.a(var1);
   }

   @Override
   public void visit(EntityMoveEvent var1) {
      super.visit(var1);
   }

   public void run() {
      Event var4;
      try {
         while((var4 = this.c()) != null && !this.i) {
            this.parse(var4);
         }
      } finally {
         this.k.accept(this);
      }

   }

   @Override
   public Set b() {
      return super.b();
   }

   @Override
   public void visit(Unknown375 var1) {
      super.visit(var1);
   }

   public Unknown396(DataInputStream var1, Executor var2, Consumer var3) {
      super(var1, null);
      this.j = var2;
      this.k = var3;
   }

   @Override
   public boolean a(long var1) {
      return false;
   }

   @Override
   public void d() {
      this.i = true;
   }

   @Override
   public void visit(Event event) {
      super.visit(event);
   }

   @Override
   public Unknown369 c() {
      return super.c();
   }

   public Unknown396(DataInputStream var1, Executor var2) {
      this(var1, var2, Unknown396::b);
   }

   @Override
   public IntaveVector b(int var1) {
      return super.b(var1);
   }

   @Override
   public void b() {
      this.j.execute(this);
   }
}
