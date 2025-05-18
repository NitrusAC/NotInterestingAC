package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.jpx3.intave.df;
import de.jpx3.intave.access.check.CheckStatisticsAccess;
import de.jpx3.intave.access.check.UnknownCheckException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import java.util.Map;

public final class Unknown280 {
   private static final Map a = Maps.newConcurrentMap();
   private final IntavePlugin b;
   private static final String d;

   public Unknown280(IntavePlugin var1) {
      this.b = var1;
   }

   private CheckStatisticsAccess a(AbstractCheck var1) {
      return new df(this, var1);
   }

   private AbstractCheck a(String var1) {
      try {
         return this.b.g().findCheck(var1);
      } catch (NullPointerException var5) {
         throw new UnknownCheckException("Could not find check " + var1);
      }
   }

   public synchronized CheckStatisticsAccess b(String var1) {
      Preconditions.checkNotNull(var1);
      return (CheckStatisticsAccess)a.computeIfAbsent(var1, this::b);
   }

   private CheckStatisticsAccess b(String var1, String var2) {
      return this.a(this.a(var1));
   }
}
