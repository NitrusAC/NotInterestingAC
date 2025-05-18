package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import java.util.UUID;

public class Unknown351 extends Unknown353 {
   private UUID c;
   private String e;
   private String d;
   private double a;

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeUTF(this.c.toString());
      var1.writeUTF(this.d);
      var1.writeUTF(this.e);
      var1.writeDouble(this.a);
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      this.c = UUID.fromString(var1.readUTF());
      this.d = var1.readUTF();
      this.e = var1.readUTF();
      this.a = var1.readDouble();
   }

   public Unknown351() {
   }

   public Unknown351(UUID var1, String var2, String var3, double var4) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.a = var4;
   }
}
