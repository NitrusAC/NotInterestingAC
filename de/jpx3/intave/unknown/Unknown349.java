package de.jpx3.intave.unknown;

import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.mojang.authlib.GameProfile;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Unknown349 {
   private static final Unknown46 b = Unknown282.a("{obc}.CraftServer", Unknown349.d, 0);
   protected Plugin c;
   private static final Class d = Unknown282.e("{nms}.MinecraftServer");
   private static final AtomicInteger o = new AtomicInteger(0);
   private ChannelInitializer u;
   private ChannelInitializer i;
   private final String h;
   private final Set w;
   private static final Unknown269 j = Unknown282.a("{obc}.entity.CraftPlayer", "getHandle", new Class[0]);
   private static final Unknown46 g = Unknown282.a(Unknown349.q, GameProfile.class, 0);
   private List p;
   private static final Unknown46 k = Unknown282.a("{nms}.NetworkManager", Channel.class, 0);
   private final List r;
   private static final Unknown46 m = Unknown282.a(d, Unknown349.e, 0);
   private ChannelInboundHandlerAdapter t;
   private final Map n = new MapMaker().weakValues().makeMap();
   private static final Class q = Unknown282.d("PacketLoginInStart");
   private static final Unknown46 s = Unknown282.a("{nms}.PlayerConnection", Unknown282.d("NetworkManager"), 0);
   protected boolean v;
   private static final Unknown46 f = Unknown282.a("{nms}.EntityPlayer", Unknown282.d("PlayerConnection"), 0);
   private static final Class e = Unknown282.e("{nms}.ServerConnection");
   private static final Unknown46 l = Unknown282.a(e, List.class, 1);
   private Listener a;

   private void a(ChannelPipeline var1) {
      try {
         var1.remove(this.t);
      } catch (NoSuchElementException var3) {
      }

   }

   public void a(Player var1, Object var2) {
      this.a(this.a(var1), var2);
   }

   public Unknown349(IntavePlugin var1) {
      this.w = Collections.newSetFromMap(new MapMaker().weakKeys().makeMap());
      this.r = Lists.newArrayList();
      this.c = var1;
      this.h = this.d();
      this.f();

      try {
         this.c();
         this.a((Plugin)var1);
      } catch (IllegalArgumentException var3) {
         IntaveScheduler.runTask(this::a);
      }

   }

   private void b(Channel var1) {
      var1.pipeline().remove(this.h);
   }

   private Unknown168 f(Channel var1) {
      try {
         Unknown168 var5 = (Unknown168)var1.pipeline().get(this.h);
         if (var5 == null) {
            var5 = new Unknown168(this, null);

            try {
               var1.pipeline().addBefore("packet_handler", this.h, var5);
            } catch (Exception var7) {
               System.out.println("[Intave] Failed to find packet_handler pipeline element for " + var1);
               System.out.println("[Intave] Netty broken?!");
            }

            this.w.remove(var1);
         }

         return var5;
      } catch (IllegalArgumentException var8) {
         return (Unknown168)var1.pipeline().get(this.h);
      }
   }

   public void b(Channel var1, Object var2) {
      var1.pipeline().writeAndFlush(var2);
   }

   public Object b(Player var1, Channel var2, Object var3) {
      return var3;
   }

   protected String d() {
      return "tiny-" + this.c.getName() + "-" + o.incrementAndGet();
   }

   private void c() {
      Object var4 = b.b(Bukkit.getServer());
      Object var5 = m.b(var4);
      boolean var6 = true;
      this.p = (List)l.b(var5);
      this.b();

      for(int var7 = 0; var6; ++var7) {
         for(Object var10 : (List)Unknown282.a(var5.getClass(), List.class, var7).b(var5)) {
            if (!(var10 instanceof ChannelFuture)) {
               break;
            }

            Channel var11 = ((ChannelFuture)var10).channel();
            this.r.add(var11);

            try {
               var11.pipeline().addFirst(new ChannelHandler[]{this.t});
            } catch (Exception var13) {
               System.out.println(var11.pipeline().names());
               var13.printStackTrace();
            }

            var6 = false;
         }
      }

   }

   static Unknown168 a(Unknown349 var0, Channel var1) {
      return var0.f(var1);
   }

   public final void a() {
      if (!this.v) {
         this.v = true;

         for(Player var5 : this.c.getServer().getOnlinePlayers()) {
            this.d(var5);
         }

         HandlerList.unregisterAll(this.a);
         this.h();
      }

   }

   private void b() {
      this.i = new Unknown181(this);
      this.u = new Unknown111(this);
      this.t = new Unknown36(this);
   }

   private void f() {
      this.a = new Unknown196(this);
      this.c.getServer().getPluginManager().registerEvents(this.a, this.c);
   }

   static Class e() {
      return q;
   }

   public void b(Player var1, Object var2) {
      this.b(this.a(var1), var2);
   }

   public Object a(Player var1, Channel var2, Object var3) {
      return var3;
   }

   private void a(IntavePlugin var1) {
      this.c();
      this.a((Plugin)var1);
   }

   public Channel a(Player var1) {
      Channel var5 = (Channel)this.n.get(var1.getName());
      if (var5 == null) {
         Object var6 = f.b(j.a(var1, new Object[0]));
         Object var7 = s.b(var6);
         this.n.put(var1.getName(), var5 = (Channel)k.b(var7));
      }

      return var5;
   }

   public boolean b(Player var1) {
      return this.e(this.a(var1));
   }

   public boolean e(Channel var1) {
      return var1.pipeline().get(this.h) != null;
   }

   static ChannelInitializer b(Unknown349 var0) {
      return var0.u;
   }

   public void a(Channel var1, Object var2) {
      var1.pipeline().context("encoder").fireChannelRead(var2);
   }

   static List a(Unknown349 var0) {
      return var0.p;
   }

   public void d(Channel var1) {
      this.f(var1);
   }

   static ChannelInitializer d(Unknown349 var0) {
      return var0.i;
   }

   static Map e(Unknown349 var0) {
      return var0.n;
   }

   public void c(Channel var1) {
      if (!this.v) {
         this.w.add(var1);
      }

      var1.eventLoop().execute(this::b);
   }

   public void d(Player var1) {
      this.c(this.a(var1));
   }

   static Set c(Unknown349 var0) {
      return var0.w;
   }

   static Unknown46 g() {
      return g;
   }

   private void a(Plugin var1) {
      for(Player var6 : var1.getServer().getOnlinePlayers()) {
         this.c(var6);
      }

   }

   public void c(Player var1) {
      this.f(this.a(var1)).a = var1;
   }

   private void h() {
      if (this.t != null) {
         for(Channel var5 : this.r) {
            ChannelPipeline var6 = var5.pipeline();
            var5.eventLoop().execute(this::a);
         }

      }
   }
}
