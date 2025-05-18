package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import java.util.UUID;

public class Unknown378 extends Unknown353 {
   private UUID c;
   private String a;

   public Unknown378() {
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeUTF(this.c.toString());
      var1.writeUTF(this.a);
   }

   public Unknown378(UUID var1, String var2) {
      this.c = var1;
      this.a = var2;
   }

   public UUID a() {
      return this.c;
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      this.c = UUID.fromString(var1.readUTF());
      this.a = var1.readUTF();
   }

   public String b() {
      return this.a;
   }
}
