package de.jpx3.intave.access;

public final class UnsupportedFallbackOperationException extends IntaveInternalException {
   public static final UnsupportedFallbackOperationException DEFAULT = new UnsupportedFallbackOperationException("Can't locate player here");

   private UnsupportedFallbackOperationException() {
   }

   private UnsupportedFallbackOperationException(String var1) {
      super(var1);
   }

   public void setStackTrace(StackTraceElement[] var1) {
      super.setStackTrace(var1);
   }

   public synchronized Throwable fillInStackTrace() {
      this.setStackTrace(new StackTraceElement[0]);
      return this;
   }
}
