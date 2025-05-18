package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.unknown.Unknown4;

@Deprecated
public final class PluginInvocationInfo {
   private final String pluginName;
   private final String methodName;
   private final String className;

   public String getPluginName() {
      return this.pluginName;
   }

   public String toString() {
      return "PluginInvokationInfo{pluginName='"
         + this.pluginName
         + '\''
         + ", className='"
         + this.className
         + '\''
         + ", methodName='"
         + this.methodName
         + '\''
         + '}';
   }

   public String g() {
      return this.className.substring(this.className.lastIndexOf(".") + 1);
   }

   public PluginInvocationInfo(String var1, String var2, String var3) {
      this.pluginName = var1;
      this.className = var2;
      this.methodName = var3;
   }

   public String getMethodName() {
      return this.methodName;
   }

   public String getClassName() {
      return this.className;
   }

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }
}
