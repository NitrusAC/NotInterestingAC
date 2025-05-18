package de.jpx3.intave.anticheat.util;

public final class MathHelperTable {
   private static final float[] vanillaMathTable = new float[65536];
   private static final float[] fastMathTable = new float[4096];

   public static float sin(float value, boolean fastMath) {
      return fastMath ? fastMathTable[(int)(value * 651.8986F) & 4095] : vanillaMathTable[(int)(value * 10430.378F) & 65535];
   }

   public static float toFloat(double value) {
      return (float)((double)Math.round(value * 1.0E8) / 1.0E8);
   }

   public static float cos(float value, boolean fastMath) {
      return fastMath
         ? fastMathTable[(int)((value + (float) (Math.PI / 2)) * 651.8986F) & 4095]
         : vanillaMathTable[(int)(value * 10430.378F + 16384.0F) & 65535];
   }

   public static void setup() {
      for(int var3 = 0; var3 < 65536; ++var3) {
         vanillaMathTable[var3] = (float)Math.sin((double)var3 * Math.PI * 2.0 / 65536.0);
      }

      for(int var4 = 0; var4 < 4096; ++var4) {
         fastMathTable[var4] = toFloat(Math.sin((double)var4 * Math.PI * 2.0 / 4096.0));
      }

   }
}
