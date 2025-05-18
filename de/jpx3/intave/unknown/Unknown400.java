package de.jpx3.intave.unknown;

import de.jpx3.intave.jT;
import de.jpx3.intave.kY;
import de.jpx3.intave.nF;
import de.jpx3.intave.p0;
import de.jpx3.intave.anticheat.event.EntityMoveEvent;
import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class Unknown400 extends Unknown391 {
   private final Set e;
   private final Map d;
   private final Map h;
   private final p0 c;
   private final DataInputStream g;
   private final Map f = new HashMap();
   private final ByteSerializer a;

   public abstract void b();

   @Override
   public void visit(Event event) {
      this.c.a(event);
      MoudleLoader.j().b().a(this.c, event);
   }

   private static IntaveVector a(EntityMoveEvent var0, Integer var1, IntaveVector var2) {
      if (var2 == null) {
         var2 = new IntaveVector();
      }

      if (var0.b()) {
         var2.setX(var0.h());
      }

      if (var0.e()) {
         var2.setY(var0.k());
      }

      if (var0.d()) {
         var2.setZ(var0.l());
      }

      return var2;
   }

   @Override
   public Unknown369 c() {
      return this.c;
   }

   @Override
   public Set b() {
      return this.e;
   }

   protected Event c() {
      try {
         short var1 = this.g.readShort();
         byte var2 = this.g.readByte();
         Event var3 = nF.a(var2);
         var3.read(this.a, this.g);
         var3.a((long)var1);
         return var3;
      } catch (IOException var4) {
         return null;
      }
   }

   @Override
   public IntaveVector b(int var1) {
      return var1 == this.c().h() ? this.c().f() : (IntaveVector)this.h.get(var1);
   }

   public abstract void d();

   @Override
   public boolean a(int var1) {
      return this.d.getOrDefault(var1, false);
   }

   private static Boolean b(EntityMoveEvent var0, Integer var1, Boolean var2) {
      return var0.a();
   }

   @Override
   public Map a() {
      return this.f;
   }

   @Override
   public void visit(EntityMoveEvent var1) {
      int var2 = var1.i();
      this.e.add(var2);
      this.h.compute(var2, Unknown400::a);
      this.d.compute(var2, Unknown400::b);
      this.visit((Event)var1);
   }

   @Override
   public boolean a(String var1) {
      return this.f.getOrDefault(var1, false);
   }

   @Override
   public void visit(Unknown375 var1) {
      this.f.putAll(var1.a());
   }

   public Unknown400(DataInputStream var1, ByteSerializer var2) {
      this.c = new p0(new kY[]{new jT(System.out)});
      this.h = new HashMap();
      this.d = new HashMap();
      this.e = new HashSet();
      this.g = var1;
      this.a = var2;
      this.c.a(var2);
   }
}
