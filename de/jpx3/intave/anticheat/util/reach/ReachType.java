package de.jpx3.intave.anticheat.util.reach;

public enum ReachType {
   public static final ReachType ENTITY = new ReachType();
   public static final ReachType BLOCK = new ReachType();
   private static final ReachType[] values = new ReachType[]{BLOCK, ENTITY};
}
