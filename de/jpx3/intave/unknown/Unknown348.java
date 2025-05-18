package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import org.bukkit.configuration.file.YamlConfiguration;

public final class Unknown348 implements Unknown298 {
   @Override
   public Unknown237 a() {
      HTTPRequest var5 = Unknown83.a("https:..service.intave.de.trustfactor." + IntavePlugin.m(), "trustfactor", TimeUnit.DAYS.toMillis(7L));
      InputStreamReader var6 = new InputStreamReader(var5.stream());
      YamlConfiguration var7 = YamlConfiguration.loadConfiguration(var6);
      if (var7.getConfigurationSection("physics") == null) {
         Logger.getLogger().severe("Unable to download TXM file");
      }

      return new Unknown106(var7);
   }
}
