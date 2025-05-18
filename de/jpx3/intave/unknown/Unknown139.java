package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public final class Unknown139 {
   public byte[] a(Unknown353 var1) {
      ByteArrayDataOutput var2 = ByteStreams.newDataOutput();
      var1.a(var2);
      return var2.toByteArray();
   }
}
