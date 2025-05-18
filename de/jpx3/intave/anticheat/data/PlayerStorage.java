package de.jpx3.intave.anticheat.data;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.unknown79;
import org.bukkit.entity.Player;

@Relocate
public final class PlayerStorage {
   private final PotionHolder potionHolder;
   private final EntityHolder entityHolder;
   private final BukkitEnginePlayer enginePlayer;
   private final Unknown187 b = new Unknown187();
   private final DamageHolder damageHolder;
   private final ItemHolder itemHolder;
   private final PlayerHolder playerHolder;
   private final VersionHolder versionHolder;
   private final unknown79 i;

   public DamageHolder getDamageHolder() {
      return this.damageHolder;
   }

   public ItemHolder getItemHolder() {
      return this.itemHolder;
   }

   public PlayerHolder getPlayerHolder() {
      return this.playerHolder;
   }

   public unknown79 c() {
      return this.i;
   }

   public BukkitEnginePlayer getPhysicsHolder() {
      return this.enginePlayer;
   }

   public PlayerStorage(Player player, PlayerData data) {
      this.versionHolder = new VersionHolder(player, data);
      this.entityHolder = new EntityHolder(player);
      this.potionHolder = new PotionHolder(player);
      this.itemHolder = new ItemHolder(player);
      this.i = new unknown79(player);
      this.enginePlayer = new BukkitEnginePlayer(player, data);
      this.playerHolder = new PlayerHolder(player);
      this.damageHolder = new DamageHolder(player);
   }

   public PotionHolder getPotionHolder() {
      return this.potionHolder;
   }

   public VersionHolder getVersionHolder() {
      return this.versionHolder;
   }

   public Unknown187 e() {
      return this.b;
   }

   public void d() {
      this.enginePlayer.V();
   }

   public EntityHolder getEntityHolder() {
      return this.entityHolder;
   }
}
