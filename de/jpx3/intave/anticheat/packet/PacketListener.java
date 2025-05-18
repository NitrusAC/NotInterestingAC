package de.jpx3.intave.anticheat.packet;

import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.unknown.Unknown116;
import de.jpx3.intave.unknown.Unknown5;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PacketListener {
   ClientPacket[] packetTypes() default {};

   boolean c() default true;

   Unknown116 b() default Unknown116.a;

   ServerPacket[] g() default {};

   String f() default "no identifier assigned";

   Unknown5 e() default Unknown5.a;

   IntaveListenerPriority priority() default IntaveListenerPriority.NORMAL;
}
