package de.jpx3.intave.anticheat.data.impl;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.google.common.collect.Maps;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.move.MoveHandler;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.anticheat.util.PlayerIdentifier;
import de.jpx3.intave.unknown.Unknown122;
import de.jpx3.intave.unknown.Unknown131;
import de.jpx3.intave.unknown.Unknown134;
import de.jpx3.intave.unknown.Unknown148;
import de.jpx3.intave.unknown.Unknown155;
import de.jpx3.intave.unknown.Unknown17;
import de.jpx3.intave.unknown.Unknown203;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown228;
import de.jpx3.intave.unknown.Unknown240;
import de.jpx3.intave.unknown.Unknown274;
import de.jpx3.intave.unknown.Unknown305;
import de.jpx3.intave.unknown.Unknown309;
import de.jpx3.intave.unknown.Unknown335;
import de.jpx3.intave.unknown.Unknown343;
import de.jpx3.intave.unknown.Unknown355;
import de.jpx3.intave.unknown.Unknown390;
import de.jpx3.intave.unknown.unknown79;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@Relocate
public final class PlayerUser implements PlayerData {
   private MoveHandler moveHandler;
   private boolean i;
   private final List h;
   private final Unknown122 j;
   private final Reference g;
   private final PlayerIdentifier c;
   private final PlayerStorage p;
   private final IntaveWorld d;
   private TrustFactor n;
   private final long birthTimestamp;
   private boolean f;
   private final Reference player;
   private Unknown203 m;
   private boolean r;
   private Unknown155 l;
   private final Map a = new ConcurrentHashMap();
   private final Unknown343 q;
   private final Map b;
   private final Reference k;
   private final Map o;
   private Map v;
   private final Unknown17 s;

   @Override
   public Unknown17 B() {
      return this.s;
   }

   @Override
   public void p() {
      Player var1 = this.getPlayer();
      VersionHolder var2 = this.getStorage().getVersionHolder();
      var2.a(var1);
      this.d();
      this.sendJoinMessage();
   }

   @Override
   public PlayerIdentifier getPlayerIdentifier() {
      return this.c;
   }

   @Override
   public void D() {
      this.r = true;
   }

   private void a(Unknown309 var1, Player var2, Player var3, Object var4) {
      var1.a(var2, null, this::a, Unknown228.c);
   }

   @Override
   public Unknown335 k() {
      return this.q;
   }

   @Override
   public Storable getStorage(Class var1) {
      return (Storable)this.a.computeIfAbsent(var1, PlayerUser::b);
   }

   @Override
   public void setTrustFactor(TrustFactor var1) {
      this.n = var1;
   }

   @Override
   public Object s() {
      return this.k.get();
   }

   @Override
   public IntaveWorld getWorld() {
      return this.d;
   }

   @Override
   public PlayerStorage getStorage() {
      return this.p;
   }

   @Override
   public Unknown122 j() {
      return this.j;
   }

   @Override
   public Unknown335 b(Class var1) {
      return this.q.a(var1);
   }

   @Override
   public void d() {
      this.moveHandler = MoveHandlerFactory.getHandler(this);
      this.l = MoveHandlerFactory.a(this);
      this.v = Pose.getByVersion(this.p.getVersionHolder().getVersionId());
      IntaveMaterial.a(this);
      this.getStorage().getPhysicsHolder().computeFrictionFactor();
   }

   @Override
   public TrustFactor getTrustFactor() {
      return this.n;
   }

   @Override
   public void y() {
      this.f = false;
   }

   @Override
   public void i() {
      Player var1 = this.getPlayer();
      Unknown309 var2 = MoudleLoader.m();
      var2.a(var1, PlayerDataManager.getPlayerData(var1), this::b, Unknown228.c);
   }

   private void a(Player var1, int var2, float var3) {
      float var4 = (float)(var1.isHealthScaled() ? var1.getHealth() * var1.getHealthScale() / var1.getMaxHealth() : var1.getHealth());
      PacketContainer var5 = ProtocolLibrary.getProtocolManager().createPacket(Server.UPDATE_HEALTH);
      var5.getFloat().write(0, var4);
      var5.getFloat().write(1, var3);
      var5.getIntegers().write(0, var2);
      ProtocolManager.sendPacket(var1, var5);
   }

   @Override
   public void timeOut() {
      unknown79 var3 = this.p.c();
      if (var3.m++ > 100L) {
         Player var4 = this.getPlayer();
         Logger.getLogger().severe(var4.getName() + " has been removed for repeated feedback faults");
         this.error("Timed out");
      }

   }

   private void a(String var1) {
      if (this.getPlayer().isOnline()) {
         this.getPlayer().kickPlayer(var1);
      }

   }

   @Override
   public void d(Unknown131 var1) {
      this.b.remove(var1);
   }

   @Override
   public boolean c(Unknown131 var1) {
      return this.b.containsKey(var1);
   }

   @Override
   public void c() {
      this.f = true;
   }

   @Override
   public void a(Unknown227 var1, String var2) {
      if (!this.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
         MoudleLoader.o().a().c(this, var1, var2);
      }
   }

   @Override
   public void q() {
      this.r = false;
   }

   private void b(Player var1, Unknown309 var2, Player var3, PlayerData var4) {
      this.a(var1, 0, 0.0F);
      var2.a(var1, null, this::a, Unknown228.c);
   }

   @Override
   public Player getPlayer() {
      Player var3 = (Player)this.player.get();
      if (var3 == null) {
         throw new IntaveInternalException("Unable to reference player through service repo: Fallback user lacks reference");
      } else {
         return var3;
      }
   }

   @Override
   public synchronized void error(String var1) {
      if (!this.i) {
         this.i = true;
         Logger.getLogger().info("Queuing manual disconnect of player " + this.getPlayer().getName() + " for \"" + var1 + "\"");
         Logger.getLogger().info("This measure is a security-constraint necessity, but feel free to contact us if this happens too often");
         IntaveScheduler.runTask(this::a);
      }
   }

   private void a(Player var1, Player var2, Object var3) {
      this.a(var1, var1.getFoodLevel(), var1.getSaturation());
   }

   @Override
   public HitboxSize getHitboxSize(Pose var1) {
      return (HitboxSize)this.v.get(var1);
   }

   public String toString() {
      return "PlayerUser{player=" + this.player + ", birthTimestamp=" + this.birthTimestamp + '}';
   }

   @Override
   public void l() {
      Unknown148 var1 = this.getStorage().getPlayerHolder().b();
      if (var1 != null) {
         var1.q();
      }

      Unknown355.a(this);

      for(Unknown131 var5 : Unknown131.values()) {
         Unknown390.a(this.getPlayer(), var5, false);
      }

   }

   private static Storable b(Class var0) {
      try {
         return (Storable)var0.newInstance();
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new IllegalStateException(var3);
      }
   }

   @Override
   public boolean exists() {
      Player var1 = (Player)this.player.get();
      return this.a(var1);
   }

   @Override
   public int getAttributeValue(String var1) {
      return this.b().c().a(var1, this.getPlayer());
   }

   private IntavePlugin b() {
      return IntavePlugin.getInstance();
   }

   public PlayerUser(Player var1) {
      this.h = new ArrayList();
      this.b = Maps.newEnumMap(Unknown131.class);
      this.o = Maps.newHashMap();
      this.m = Unknown203.b();
      this.birthTimestamp = System.currentTimeMillis();
      this.j = new Unknown122(this);
      this.n = TrustFactor.DARK_RED;
      this.i = false;
      this.player = new WeakReference(var1);
      this.k = new WeakReference(Unknown134.b(var1));
      this.g = new WeakReference(Unknown134.a(var1));
      this.p = new PlayerStorage(var1, this);
      this.s = new Unknown274(16L, TimeUnit.SECONDS);
      this.d = Unknown240.a(var1);
      this.moveHandler = MoveHandlerFactory.getHandler(this);
      this.l = MoveHandlerFactory.a(this);
      IntaveScheduler.runTask(this::e);
      this.c = PlayerIdentifier.of(var1);
      this.q = Unknown305.a(var1.getUniqueId());
      this.v = Pose.getByVersion(this.p.getVersionHolder().getVersionId());
      this.p.d();
   }

   @Override
   public int getLatency() {
      return this.getStorage().c().c;
   }

   @Override
   public Material a(Material var1) {
      return (Material)this.o.get(var1);
   }

   @Override
   public void a(String var1, Object[] var2) {
   }

   private boolean a(OfflinePlayer var1) {
      return var1 != null && (var1.isOnline() || Bukkit.getPlayer(var1.getUniqueId()) != null);
   }

   @Override
   public boolean v() {
      return this.f;
   }

   @Override
   public Predicate b(Unknown131 var1) {
      return (Predicate)this.b.get(var1);
   }

   @Override
   public int getJitter() {
      return this.getStorage().c().h;
   }

   @Override
   public Unknown155 f() {
      return this.l;
   }

   private void sendJoinMessage() {
      Player var3 = this.getPlayer();
      VersionHolder var4 = this.getStorage().getVersionHolder();
      String var5 = var3.getName() + " joined with version " + var4.getVersionString() + "/" + var4.getVersionId();
      if (var4.isRewindVersion()) {
         var5 = var5 + " (behind)";
      }

      Logger.getLogger().print(var5);
   }

   @Override
   public boolean m() {
      return this.r;
   }

   @Override
   public void e(Unknown131 var1) {
      boolean var2 = this.a(var1);
      if (var2) {
         this.h.remove(var1);
      } else {
         this.h.add(var1);
      }

      Unknown390.a(this.getPlayer(), var1, !var2);
   }

   @Override
   public boolean a(Unknown131 var1) {
      boolean var2 = this.h.contains(var1);
      if (var2 && !PermissionUtil.b(this.getPlayer(), var1.a())) {
         this.e(var1);
         return false;
      } else {
         return var2;
      }
   }

   @Override
   public Unknown203 A() {
      return this.m;
   }

   @Override
   public MoveHandler getMoveHandler() {
      return this.moveHandler;
   }

   @Override
   public boolean isRecentLogin() {
      return System.currentTimeMillis() - this.birthTimestamp < 5000L;
   }

   @Override
   public void a(Unknown131 var1, Predicate var2) {
      this.b.put(var1, var2);
   }

   @Override
   public Object b() {
      return this.g.get();
   }

   @Override
   public void x() {
      this.o.clear();
      this.d.a();
   }

   @Override
   public long getBirthTimestamp() {
      return this.birthTimestamp;
   }

   public void e() {
      for(Unknown131 var4 : Unknown131.values()) {
         if (var4.f && PermissionUtil.b(this.getPlayer(), var4.a())) {
            this.e(var4);
            this.d(var4);
         }
      }

   }

   @Override
   public void a(Material var1, Material var2) {
      this.o.put(var1, var2);
   }

   @Override
   public void a(Unknown203 var1) {
      this.m = var1;
   }
}
