package de.jpx3.intave.access.check;

import de.jpx3.intave.access.IntaveAccessException;

public final class UnknownCheckException extends IntaveAccessException {
   public UnknownCheckException() {
   }

   public UnknownCheckException(String var1) {
      super(var1);
   }

   public UnknownCheckException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownCheckException(Throwable var1) {
      super(var1);
   }
}
