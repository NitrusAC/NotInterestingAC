package de.jpx3.intave.anticheat.packet.wrap.impl;

import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.packet.wrap.EntityPacketReader;

public final class CPacketUseEntity extends EntityPacketReader {
   public EntityUseAction getAction() {
      EntityUseAction var4 = (EntityUseAction)this.getPacket().getEntityUseActions().readSafely(0);
      if (var4 == null) {
         var4 = ((WrappedEnumEntityUseAction)this.getPacket().getEnumEntityUseActions().read(0)).getAction();
      }

      return var4;
   }
}
