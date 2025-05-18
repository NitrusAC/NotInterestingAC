package de.jpx3.intave.access;

public final class InvalidDependencyException extends IntaveBootFailureException {
   public InvalidDependencyException() {
   }

   public InvalidDependencyException(String var1) {
      super(var1);
   }

   public InvalidDependencyException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public InvalidDependencyException(Throwable var1) {
      super(var1);
   }
}
