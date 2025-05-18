package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.event.EventVisitor;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Unknown375 extends Event {
   private final Map c = new HashMap();

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      int var6 = input.readInt();

      for(int var7 = 0; var7 < var6; ++var7) {
         this.c.put(input.readUTF(), input.readBoolean());
      }

   }

   public Unknown375() {
   }

   public Map a() {
      return this.c;
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeInt(this.c.size());

      for(Entry var7 : this.c.entrySet()) {
         output.writeUTF((String)var7.getKey());
         output.writeBoolean(var7.getValue());
      }

   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }

   public Unknown375(Map var1) {
      this.c.putAll(var1);
   }
}
