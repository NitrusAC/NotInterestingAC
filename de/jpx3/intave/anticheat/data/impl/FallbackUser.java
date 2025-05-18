package de.jpx3.intave.anticheat.data.impl;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.UnsupportedFallbackOperationException;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.move.MoveHandler;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.PlayerIdentifier;
import de.jpx3.intave.unknown.Unknown122;
import de.jpx3.intave.unknown.Unknown131;
import de.jpx3.intave.unknown.Unknown148;
import de.jpx3.intave.unknown.Unknown155;
import de.jpx3.intave.unknown.Unknown17;
import de.jpx3.intave.unknown.Unknown203;
import de.jpx3.intave.unknown.Unknown204;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown274;
import de.jpx3.intave.unknown.Unknown305;
import de.jpx3.intave.unknown.Unknown335;
import de.jpx3.intave.unknown.Unknown343;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Relocate
public final class FallbackUser implements PlayerData {
   private final Unknown17 b;
   private final Unknown203 h = Unknown203.b();
   private final Unknown343 d;
   private static final String l;
   private final IntaveWorld a;
   private final MoveHandler moveHandler;
   private final Unknown155 f;
   private final PlayerStorage i;
   private final PlayerIdentifier c;
   private final Map j;
   private final Unknown122 g = new Unknown122(this);

   @Override
   public Unknown155 f() {
      return this.f;
   }

   @Override
   public void p() {
   }

   @Override
   public boolean c(Unknown131 var1) {
      return false;
   }

   @Override
   public Predicate b(Unknown131 var1) {
      return FallbackUser::b;
   }

   @Override
   public void a(Unknown203 var1) {
   }

   @Override
   public long getBirthTimestamp() {
      return System.currentTimeMillis();
   }

   @Override
   public int getAttributeValue(String var1) {
      return 0;
   }

   @Override
   public void c() {
   }

   @Override
   public PlayerStorage getStorage() {
      return this.i;
   }

   @Override
   public void l() {
      Unknown148 var1 = this.getStorage().getPlayerHolder().b();
      if (var1 != null) {
         var1.q();
      }

   }

   @Override
   public void a(Unknown131 var1, Predicate var2) {
   }

   public FallbackUser() {
      this.c = PlayerIdentifier.ofEmpty();
      this.d = Unknown305.a(UUID.randomUUID());
      this.i = new PlayerStorage(null, this);
      this.b = new Unknown274(16L, TimeUnit.SECONDS);
      this.a = new Unknown204();
      this.moveHandler = MoveHandlerFactory.getHandler(this);
      this.f = MoveHandlerFactory.a(this);
      this.j = Pose.SNEAKING_V_1_8;
      this.i.d();
   }

   @Override
   public boolean v() {
      return false;
   }

   public String toString() {
      return "FallbackUser{}";
   }

   @Override
   public int getJitter() {
      return 0;
   }

   @Override
   public void setTrustFactor(TrustFactor var1) {
   }

   @Override
   public void y() {
   }

   private static boolean b(Player var0) {
      return false;
   }

   @Override
   public void D() {
   }

   @Override
   public void d() {
   }

   @Override
   public Storable getStorage(Class var1) {
      try {
         return (Storable)var1.newInstance();
      } catch (IllegalAccessException | InstantiationException var3) {
         throw new IllegalStateException(var3);
      }
   }

   @Override
   public MoveHandler getMoveHandler() {
      return this.moveHandler;
   }

   @Override
   public void e(Unknown131 var1) {
   }

   @Override
   public void timeOut() {
   }

   @Override
   public boolean m() {
      return false;
   }

   @Override
   public Object s() {
      throw UnsupportedFallbackOperationException.DEFAULT;
   }

   @Override
   public Unknown203 A() {
      return Unknown203.b();
   }

   @Override
   public Unknown335 k() {
      return this.d;
   }

   @Override
   public void error(String var1) {
   }

   @Override
   public void q() {
   }

   @Override
   public PlayerIdentifier getPlayerIdentifier() {
      return this.c;
   }

   @Override
   public Unknown17 B() {
      return this.b;
   }

   @Override
   public Player getPlayer() {
      throw UnsupportedFallbackOperationException.DEFAULT;
   }

   @Override
   public int getLatency() {
      return 0;
   }

   @Override
   public void a(Unknown227 var1, String var2) {
   }

   @Override
   public Unknown335 b(Class var1) {
      return this.d.a(var1);
   }

   @Override
   public boolean exists() {
      return false;
   }

   @Override
   public void d(Unknown131 var1) {
   }

   @Override
   public void a(String var1, Object[] var2) {
   }

   @Override
   public boolean isRecentLogin() {
      return false;
   }

   @Override
   public TrustFactor getTrustFactor() {
      return TrustFactor.DARK_RED;
   }

   @Override
   public Unknown122 j() {
      return this.g;
   }

   @Override
   public Object b() {
      throw UnsupportedFallbackOperationException.DEFAULT;
   }

   @Override
   public IntaveWorld getWorld() {
      return this.a;
   }

   @Override
   public HitboxSize getHitboxSize(Pose var1) {
      return (HitboxSize)this.j.get(var1);
   }

   @Override
   public Material a(Material var1) {
      return null;
   }

   @Override
   public void x() {
   }

   @Override
   public void i() {
   }

   @Override
   public void a(Material var1, Material var2) {
   }

   @Override
   public boolean a(Unknown131 var1) {
      return false;
   }
}
