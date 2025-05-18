package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.jpx3.intave.oX;
import de.jpx3.intave.access.check.CheckAccess;
import de.jpx3.intave.access.check.UnknownCheckException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.util.FilteredMap;
import java.util.HashMap;
import java.util.Map;

public final class Unknown403 {
   private final Unknown280 a;
   private static final Map d = new HashMap();
   private static final String g;
   private final Map e = FilteredMap.b(Maps.newConcurrentMap());
   private final IntavePlugin c;

   static Map c() {
      return d;
   }

   private CheckAccess a(AbstractCheck var1) {
      return new oX(this, var1);
   }

   private AbstractCheck b(String var1) {
      try {
         return this.c.g().findCheck(var1);
      } catch (Exception var5) {
         throw new UnknownCheckException("Could not find check " + var1);
      }
   }

   public Unknown403(IntavePlugin var1) {
      this.c = var1;
      this.a = new Unknown280(var1);
   }

   public synchronized CheckAccess a(String var1) {
      Preconditions.checkNotNull(var1);
      return (CheckAccess)this.e.computeIfAbsent(var1, this::c);
   }

   private CheckAccess c(String var1) {
      return this.a(this.b(var1));
   }
}
