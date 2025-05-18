package de.jpx3.intave.access.player.storage;

import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.function.Consumer;

public interface StorageGateway {
   void requestStorage(UUID var1, Consumer var2);

   void saveStorage(UUID var1, ByteBuffer var2);
}
