package de.jpx3.intave.anticheat.command;

import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.unknown.Unknown2;
import de.jpx3.intave.unknown.Unknown262;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public abstract class AbstractCommandRegistrar {
   private static final Map a = new HashMap();
   private static final int d = 8;
   private final List g = new ArrayList();
   private String i;
   private final AbstractCommandRegistrar f;
   private static final String b = ChatColor.RED
      + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.";
   private final String e;
   private static final String[] h = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};

   public native void a(CommandSender var1, String var2);

   public AbstractCommandRegistrar a() {
      return this.f;
   }

   private static String b(IntaveSubCommand var0) {
      return var0.e()[0];
   }

   private static String b(String var0) {
      return var0 + " ";
   }

   private static boolean a(String var0, IntaveSubCommand var1) {
      return Arrays.asList(var1.e()).contains(var0);
   }

   private native Unknown2 c(CommandSender var1, String var2);

   protected native void a(CommandSender var1);

   public void a(Method var1) {
      if (var1.getDeclaredAnnotation(Command.class) != null) {
         this.g.add(new IntaveSubCommand(this, var1));
      }

   }

   public void f() {
      this.g.sort(Comparator.comparing(AbstractCommandRegistrar::b));
   }

   private static String a(List var0) {
      int var4 = var0.size();
      if (var4 == 0) {
         return "";
      } else if (var4 == 1) {
         return (String)var0.get(0);
      } else {
         String var5 = String.join(", ", var0.subList(0, var4 - 1));
         String var6 = (String)var0.get(var4 - 1);
         return var5 + " or " + var6;
      }
   }

   protected AbstractCommandRegistrar(AbstractCommandRegistrar var1, String var2) {
      Unknown262.a(this::d);
      this.i = null;
      this.f = var1;
      this.e = var2;
      this.g();
      a.put(this.getClass(), this);
   }

   private static boolean a(CommandSender var0, IntaveSubCommand var1) {
      return PermissionUtil.b(var0, var1.f());
   }

   private static boolean c(IntaveSubCommand var0) {
      return !var0.c();
   }

   private IntaveSubCommand c(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      return (IntaveSubCommand)this.g.stream().filter(AbstractCommandRegistrar::a).findFirst().orElse(null);
   }

   public native List b(CommandSender var1, String var2);

   private native List b(CommandSender var1);

   protected native void a(CommandSender var1, List var2);

   public String e() {
      return this.e;
   }

   private IntaveSubCommand d(CommandSender var1, String var2) {
      return this.e(var1, var2);
   }

   private void g() {
      Arrays.stream(this.getClass().getMethods()).forEach(this::a);
      this.f();
   }

   private void d() {
      this.a(null, null);
   }

   protected String c() {
      if (this.i == null) {
         ArrayList var4 = new ArrayList();
         AbstractCommandRegistrar var5 = this;

         do {
            var4.add(var5.e());
         } while((var5 = var5.a()) != null);

         Collections.reverse(var4);
         this.i = (String)var4.stream().map(AbstractCommandRegistrar::b).collect(Collectors.joining());
      }

      return this.i;
   }

   private native IntaveSubCommand e(CommandSender var1, String var2);

   private String a(int var1) {
      return var1 <= 12 && var1 >= 0 ? h[var1] : String.valueOf(var1);
   }

   private static String a(IntaveSubCommand var0) {
      return var0.e()[0];
   }
}
