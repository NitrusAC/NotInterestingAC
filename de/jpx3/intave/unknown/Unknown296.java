package de.jpx3.intave.unknown;

import com.google.common.collect.Sets;
import de.jpx3.intave.J;
import de.jpx3.intave.pm;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.event.EventVisitor;
import de.jpx3.intave.anticheat.module.impl.AutoclickerCheckGroup;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class Unknown296 extends UnknownCheck {
   private final List a;
   private final AutoclickerCheckGroup f;
   private final Unknown77 g = Unknown77.a(this::a);
   private final Unknown77 h = Unknown77.a(new AtomicBoolean(false));

   public void c(PlayerData var1) {
      File var6 = new File(this.plugin.r(), "samples");
      var6.mkdirs();
      File var7 = new File(var6, var1.getPlayer().getUniqueId() + ".sample");

      try {
         var7.createNewFile();
         OutputStream var8 = Files.newOutputStream(var7.toPath());
         DeflaterOutputStream var13 = new DeflaterOutputStream(var8, new Deflater(9));
         BufferedOutputStream var14 = new BufferedOutputStream(var13, 1048576);
         OutputStream var9 = Files.newOutputStream(Paths.get(var7.getAbsolutePath() + ".uncompressed"));
         BufferedOutputStream var16 = new BufferedOutputStream(var9, 1048576);
         Unknown191 var15 = new Unknown191(new OutputStream[]{var14, var16});
         DataOutputStream var10 = new DataOutputStream(var15);
         pm var11 = new pm(new J(var1), var10);
         ((Set)this.g.a(var1)).add(var11);
         ((AtomicBoolean)this.h.a(var1)).set(true);
      } catch (IOException var12) {
         throw new RuntimeException(var12);
      }
   }

   public boolean d(PlayerData var1) {
      return ((AtomicBoolean)this.h.a(var1)).get();
   }

   private static boolean a(EventVisitor var0) {
      return var0 instanceof pm;
   }

   public void e(PlayerData var1) {
      File var5 = new File(this.plugin.r(), "samples");
      var5.mkdirs();
      File var6 = new File(var5, var1.getPlayer().getUniqueId() + ".sample");

      try {
         if (var6.exists()) {
            InputStream var7 = Files.newInputStream(var6.toPath());
            InflaterInputStream var11 = new InflaterInputStream(var7);
            BufferedInputStream var12 = new BufferedInputStream(var11, 1048576);
            DataInputStream var8 = new DataInputStream(var12);
            Unknown396 var9 = new Unknown396(var8, Runnable::run, this.a::remove);
            this.a.add(var9);
            var9.b();
         }
      } catch (IOException var10) {
         throw new RuntimeException(var10);
      }
   }

   @Override
   public void refreshConfig() {
      MoudleLoader.j().a().b(this.f);
   }

   public Unknown296() {
      this.f = new AutoclickerCheckGroup(this.c());
      this.a = new ArrayList();
   }

   @Override
   public void e() {
      MoudleLoader.j().a().a(this.f);
   }

   public void b(PlayerData var1) {
      List var2 = (List)((Set)this.g.a(var1)).stream().filter(Unknown296::a).peek(EventVisitor::visit).collect(Collectors.toList());
      var2.forEach(((Set)this.g.a(var1))::remove);
      ((AtomicBoolean)this.h.a(var1)).set(false);
   }

   public Set a(PlayerData var1) {
      if (!var1.exists()) {
         return Collections.emptySet();
      } else {
         Unknown163 var2 = new Unknown163(var1);
         return Sets.newHashSet(new EventVisitor[]{new Unknown401(var2)});
      }
   }

   public BiConsumer c() {
      return this::b;
   }

   private void b(PlayerData var1, Consumer var2) {
      ((Set)this.g.a(var1)).forEach(var2);
   }
}
