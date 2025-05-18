package de.jpx3.intave.unknown;

import com.google.common.collect.UnmodifiableIterator;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.function.BiConsumer;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.BlockStateList;
import net.minecraft.server.v1_8_R3.IBlockData;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.block.data.CraftBlockData;

@Unknown61
class Unknown50 {
   private static final boolean a = MinecraftVersion.V_1_14.atOrAbove();
   private static Method b;

   @Unknown61
   public static void c(Material var0, BiConsumer var1, BiConsumer var2) {
      int var5 = var0.getId();
      Block var6 = Block.getById(var5);
      HashMap var7 = new HashMap();
      HashMap var8 = new HashMap();

      try {
         if (b == null) {
            Class var10000 = Unknown244.b("Block");
            Class[] var10003 = new Class[0];
            b = var10000.getDeclaredMethod(qd.b("getStateList", var10000, var10003), var10003);
            b.setAccessible(true);
         }

         BlockStateList var9 = (BlockStateList)b.invoke(var6);
         UnmodifiableIterator var10 = var9.a().iterator();

         while(var10.hasNext()) {
            IBlockData var11 = (IBlockData)var10.next();
            int var12 = var6.toLegacyData(var11);
            var7.put(var11, var12);
            var8.put(var12, var11);
         }
      } catch (Exception var13) {
         var13.printStackTrace();
      }

      var1.accept(var0, var7);
      var2.accept(var0, var8);
   }

   @Unknown61
   public static void d(Material var0, BiConsumer var1, BiConsumer var2) {
      CraftBlockData var3 = CraftBlockData.newData(var0, null);
      Block var4 = var3.getState().getBlock();
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();
      int var7 = 0;

      for(UnmodifiableIterator var8 = var4.getStates().a().iterator(); var8.hasNext(); ++var7) {
         IBlockData var9 = (IBlockData)var8.next();
         var5.put(var9, var7);
         var6.put(var7, var9);
      }

      var1.accept(var0, var5);
      var2.accept(var0, var6);
   }

   private Unknown50() {
   }

   @Unknown61
   public static void a(Material var0, BiConsumer var1, BiConsumer var2) {
      CraftBlockData var3 = CraftBlockData.newData(var0, null);
      Block var4 = var3.getState().getBlock();
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();
      int var7 = 0;

      for(UnmodifiableIterator var8 = var4.getStates().a().iterator(); var8.hasNext(); ++var7) {
         IBlockData var9 = (IBlockData)var8.next();
         var5.put(var9, var7);
         var6.put(var7, var9);
      }

      var1.accept(var0, var5);
      var2.accept(var0, var6);
   }

   @Unknown61
   public static void b(Material var0, BiConsumer var1, BiConsumer var2) {
      if (Unknown129.b()) {
         if (a) {
            d(var0, var1, var2);
         } else {
            a(var0, var1, var2);
         }
      } else {
         c(var0, var1, var2);
      }

   }
}
