package de.jpx3.intave.unknown;

import com.comphenix.protocol.ProtocolLibrary;
import java.util.Arrays;

public final class Unknown277 {
   private static boolean d() {
      return ProtocolLibrary.getProtocolManager() != null;
   }

   public static Unknown278 c(Unknown278[] var0) {
      return Unknown277::a;
   }

   public static Unknown278 b() {
      return a("ProtocolLib").c(Unknown277::d);
   }

   public static Unknown278 a(String var0) {
      return new Unknown261(new String[]{var0});
   }

   private static boolean a(Unknown278[] var0) {
      return Arrays.stream(var0).allMatch(Unknown278::a);
   }

   public static Unknown278 b(Unknown278[] var0) {
      return Unknown277::d;
   }

   public static Unknown278 a(String[] var0) {
      return new Unknown261(var0);
   }

   private static boolean d(Unknown278[] var0) {
      return Arrays.stream(var0).anyMatch(Unknown278::a);
   }

   public static Unknown278 a() {
      return a("Intave");
   }

   public static Unknown278 e() {
      return new Unknown136();
   }
}
