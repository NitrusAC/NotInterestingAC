package de.jpx3.intave.anticheat.check.api;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.access.check.MitigationStrategy;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.unknown.Unknown115;
import de.jpx3.intave.unknown.Unknown63;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public abstract class AbstractCheck implements Check {
   private final Unknown63 e = new Unknown63();
   private final String i;
   private final IntavePlugin intavePlugin;
   private final Map c = new EnumMap(TrustFactor.class);
   private MitigationStrategy legacyStrategy;
   private final List children = new ArrayList();
   private MitigationStrategy strategy;
   private final String j;
   private final Unknown115 f = new Unknown115(this);
   private final boolean enabled;

   protected final void addChildren(PartialCheck[] childrenChecks) {
      for(PartialCheck var8 : childrenChecks) {
         this.addChild(var8);
      }

   }

   protected final void addChild(PartialCheck child) {
      if (child.getParent() != this) {
         throw new IntaveInternalException("Partial check lacks valid reference to parent check");
      } else {
         this.children.add(child);
      }
   }

   private static Unknown63 b(TrustFactor var0) {
      return new Unknown63();
   }

   private void readConfig() {
      YamlConfiguration var4 = this.intavePlugin.getConfig();
      String var5 = "check." + this.a();
      ConfigurationSection var6 = var4.getConfigurationSection(var5);
      if (var6 == null) {
         this.f.a(new HashMap());
      } else {
         HashMap var7 = new HashMap();

         for(String var10 : var6.getKeys(true)) {
            var7.putIfAbsent(var10, var6.get(var10));
         }

         this.f.a(var7);
      }
   }

   public final String a() {
      return this.i;
   }

   protected final void a(Iterable var1) {
      for(PartialCheck var6 : var1) {
         this.addChildren(new PartialCheck[]{var6});
      }

   }

   public final MitigationStrategy getStrategy() {
      return this.strategy == MitigationStrategy.NOT_SUPPORTED ? (this.strategy = this.legacyStrategy) : this.strategy;
   }

   public final String k() {
      return this.j;
   }

   protected final int flag(String var1, Player var2) {
      String var5 = this.i + "." + var1;
      return this.intavePlugin.c().a(var5, var2);
   }

   public final void setStrategy(MitigationStrategy strategy) {
      this.strategy = strategy;
   }

   @Deprecated
   public final void setLegacyStrategy(MitigationStrategy strategy) {
      this.legacyStrategy = strategy;
   }

   public boolean e() {
      return this.enabled;
   }

   public List getChildren() {
      return this.children;
   }

   @Deprecated
   public final Unknown63 h() {
      return this.e;
   }

   public final void a(PlayerData var1, Consumer var2) {
      var2.accept(this.h());
      var2.accept(this.c(var1.getTrustFactor()));
   }

   protected AbstractCheck(String var1, String var2) {
      this.legacyStrategy = MitigationStrategy.NOT_SUPPORTED;
      this.intavePlugin = IntavePlugin.getInstance();
      this.j = var1;
      this.i = var2;
      this.readConfig();
      this.enabled = this.f.b().isEnabled();
      this.strategy = this.f.b().getMitigationStrategy();
   }

   private final Unknown63 c(TrustFactor var1) {
      return (Unknown63)this.c.computeIfAbsent(var1, AbstractCheck::b);
   }

   protected final PlayerData getData(Player var1) {
      return PlayerDataManager.getPlayerData(var1);
   }

   public final Unknown115 b() {
      return this.f;
   }

   public boolean isEnabled() {
      return this.enabled;
   }
}
