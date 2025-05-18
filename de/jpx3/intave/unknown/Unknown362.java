package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.event.EventVisitor;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public final class Unknown362 extends Event {
   private int c;
   private int e;
   private boolean d;

   public int c() {
      return this.e;
   }

   public Unknown362(Unknown369 var1) {
      this(var1.h(), var1.e(), var1.d());
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeInt(this.c);
      output.writeInt(this.e);
      output.writeBoolean(this.d);
   }

   public int b() {
      return this.c;
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }

   public Unknown362() {
   }

   public Unknown362(int var1, int var2, boolean var3) {
      this.c = var1;
      this.e = var2;
      this.d = var3;
   }

   public boolean a() {
      return this.d;
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      this.c = input.readInt();
      this.e = input.readInt();
      this.d = input.readBoolean();
   }
}
