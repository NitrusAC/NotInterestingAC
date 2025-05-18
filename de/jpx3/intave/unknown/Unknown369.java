package de.jpx3.intave.unknown;

import de.jpx3.intave.kt;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.util.function.Consumer;
import org.bukkit.GameMode;

public interface Unknown369 {
   float i();

   void a(Consumer var1);

   float m();

   boolean a(long var1);

   float c();

   boolean a(GameMode var1);

   boolean a(int var1, float var2);

   ByteSerializer l();

   void a(ByteSerializer var1);

   boolean d();

   void a(String var1);

   kt g();

   IntaveVector f();

   kt j();

   double b();

   Storable a(Class var1);

   double getZ();

   void a(String var1, Certainty var2, String var3);

   boolean b(long var1);

   int h();

   double o();

   boolean a(int var1);

   float n();

   int e();

   void a(Unknown227 var1, String var2);
}
