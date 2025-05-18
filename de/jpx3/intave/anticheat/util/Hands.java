package de.jpx3.intave.anticheat.util;

public enum Hands {
   public static final Hands LEFT_HAND = new Hands();
   private static final Hands[] MODERN = new Hands[]{LEFT_HAND, Hands.LEGACY};
   public static final Hands LEGACY = new Hands();
}
