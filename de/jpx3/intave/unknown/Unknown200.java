package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.util.List;

public final class Unknown200 extends AbstractPacketReader implements Unknown398 {
   private static final String d;

   @Override
   public List a() {
      BlockPosition var3 = (BlockPosition)this.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
      return Lists.newArrayList(new BlockPosition[]{var3});
   }

   @Override
   public List b() {
      return Lists.newArrayList(new WrappedBlockData[]{(WrappedBlockData)this.getPacket().getBlockData().read(0)});
   }
}
