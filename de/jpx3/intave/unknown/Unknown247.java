package de.jpx3.intave.unknown;

import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.FieldAccessException;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;

final class Unknown247 implements EquivalentConverter {
   public Object getGeneric(Object var1) {
      return this.a((BlockPosition)var1);
   }

   public Object getSpecific(Object var1) {
      return this.a(var1);
   }

   public Class getSpecificType() {
      return BlockPosition.class;
   }

   public BlockPosition a(Object var1) {
      if (MinecraftReflection.isBlockPosition(var1)) {
         if (Unknown283.a() == null) {
            Unknown283.a(new StructureModifier(var1.getClass(), null, false).withType(Integer.TYPE));
            if (Unknown283.a().size() < 3) {
               throw new IllegalStateException("Cannot read class " + var1.getClass() + " for its integer fields.");
            }
         }

         if (Unknown283.a().size() >= 3) {
            try {
               StructureModifier var5 = Unknown283.a().withTarget(var1);
               return new BlockPosition(var5.read(0), var5.read(1), var5.read(2));
            } catch (FieldAccessException var6) {
               throw new RuntimeException("Field access error.", var6);
            }
         }
      }

      return null;
   }

   public Object a(BlockPosition var1) {
      if (Unknown283.b() == null) {
         try {
            Unknown283.a(MinecraftReflection.getBlockPositionClass().getConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE));
         } catch (Exception var7) {
            throw new RuntimeException("Cannot find block position constructor.", var7);
         }
      }

      try {
         return Unknown283.b().newInstance(var1.getX(), var1.getY(), var1.getZ());
      } catch (Exception var6) {
         throw new RuntimeException("Cannot construct ", var6);
      }
   }
}
