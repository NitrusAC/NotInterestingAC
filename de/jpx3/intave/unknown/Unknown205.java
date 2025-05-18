package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public class Unknown205 implements Unknown335, Iterable {
   private final Collection a;

   public boolean b() {
      return this.d() == 0;
   }

   public void a(Unknown194 var1) {
      this.a.add(var1);
   }

   private static boolean b(TimeUnit var0, long var1, Unknown194 var3) {
      return var3.b() < var0.toMillis(var1);
   }

   public double c(Predicate var1) {
      return (double)this.a(var1) / (double)this.d();
   }

   public long a(Predicate var1) {
      return this.a().filter(var1).count();
   }

   public Unknown194 f() {
      Iterator var4 = this.a.iterator();
      return var4.hasNext() ? (Unknown194)var4.next() : null;
   }

   public Unknown194 c() {
      return (Unknown194)this.a().max(Comparator.comparing(Unknown194::c)).orElse(null);
   }

   public Unknown205() {
      this(new ArrayList());
   }

   public void forEach(Consumer var1) {
      this.a.forEach(var1);
   }

   public int d() {
      return this.a.size();
   }

   public Unknown205(Collection var1) {
      this.a = new ArrayList(var1);
   }

   public Stream a() {
      return this.a.stream();
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      int var5 = var1.readInt();

      for(int var6 = 0; var6 < var5; ++var6) {
         Unknown194 var7 = new Unknown194();
         var7.a(var1);
         this.a(var7);
      }

   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeInt(this.d());

      for(Unknown194 var6 : this) {
         var6.a(var1);
      }

   }

   public Unknown205 a(long var1, TimeUnit var3) {
      return this.b(Unknown205::b);
   }

   public Unknown205 e() {
      return new Unknown205((Collection)this.a().sorted(Comparator.comparing(Unknown194::b)).collect(Collectors.toList()));
   }

   public Unknown205 b(Predicate var1) {
      List var2 = (List)this.a().filter(var1).collect(Collectors.toList());
      return new Unknown205(var2);
   }

   public Spliterator spliterator() {
      return this.a.spliterator();
   }
}
