package de.jpx3.intave.unknown;

import de.jpx3.intave.pZ;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unknown66 {
   pZ a() default pZ.a;

   Unknown380[] value();
}
