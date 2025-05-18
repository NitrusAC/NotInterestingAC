package de.jpx3.intave.anticheat.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
   String[] aliases();

   String a() default "none";

   boolean b() default false;

   String e() default "invalid";

   String d() default "none";
}
