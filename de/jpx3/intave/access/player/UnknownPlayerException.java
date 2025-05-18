package de.jpx3.intave.access.player;

import de.jpx3.intave.access.IntaveAccessException;

public final class UnknownPlayerException extends IntaveAccessException {
   public UnknownPlayerException() {
   }

   public UnknownPlayerException(String var1) {
      super(var1);
   }

   public UnknownPlayerException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownPlayerException(Throwable var1) {
      super(var1);
   }
}
