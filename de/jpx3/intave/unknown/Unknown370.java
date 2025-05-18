package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.event.EventVisitor;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public final class Unknown370 extends Event {
   private int d;
   private int c;
   private String e;

   public Unknown370() {
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeInt(this.d);
      output.writeUTF(this.e);
      output.writeInt(this.c);
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      this.d = input.readInt();
      this.e = input.readUTF();
      this.c = input.readInt();
   }

   public Unknown370(int var1, String var2, int var3) {
      this.d = var1;
      this.e = var2;
      this.c = var3;
   }
}
