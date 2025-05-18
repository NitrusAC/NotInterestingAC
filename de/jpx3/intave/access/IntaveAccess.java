package de.jpx3.intave.access;

import de.jpx3.intave.access.check.Check;
import de.jpx3.intave.access.check.CheckAccess;
import de.jpx3.intave.access.player.PlayerAccess;
import de.jpx3.intave.access.player.storage.StorageGateway;
import de.jpx3.intave.access.server.ServerAccess;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactorResolver;
import java.io.PrintStream;
import org.bukkit.entity.Player;

public interface IntaveAccess {
   void setTrustFactorResolver(TrustFactorResolver var1);

   void setDefaultTrustFactor(TrustFactor var1);

   void subscribeOutputStream(PrintStream var1);

   void unsubscribeOutputStream(PrintStream var1);

   void setStorageGateway(StorageGateway var1);

   PlayerAccess player(Player var1);

   ServerAccess server();

   CheckAccess check(String var1);

   CheckAccess check(Check var1);

   void fallback(Object var1);
}
