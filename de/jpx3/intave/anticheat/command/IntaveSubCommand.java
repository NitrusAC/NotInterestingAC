package de.jpx3.intave.anticheat.command;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.unknown.Unknown199;
import de.jpx3.intave.unknown.Unknown59;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class IntaveSubCommand {
   private boolean j;
   private boolean h;
   private String[] selectors;
   private boolean m;
   private Class[] c;
   private final AbstractCommandRegistrar k;
   private static final String g = ChatColor.RED
      + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.";
   private String f;
   private Class a;
   private String l;
   private final Method d;
   private String e;
   private Class[] i;

   public IntaveSubCommand(AbstractCommandRegistrar var1, Method var2) {
      this.k = var1;
      this.d = var2;
      this.a();
   }

   public List b(CommandSender var1, String var2) {
      String[] var6 = var2.split(" ");
      if (!"none".equals(this.l) && !PermissionUtil.b(var1, this.l)) {
         return null;
      } else {
         if (var6.length == 1 && var6[0].isEmpty()) {
            var6 = new String[0];
         }

         if (var6.length < this.c.length) {
            Class var7 = this.c[var6.length];
            return Unknown59.b(var1, var7, var6.length > 0 ? var6[var6.length - 1] : "", var2);
         } else {
            return null;
         }
      }
   }

   public boolean c() {
      return this.h;
   }

   public void a() {
      Command var5 = (Command)this.d.getDeclaredAnnotation(Command.class);
      this.selectors = var5.aliases();
      this.e = var5.e();
      this.f = var5.a();
      this.l = var5.d();
      this.h = var5.b();
      Unknown199 var6 = (Unknown199)this.d.getDeclaredAnnotation(Unknown199.class);
      if (var6 != null) {
         this.a = var6.a();
      }

      Annotation[][] var7 = this.d.getParameterAnnotations();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();
      int var10 = 0;
      boolean var11 = false;

      for(Class var15 : this.d.getParameterTypes()) {
         if (var10 == 0) {
            this.m = var15 == PlayerData.class;
            this.j = var15 == CommandSender.class;
            if (!this.m && !this.j) {
               throw new IllegalStateException();
            }

            ++var10;
         } else {
            Annotation[] var16 = var7[var10];
            boolean var17 = Arrays.stream(var16).anyMatch(IntaveSubCommand::a);
            if (!var17 && var11) {
               throw new IntaveInternalException();
            }

            var11 = var17;
            if (!var17) {
               var8.add(var15);
            }

            var9.add(var15);
            ++var10;
         }
      }

      this.i = (Class[])var8.toArray(new Class[0]);
      this.c = (Class[])var9.toArray(new Class[0]);
   }

   public String b() {
      return this.f;
   }

   public native AbstractCommandRegistrar a(CommandSender var1, String var2);

   private static boolean a(Annotation var0) {
      return var0.annotationType() == Arg.class;
   }

   public String f() {
      return this.l;
   }

   public String toString() {
      return "IntaveSubCommand{selectors=" + Arrays.toString(this.selectors) + '}';
   }

   public Class d() {
      return this.a;
   }

   public String[] e() {
      return this.selectors;
   }

   private static String b(String var0) {
      return var0 + " ";
   }
}
