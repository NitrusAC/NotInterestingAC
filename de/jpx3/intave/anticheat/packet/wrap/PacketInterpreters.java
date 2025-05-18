package de.jpx3.intave.anticheat.packet.wrap;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.injector.packet.PacketRegistry;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.impl.CPacketUseEntity;
import de.jpx3.intave.unknown.Unknown195;
import de.jpx3.intave.unknown.Unknown198;
import de.jpx3.intave.unknown.Unknown200;
import de.jpx3.intave.unknown.Unknown202;
import de.jpx3.intave.unknown.Unknown209;
import de.jpx3.intave.unknown.Unknown212;
import de.jpx3.intave.unknown.Unknown214;
import de.jpx3.intave.unknown.Unknown215;
import de.jpx3.intave.unknown.Unknown218;
import de.jpx3.intave.unknown.Unknown219;
import de.jpx3.intave.unknown.Unknown221;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public final class PacketInterpreters {
   private static final String c;
   private static final Map cache = new ConcurrentHashMap();

   private static PacketType a(Collection var0, String var1) {
      return (PacketType)var0.stream().filter(PacketInterpreters::b).findFirst().orElse(null);
   }

   private static void add(ClientPacket packet, Supplier provider) {
      PacketType var5 = a(a(ConnectionSide.CLIENT_SIDE), packet.getType());
      if (var5 != null) {
         cache.put(var5, ThreadLocal.withInitial(provider));
      }

   }

   private static boolean a(PacketType var0, String var1) {
      return var0.name().equalsIgnoreCase(var1);
   }

   public static void a() {
      add(ServerPacket.BLOCK_ACTION, Unknown214::new);
      add(ServerPacket.BLOCK_CHANGE, Unknown200::new);
      add(ServerPacket.BLOCK_BREAK, Unknown200::new);
      add(ServerPacket.MULTI_BLOCK_CHANGE, Unknown212::new);
      add(ServerPacket.MAP_CHUNK, Unknown218::new);
      add(ServerPacket.MAP_CHUNK_BULK, Unknown195::new);
      add(ServerPacket.ENTITY_METADATA, EntityPacketReader::new);
      add(ServerPacket.ENTITY_VELOCITY, EntityPacketReader::new);
      add(ServerPacket.SPAWN_ENTITY_LIVING, EntityPacketReader::new);
      add(ServerPacket.SPAWN_ENTITY, EntityPacketReader::new);
      add(ServerPacket.ENTITY_EFFECT, Unknown198::new);
      add(ServerPacket.REMOVE_ENTITY_EFFECT, EntityPacketReader::new);
      add(ServerPacket.NAMED_ENTITY_SPAWN, EntityPacketReader::new);
      add(ServerPacket.UPDATE_ATTRIBUTES, EntityPacketReader::new);
      add(ServerPacket.BLOCK_BREAK_ANIMATION, EntityPacketReader::new);
      add(ServerPacket.ENTITY_DESTROY, Unknown221::new);
      add(ClientPacket.CUSTOM_PAYLOAD, Unknown209::new);
      add(ClientPacket.BLOCK_PLACE, Unknown215::new);
      add(ClientPacket.USE_ITEM, Unknown215::new);
      add(ClientPacket.USE_ENTITY, CPacketUseEntity::new);
      add(ClientPacket.BLOCK_DIG, Unknown202::new);
   }

   public static PacketReader getInterpreter(PacketContainer packet) {
      PacketType var4 = packet.getType();
      ThreadLocal var5 = (ThreadLocal)cache.get(var4);
      if (var5 == null) {
         throw new IllegalStateException("No interpreter available for " + var4);
      } else {
         PacketReader var6 = (PacketReader)var5.get();
         var6.read(packet);
         if (var6 instanceof Unknown219) {
            ((Unknown219)var6).b();
         }

         return var6;
      }
   }

   private static boolean b(String var0, PacketType var1) {
      return a(var1, var0);
   }

   private static void add(ServerPacket var0, Supplier var1) {
      PacketType var5 = a(a(ConnectionSide.SERVER_SIDE), var0.getName());
      if (var5 != null) {
         cache.put(var5, ThreadLocal.withInitial(var1));
      }

   }

   private static Collection a(ConnectionSide var0) {
      HashSet var4 = new HashSet();
      if (var0.isForServer()) {
         var4.addAll(PacketRegistry.getServerPacketTypes());
      }

      if (var0.isForClient()) {
         var4.addAll(PacketRegistry.getClientPacketTypes());
      }

      return var4;
   }
}
