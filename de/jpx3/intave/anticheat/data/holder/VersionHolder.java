package de.jpx3.intave.anticheat.data.holder;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.ProtocolVersionResolver;
import de.jpx3.intave.unknown.Unknown241;
import org.bukkit.entity.Player;

@Relocate
public final class VersionHolder {
   private int l;
   private Boolean rewindVersion;
   public static int V_1_17 = 755;
   public static int V_1_11 = 315;
   public static int V_1_13_2 = 404;
   public static int V_1_8_8 = 47;
   public static int V_1_14 = 477;
   public static int V_1_11_1 = 316;
   public static int V_1_9_SNPT = 97;
   private MinecraftVersion version;
   public static int V_1_9 = 107;
   private int versionId;
   public static int V_1_16 = 735;
   private static final String x;
   public static int V_1_13 = 393;
   private String a;
   public static int UNKNOWN = 1000;
   public static int V_1_10 = 210;
   private final PlayerData data;
   private static final boolean modern = de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_9.atOrAbove();
   private String n = "Unknown";
   public static int V_1_15 = 573;
   public static int V_1_12 = 335;

   public boolean isPre1_14() {
      return this.versionId < V_1_14;
   }

   private String getName(int var1) {
      return ProtocolVersionResolver.a(var1);
   }

   public boolean isMessyVersion() {
      return this.versionId >= V_1_14;
   }

   public boolean isRewindVersion() {
      if (this.rewindVersion == null || this.l < 2) {
         MinecraftVersion var1 = MinecraftVersion.getCurrentVersion();
         MinecraftVersion var2 = new MinecraftVersion(this.getName(this.versionId));
         this.rewindVersion = !var2.isAtLeast(var1);
      }

      return this.rewindVersion;
   }

   public int getVersionId() {
      return this.versionId;
   }

   public String getVersionString() {
      return this.a;
   }

   public boolean isSub1_14() {
      return this.versionId < V_1_14;
   }

   public void a(int versionId) {
      String var2 = this.getName(versionId);
      if (versionId <= 0) {
         versionId = UNKNOWN;
         this.version = de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_18_2;
      } else {
         this.version = new MinecraftVersion(var2);
         MinecraftVersion var3 = MinecraftVersion.getCurrentVersion();
         MinecraftVersion var4 = new MinecraftVersion(var2);
         this.rewindVersion = !var4.isAtLeast(var3);
      }

      this.versionId = versionId;
      this.a = var2;
   }

   public boolean iss1_14() {
      return this.versionId >= V_1_14;
   }

   public boolean is_1_15() {
      return this.versionId >= V_1_15;
   }

   public boolean is1_17() {
      return this.versionId >= V_1_17;
   }

   @Deprecated
   public float l() {
      if (this.versionId >= V_1_13_2) {
         return 1.5F;
      } else {
         return this.versionId >= V_1_9 ? 1.65F : 1.8F;
      }
   }

   public boolean isOldVersion() {
      return this.versionId <= V_1_8_8;
   }

   public boolean isNewerVersion() {
      return this.versionId >= V_1_9;
   }

   public void a(Player var1) {
      this.a(var1 == null ? -1 : Unknown241.b(var1));
      ++this.l;
   }

   public boolean is1_9() {
      return this.versionId >= V_1_9;
   }

   public boolean is1_13() {
      return this.versionId >= V_1_13;
   }

   public boolean isSub_1_11_1() {
      return this.versionId <= V_1_11_1 && !this.isRewindVersion();
   }

   public float B() {
      boolean var1 = this.data.A().a();
      return this.versionId >= V_1_13_2 && !var1 ? 0.35F : 0.08F;
   }

   public boolean isHcfVersion() {
      return this.versionId < V_1_8_8;
   }

   public void a(String var1) {
      this.n = var1;
   }

   public String getClientName() {
      return this.n;
   }

   public boolean is1_15() {
      return this.versionId >= V_1_15;
   }

   public boolean isLegacy() {
      return this.versionId <= V_1_8_8 && !modern;
   }

   public boolean isModern() {
      return this.versionId >= V_1_9;
   }

   public MinecraftVersion getVersion() {
      return this.version;
   }

   public boolean is1_14() {
      return this.versionId >= V_1_14;
   }

   public boolean isSuperModern() {
      return this.is1_9() && this.versionId >= V_1_15;
   }

   public VersionHolder(Player player, PlayerData data) {
      this.data = data;
      this.a(player);
   }

   public boolean is1_12() {
      return this.versionId >= V_1_12;
   }

   public boolean is_1_14_sub_1_15() {
      return this.versionId < V_1_15 && this.versionId >= V_1_14;
   }

   public boolean isNewCollision() {
      return this.versionId >= V_1_13;
   }

   public boolean isModernButSub1_15() {
      return this.is1_9() && this.versionId < V_1_15;
   }
}
