package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import de.jpx3.intave.access.IntaveAccess;
import de.jpx3.intave.access.check.Check;
import de.jpx3.intave.access.check.CheckAccess;
import de.jpx3.intave.access.player.PlayerAccess;
import de.jpx3.intave.access.player.UnknownPlayerException;
import de.jpx3.intave.access.player.storage.StorageGateway;
import de.jpx3.intave.access.server.ServerAccess;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactorResolver;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.io.PrintStream;
import org.bukkit.entity.Player;

class Unknown130 implements IntaveAccess {
   final Unknown47 this$0;

   @Override
   public native void fallback(Object var1);

   @Override
   public void unsubscribeOutputStream(PrintStream var1) {
      Logger.getLogger().addStream(var1);
   }

   @Override
   public void setStorageGateway(StorageGateway var1) {
      Logger.getLogger().info("Set storage gateway to " + var1);
      MoudleLoader.f().a(var1);
   }

   @Override
   public CheckAccess check(String var1) {
      return Unknown47.b(this.this$0).a(var1);
   }

   private void c() {
      this.setDefaultTrustFactor(null);
   }

   @Override
   public native void setTrustFactorResolver(TrustFactorResolver var1);

   private void b() {
      this.fallback(null);
   }

   @Override
   public native void setDefaultTrustFactor(TrustFactor var1);

   private void a() {
      this.setDefaultTrustFactor(null);
   }

   @Override
   public CheckAccess check(Check var1) {
      return this.check(var1.typeName());
   }

   @Override
   public PlayerAccess player(Player var1) {
      Preconditions.checkNotNull(var1);
      if (!PlayerDataManager.isInjected(var1)) {
         throw new UnknownPlayerException("Player " + var1.getName() + " couldn't be found");
      } else {
         return Unknown47.d(this.this$0).b(var1);
      }
   }

   @Override
   public void subscribeOutputStream(PrintStream var1) {
      Logger.getLogger().b(var1);
   }

   @Override
   public ServerAccess server() {
      return Unknown47.c(this.this$0).b();
   }

   Unknown130(Unknown47 var1) {
      this.this$0 = var1;
      Unknown262.a(this::a);
      Unknown262.a(this::c);
      Unknown262.a(this::b);
   }
}
