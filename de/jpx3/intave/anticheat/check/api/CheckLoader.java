package de.jpx3.intave.anticheat.check.api;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.autoclicker.AutoClickerCheckGroup;
import de.jpx3.intave.anticheat.check.breakspeed.BreakSpeedCheckGroup;
import de.jpx3.intave.anticheat.check.clickspeed.ClickSpeedCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.check.inventory.InventoryAnalysisCheckGroup;
import de.jpx3.intave.anticheat.check.physics.PhysicsCheck;
import de.jpx3.intave.anticheat.check.place.PlaceCheckGroup;
import de.jpx3.intave.anticheat.check.protocol.ProtocolCheckGroup;
import de.jpx3.intave.anticheat.check.reach.attack.AttackRaytraceCheck;
import de.jpx3.intave.anticheat.check.reach.interact.InteractRaytraceCheck;
import de.jpx3.intave.anticheat.check.timer.TimerCheckGroup;
import de.jpx3.intave.unknown.Unknown248;
import de.jpx3.intave.unknown.Unknown86;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Relocate
public final class CheckLoader {
   private Map checkByName;
   private List e;
   private List checks = new ArrayList();
   private final Unknown248 c;
   private Map checkByClass;
   private final IntavePlugin plugin;

   private void loadCheck(Class clazz) {
      try {
         AbstractCheck var4;
         try {
            clazz.getConstructor(IntavePlugin.class);
            var4 = (AbstractCheck)clazz.getConstructor(IntavePlugin.class).newInstance(this.plugin);
         } catch (NoSuchMethodException var6) {
            var4 = (AbstractCheck)clazz.newInstance();
         }

         this.add(var4);
      } catch (Exception var7) {
         throw new IntaveInternalException("Unable to load check " + clazz.getSimpleName(), var7);
      }
   }

   public boolean exists(String name) {
      return this.checkByName.containsKey(name.toLowerCase());
   }

   private void add(AbstractCheck check) {
      this.checks.add(check);
   }

   public void init() {
      this.loadCheck(PhysicsCheck.class);
      this.loadCheck(InteractRaytraceCheck.class);
      this.loadCheck(HeuristicCheckGroup.class);
      this.loadCheck(AttackRaytraceCheck.class);
      this.loadCheck(AutoClickerCheckGroup.class);
      this.loadCheck(ClickSpeedCheck.class);
      this.loadCheck(TimerCheckGroup.class);
      this.loadCheck(BreakSpeedCheckGroup.class);
      this.loadCheck(ProtocolCheckGroup.class);
      this.loadCheck(PlaceCheckGroup.class);
      this.loadCheck(InventoryAnalysisCheckGroup.class);
      this.a();
      this.c.e(this.checks);
      this.c.a(this.checks);
      this.c.f(this.checks);
      Unknown86.a(this::b);
   }

   private void a() {
      this.checkByClass = new HashMap();
      this.checkByName = new HashMap();
      this.e = new ArrayList();

      for(AbstractCheck var2 : this.checks) {
         this.e.add(var2.k());
         this.checkByClass.put(var2.getClass(), var2);
         this.checkByName.put(var2.k().toLowerCase(Locale.ROOT), var2);
      }

      this.checkByClass = ImmutableMap.copyOf(this.checkByClass);
      this.checkByName = ImmutableMap.copyOf(this.checkByName);
      this.e = ImmutableList.copyOf(this.e);
      this.checks = ImmutableList.copyOf(this.checks);
   }

   public CheckLoader(IntavePlugin plugin) {
      this.e = new ArrayList();
      this.checkByClass = new HashMap();
      this.checkByName = new HashMap();
      this.c = new Unknown248();
      this.plugin = plugin;
   }

   public void b() {
      this.c.d(this.checks);
      this.c.c(this.checks);
      this.c.b(this.checks);
      this.reset();
      this.checks = new CopyOnWriteArrayList();
      this.checkByClass = new HashMap();
      this.checkByName = new HashMap();
   }

   private void reset() {
      this.checkByClass = new HashMap();
      this.checkByName = new HashMap();
      this.e = new ArrayList();
   }

   public Collection getChecks() {
      return this.checks;
   }

   public AbstractCheck findCheck(String name) {
      AbstractCheck var4 = (AbstractCheck)this.checkByName.get(name.toLowerCase());
      if (var4 == null) {
         for(AbstractCheck var6 : this.checks) {
            if (var6.k().equalsIgnoreCase(name)) {
               return var6;
            }
         }

         throw new IllegalStateException("Unable to find check " + name);
      } else {
         return var4;
      }
   }

   public AbstractCheck findCheck(Class clazz) {
      AbstractCheck var4 = (AbstractCheck)this.checkByClass.get(clazz);
      if (var4 == null) {
         for(AbstractCheck var6 : this.checks) {
            if (var6.getClass() == clazz) {
               var4 = var6;
            }
         }

         if (var4 == null) {
            throw new IllegalStateException("Unable to find check " + clazz);
         }
      }

      return var4;
   }
}
