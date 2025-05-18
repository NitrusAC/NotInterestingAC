package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public final class EntityAttackEntityEvent extends Event {
   private int attacker;
   private int attacked;

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeInt(this.attacked);
      output.writeInt(this.attacker);
   }

   public EntityAttackEntityEvent() {
   }

   public EntityAttackEntityEvent(int attacker, int attacked) {
      this.attacked = attacker;
      this.attacker = attacked;
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      this.attacked = input.readInt();
      this.attacker = input.readInt();
   }

   public static EntityAttackEntityEvent of(int attacker, int attacked) {
      return new EntityAttackEntityEvent(attacker, attacked);
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }
}
