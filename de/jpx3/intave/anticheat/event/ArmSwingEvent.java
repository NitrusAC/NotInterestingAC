package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public final class ArmSwingEvent extends Event {
   private static final ArmSwingEvent EMPTY = new ArmSwingEvent();

   public static ArmSwingEvent ofEmpty() {
      return EMPTY;
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }
}
