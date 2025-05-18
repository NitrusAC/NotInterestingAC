package de.jpx3.intave.anticheat.violation;

import de.jpx3.intave.pp;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.unknown.Unknown255;
import de.jpx3.intave.unknown.Unknown373;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public final class Violation {
   private final String f;
   private final Class check;
   private final UUID playerId;
   private final Map g;
   private static final Unknown373 c = Collections::emptyMap;
   private final int h;
   private final double a;
   private final String i;
   private final String e;

   public AbstractCheck getCheck() {
      return IntavePlugin.getInstance().g().findCheck(this.check);
   }

   public String g() {
      return this.i;
   }

   private Map j() {
      return this.g;
   }

   public UUID getPlayerId() {
      return this.playerId;
   }

   public Unknown373 e() {
      return this.g == null ? c : this::j;
   }

   public String h() {
      return this.e;
   }

   private Violation(Class check, UUID playerId, String var3, String var4, String var5, double var6, Map var8, int var9) {
      this.check = check;
      this.playerId = playerId;
      this.f = var3;
      this.e = var4;
      this.i = var5;
      this.a = var6;
      this.g = var8;
      this.h = var9;
   }

   public double b() {
      return this.a;
   }

   public String l() {
      return this.f;
   }

   public Optional getPlayer() {
      Player var1 = Bukkit.getPlayer(this.playerId);
      return this.isOnline(var1) ? Optional.of(var1) : Optional.empty();
   }

   public boolean a(int var1) {
      return Unknown255.a(this.h, var1);
   }

   public Class getCheckClazz() {
      return this.check;
   }

   Violation(Class check, UUID playerId, String var3, String var4, String var5, double var6, Map var8, int var9, pp var10) {
      this(check, playerId, var3, var4, var5, var6, var8, var9);
   }

   public static ViolationBuilder builder(Class check) {
      return new ViolationBuilder(check);
   }

   private boolean isOnline(OfflinePlayer player) {
      return player != null && (player.isOnline() || Bukkit.getPlayer(player.getUniqueId()) != null);
   }
}
