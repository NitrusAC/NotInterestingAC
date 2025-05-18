package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import de.jpx3.intave.anticheat.util.http.IHTTPRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public interface Unknown1 extends Function {
   String d;

   default Object a(HTTPRequest var1) {
      return this.apply(var1.e());
   }

   default Object a(File var1) {
      return this.b(new FileInputStream(var1));
   }

   default Object b(InputStream var1) {
      return this.apply(a(var1));
   }

   static List a(InputStream var0) {
      Scanner var4 = new Scanner(var0);
      ArrayList var5 = new ArrayList();

      while(var4.hasNextLine()) {
         var5.add(var4.nextLine());
      }

      return var5;
   }

   default Object a(String var1) {
      InputStream var5 = IntavePlugin.class.getResourceAsStream(var1);
      if (var5 == null) {
         var5 = IntavePlugin.class.getResourceAsStream(var1.substring(1));
         if (var5 == null) {
            throw new IllegalStateException("Unable to locate resource in jar: " + var1);
         }
      }

      return this.b(var5);
   }

   default Object a(IHTTPRequest var1) {
      return this.b(var1.stream());
   }
}
