package de.jpx3.intave.access.player.storage;

import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.function.Consumer;

public class EmptyStorageGateway implements StorageGateway {
   @Override
   public void requestStorage(UUID var1, Consumer var2) {
   }

   @Override
   public void saveStorage(UUID var1, ByteBuffer var2) {
   }
}
