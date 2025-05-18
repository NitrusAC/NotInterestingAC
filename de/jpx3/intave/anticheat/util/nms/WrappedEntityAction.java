package de.jpx3.intave.anticheat.util.nms;

import com.comphenix.protocol.events.PacketContainer;
import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.util.ReflectionUtil;

public final class WrappedEntityAction {
   private static final Class clazz = ReflectionUtil.getClazz("PacketPlayInEntityAction$EnumPlayerAction");

   public static EntityAction readEntityAction(PacketContainer packet) {
      return (EntityAction)packet.getEnumModifier(EntityAction.class, clazz).read(0);
   }
}
