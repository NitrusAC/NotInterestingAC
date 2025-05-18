package de.jpx3.intave.anticheat.packet.wrap.converter;

import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.unknown.Unknown225;
import java.util.ArrayList;

public final class PlayerInfoDataConverter implements EquivalentConverter {
   public Object toNms(PlayerInfoData var1) {
      if (Unknown225.d() == null) {
         try {
            ArrayList var5 = new ArrayList();
            if (!MinecraftVersion.V_1_17.atOrAbove()) {
               var5.add(Server.PLAYER_INFO.getPacketClass());
            }

            var5.add(MinecraftReflection.getGameProfileClass());
            var5.add(Integer.TYPE);
            var5.add(EnumWrappers.getGameModeClass());
            var5.add(MinecraftReflection.getIChatBaseComponentClass());
            Unknown225.a(MinecraftReflection.getPlayerInfoDataClass().getConstructor((Class[])var5.toArray(new Class[0])));
         } catch (Exception var8) {
            throw new RuntimeException("Cannot find PlayerInfoData constructor.", var8);
         }
      }

      try {
         Object var9 = EnumWrappers.getGameModeConverter().getGeneric(var1.getGameMode());
         Object var6 = var1.getDisplayName() != null ? var1.getDisplayName().getHandle() : null;
         return MinecraftVersion.V_1_17.atOrAbove()
            ? Unknown225.d().newInstance(var1.getProfile().getHandle(), var1.getLatency(), var9, var6)
            : Unknown225.d().newInstance(null, var1.getProfile().getHandle(), var1.getLatency(), var9, var6);
      } catch (Exception var7) {
         throw new RuntimeException("Failed to construct PlayerInfoData.", var7);
      }
   }

   public Object getSpecific(Object var1) {
      return this.fromNms(var1);
   }

   public Class getSpecificType() {
      return PlayerInfoData.class;
   }

   public Object getGeneric(Object var1) {
      return this.toNms((PlayerInfoData)var1);
   }

   public PlayerInfoData fromNms(Object var1) {
      if (Unknown225.b() == null) {
         Unknown225.a(MinecraftReflection.getGameProfileClass());
      }

      if (Unknown225.e() == null) {
         Unknown225.b(EnumWrappers.getGameModeClass());
      }

      if (Unknown225.a() == null) {
         Unknown225.c(MinecraftReflection.getIChatBaseComponentClass());
      }

      StructureModifier var6 = new StructureModifier(var1.getClass(), null, false).withTarget(var1);
      StructureModifier var7 = var6.withType(Unknown225.b(), BukkitConverters.getWrappedGameProfileConverter());
      WrappedGameProfile var8 = (WrappedGameProfile)var7.read(0);
      StructureModifier var9 = var6.withType(Integer.TYPE);
      int var10 = var9.read(0);
      StructureModifier var11 = var6.withType(Unknown225.e(), EnumWrappers.getGameModeConverter());
      NativeGameMode var12 = (NativeGameMode)var11.read(0);
      StructureModifier var13 = var6.withType(Unknown225.a(), BukkitConverters.getWrappedChatComponentConverter());
      WrappedChatComponent var14 = (WrappedChatComponent)var13.read(0);
      return new PlayerInfoData(var8, var10, var12, var14);
   }
}
