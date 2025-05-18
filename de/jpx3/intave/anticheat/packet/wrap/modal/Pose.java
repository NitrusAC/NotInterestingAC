package de.jpx3.intave.anticheat.packet.wrap.modal;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.Headings;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.collision.Box;
import java.util.Map;

public enum Pose {
   public static final Pose SLEEPING = new Pose();
   public static final Map SNEAKING_V_1_16 = ImmutableMap.builder().putAll(Pose.j).put(Pose.SNEAKING, HitboxSize.of(0.6F, 1.5F)).build();
   public static final Pose a = new Pose();
   private static final Map j = ImmutableMap.builder()
      .put(a, HitboxSize.ofPlayer())
      .put(SLEEPING, HitboxSize.of(0.2F, 0.2F))
      .put(Pose.ELYTRA, HitboxSize.of(0.6F, 0.6F))
      .put(Pose.c, HitboxSize.of(0.6F, 0.6F))
      .build();
   public static final Pose SNEAKING = new Pose();
   public static final Map SNEAKING_V_1_8 = ImmutableMap.builder().putAll(j).put(SNEAKING, HitboxSize.of(0.6F, 1.8F)).build();
   public static final Pose c = new Pose();
   public static final Pose ELYTRA = new Pose();
   private static final Pose[] values = new Pose[]{a, ELYTRA, c, SLEEPING, SNEAKING};
   public static final Map SNEAKING_V_1_9 = ImmutableMap.builder().putAll(j).put(SNEAKING, HitboxSize.of(0.6F, 1.65F)).build();

   public float getHeight(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      HeadingHandler var3 = var2.getHeadingHandler();
      return var3 == Headings.BOAT ? 0.5625F : this.getHitboxSize(data).getHeight();
   }

   public Box from(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      return this.from(data, var2.x, var2.y, var2.z);
   }

   public static Map getByVersion(int version) {
      if (version >= VersionHolder.V_1_13) {
         return SNEAKING_V_1_16;
      } else {
         return version >= VersionHolder.V_1_9 ? SNEAKING_V_1_9 : SNEAKING_V_1_8;
      }
   }

   public float getWidth(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      HeadingHandler var3 = var2.getHeadingHandler();
      return var3 == Headings.BOAT ? 1.375F : this.getHitboxSize(data).getWidth();
   }

   public Box from(PlayerData data, double x, double y, double z) {
      float var8 = this.getWidth(data) / 2.0F;
      float var9 = this.getHeight(data);
      return new Box(x - (double)var8, y, z - (double)var8, x + (double)var8, y + (double)var9, z + (double)var8);
   }

   private HitboxSize getHitboxSize(PlayerData data) {
      return data.getHitboxSize(this);
   }
}
