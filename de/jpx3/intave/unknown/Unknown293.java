package de.jpx3.intave.unknown;

import com.google.common.collect.Maps;
import de.jpx3.intave.access.IntaveEvent;
import de.jpx3.intave.access.check.event.IntaveCommandExecutionEvent;
import de.jpx3.intave.access.check.event.IntaveViolationEvent;
import de.jpx3.intave.access.player.event.AsyncIntaveBlockBreakPermissionEvent;
import de.jpx3.intave.access.player.event.AsyncIntaveBlockPlacePermissionEvent;
import de.jpx3.intave.access.player.event.AsyncIntaveBukkitActionPermissionEvent;
import de.jpx3.intave.access.player.event.AsyncIntaveInteractionPermissionEvent;
import de.jpx3.intave.access.player.event.IntaveCreateEmulatedEntityEvent;
import de.jpx3.intave.access.player.event.IntaveCreateEmulatedPlayerEvent;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class Unknown293 extends UnknownCheck {
   private static final String g;
   private final Map e = Maps.newHashMap();

   private void a(Class var1, Supplier var2) {
      this.e.put(var1, ThreadLocal.withInitial(var2));
   }

   public IntaveEvent a(Class var1, Consumer var2) {
      IntaveEvent var6 = this.a(var1);
      var2.accept(var6);
      this.a(var6);
      var6.referenceInvalidate();
      return var6;
   }

   @Override
   public void refreshConfig() {
      this.a(IntaveViolationEvent.class, IntaveViolationEvent::empty);
      this.a(IntaveCommandExecutionEvent.class, IntaveCommandExecutionEvent::empty);
      this.a(IntaveCreateEmulatedEntityEvent.class, IntaveCreateEmulatedEntityEvent::empty);
      this.a(IntaveCreateEmulatedPlayerEvent.class, IntaveCreateEmulatedPlayerEvent::empty);
      this.a(AsyncIntaveBlockBreakPermissionEvent.class, AsyncIntaveBlockBreakPermissionEvent::empty);
      this.a(AsyncIntaveBlockPlacePermissionEvent.class, AsyncIntaveBlockPlacePermissionEvent::empty);
      this.a(AsyncIntaveInteractionPermissionEvent.class, AsyncIntaveInteractionPermissionEvent::empty);
      this.a(AsyncIntaveBukkitActionPermissionEvent.class, AsyncIntaveBukkitActionPermissionEvent::empty);
   }

   private IntaveEvent a(Class var1) {
      ThreadLocal var5 = (ThreadLocal)this.e.get(var1);
      if (var5 == null) {
         throw new IllegalStateException("Unable to locate thread local handle for event class " + var1.getName());
      } else {
         return (IntaveEvent)var5.get();
      }
   }

   private void a(IntaveEvent var1) {
      this.plugin.d().a(var1);
   }
}
