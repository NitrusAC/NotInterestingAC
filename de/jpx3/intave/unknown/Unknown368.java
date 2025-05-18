package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import de.jpx3.intave.bn;
import java.util.UUID;

public class Unknown368 extends Unknown353 {
   private String d;
   private UUID c;
   private bn f;
   private long a;

   public Unknown368(UUID var1, bn var2, String var3, long var4) {
      this.c = var1;
      this.f = var2;
      this.d = var3;
      this.a = var4;
   }

   public UUID c() {
      return this.c;
   }

   public long b() {
      return this.a;
   }

   public bn a() {
      return this.f;
   }

   public String e() {
      return this.d;
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      this.c = UUID.fromString(var1.readUTF());
      this.f = bn.a(var1.readInt());
      this.d = var1.readUTF();
      this.a = var1.readLong();
   }

   public Unknown368() {
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeUTF(this.c.toString());
      var1.writeInt(this.f.a());
      var1.writeUTF(this.d);
      var1.writeLong(this.a);
   }
}
