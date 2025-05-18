package de.jpx3.intave.anticheat.util.nms;

public enum HitResult$HitType {
   private static final HitResult$HitType[] values = new HitResult$HitType[]{HitResult$HitType.BLOCK, HitResult$HitType.MISS, HitResult$HitType.ENTITY};
   public static final HitResult$HitType MISS = new HitResult$HitType();
   public static final HitResult$HitType ENTITY = new HitResult$HitType();
   public static final HitResult$HitType BLOCK = new HitResult$HitType();
}
