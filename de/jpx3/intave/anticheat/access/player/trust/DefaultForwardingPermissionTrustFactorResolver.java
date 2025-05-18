package de.jpx3.intave.anticheat.access.player.trust;

import de.jpx3.intave.anticheat.util.PermissionUtil;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import org.bukkit.entity.Player;

public final class DefaultForwardingPermissionTrustFactorResolver implements TrustFactorResolver {
   private final TrustFactorResolver trustFactorResolver;

   public DefaultForwardingPermissionTrustFactorResolver(TrustFactorResolver var1) {
      this.trustFactorResolver = var1;
   }

   @Override
   public void resolve(Player var1, Consumer var2) {
      Optional var7 = Arrays.stream(TrustFactor.values()).filter(this::lambda$resolve$0).findFirst();
      if (var7.isPresent()) {
         var2.accept(var7.get());
      } else {
         this.trustFactorResolver.resolve(var1, var2);
      }

   }

   private boolean hasPermissionFor(Player var1, TrustFactor var2) {
      return PermissionUtil.b(var1, var2.permission());
   }

   private boolean lambda$resolve$0(Player player, TrustFactor var2) {
      return this.hasPermissionFor(player, var2);
   }
}
