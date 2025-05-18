package de.jpx3.intave.anticheat.util.http;

import com.google.common.collect.ImmutableList;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public final class RequestEncryption {
   private final MessageDigest digest;
   private final List uuidList;

   public boolean isBlacklisted(String var1) {
      return this.findInRequest(this.transformUUID(var1));
   }

   private static boolean equals(String string1, String string2) {
      return string2.equals(string1);
   }

   private String transformUUID(String string) {
      return base64(this.digest.digest(string.getBytes(StandardCharsets.UTF_8)));
   }

   public static RequestEncryption a() {
      return new RequestEncryption(ImmutableList.of());
   }

   private RequestEncryption(List var1) {
      this.uuidList = var1;

      try {
         this.digest = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException var5) {
         throw new IllegalStateException("Unable to find SHA-256 hashing digest", var5);
      }
   }

   private boolean findInRequest(String string) {
      return this.uuidList.stream().anyMatch(RequestEncryption::equals);
   }

   private static String base64(byte[] arr) {
      StringBuilder var4 = new StringBuilder(2 * arr.length);

      for(byte var8 : arr) {
         String var9 = Integer.toHexString(255 & var8);
         if (var9.length() == 1) {
            var4.append('0');
         }

         var4.append(var9);
      }

      return var4.toString();
   }

   public static RequestEncryption init(InputStream inputStream) {
      ArrayList var4 = new ArrayList();

      try {
         Scanner var5 = new Scanner(inputStream);

         while(var5.hasNextLine()) {
            String var6 = var5.nextLine();
            if (var6.length() == 64) {
               var4.add(var6);
            }
         }

         inputStream.close();
      } catch (Exception var7) {
      }

      return new RequestEncryption(ImmutableList.copyOf(var4));
   }

   public boolean isInRequest(UUID uUID) {
      return this.findInRequest(this.transformUUID(uUID.toString()));
   }
}
