package de.jpx3.intave.anticheat.listener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.bukkit.event.EventPriority;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BukkitEventListener {
   EventPriority a() default EventPriority.NORMAL;

   boolean b() default false;
}
