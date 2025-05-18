package de.jpx3.intave.anticheat.data;

import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.engine.move.MoveHandler;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.PlayerIdentifier;
import de.jpx3.intave.unknown.Unknown122;
import de.jpx3.intave.unknown.Unknown131;
import de.jpx3.intave.unknown.Unknown155;
import de.jpx3.intave.unknown.Unknown17;
import de.jpx3.intave.unknown.Unknown203;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown335;
import java.util.function.Predicate;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface PlayerData {
   boolean c(Unknown131 var1);

   void c();

   void x();

   Unknown155 f();

   Predicate b(Unknown131 var1);

   int getAttributeValue(String var1);

   Unknown203 A();

   void a(Material var1, Material var2);

   void a(String var1, Object[] var2);

   void error(String var1);

   int getLatency();

   boolean a(Unknown131 var1);

   void q();

   Unknown335 k();

   void l();

   void a(Unknown227 var1, String var2);

   void a(Unknown131 var1, Predicate var2);

   Player getPlayer();

   boolean m();

   void a(Unknown203 var1);

   void setTrustFactor(TrustFactor var1);

   Material a(Material var1);

   Unknown122 j();

   long getBirthTimestamp();

   void d();

   boolean v();

   void y();

   void p();

   Unknown335 b(Class var1);

   void timeOut();

   boolean isRecentLogin();

   HitboxSize getHitboxSize(Pose var1);

   boolean exists();

   void e(Unknown131 var1);

   TrustFactor getTrustFactor();

   void D();

   Unknown17 B();

   Storable getStorage(Class var1);

   PlayerIdentifier getPlayerIdentifier();

   MoveHandler getMoveHandler();

   PlayerStorage getStorage();

   IntaveWorld getWorld();

   Object b();

   void d(Unknown131 var1);

   void i();

   Object s();

   int getJitter();
}
