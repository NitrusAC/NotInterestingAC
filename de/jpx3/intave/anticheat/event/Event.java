package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public abstract class Event {
   private long a;

   public abstract void write(ByteSerializer serializer, DataOutput output);

   public void a(long var1) {
      this.a = var1;
   }

   public abstract void accept(EventVisitor visitor);

   public abstract void read(ByteSerializer serializer, DataInput input);

   public long a() {
      return this.a;
   }
}
