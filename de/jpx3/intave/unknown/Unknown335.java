package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

public interface Unknown335 {
   static byte[] a(byte[] var0) {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         InflaterOutputStream var2 = new InflaterOutputStream(var1, new Inflater());
         var2.write(var0);
         var2.flush();
         var2.close();
         return var1.toByteArray();
      } catch (Exception var3) {
         var3.printStackTrace();
         return new byte[0];
      }
   }

   void a(ByteArrayDataOutput var1);

   default ByteBuffer a() {
      ByteArrayDataOutput var1 = ByteStreams.newDataOutput();
      this.a(var1);
      byte[] var2 = var1.toByteArray();
      return ByteBuffer.wrap(b(var2));
   }

   void a(ByteArrayDataInput var1);

   default void a(ByteBuffer var1) {
      byte[] var5 = var1.array();
      if (var5.length != 0) {
         byte[] var6 = a(var5);
         this.a(ByteStreams.newDataInput(var6));
      }
   }

   static byte[] b(byte[] var0) {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DeflaterOutputStream var2 = new DeflaterOutputStream(var1, new Deflater(9));
         var2.write(var0);
         var2.flush();
         var2.close();
         return var1.toByteArray();
      } catch (Exception var3) {
         var3.printStackTrace();
         return new byte[0];
      }
   }
}
