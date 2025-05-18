package de.jpx3.intave.anticheat.check.heuristic.rounded;

import de.jpx3.intave.anticheat.storage.Storable;

public class RoundedHeuristicStorage extends Storable {
   private float lastPitchDelta;
   private int c;
   private int decimalBuffer;
   private int digitsBuffer;

   static int d(RoundedHeuristicStorage storage) {
      return storage.c;
   }

   static int b(RoundedHeuristicStorage storage, int var1) {
      return storage.c = var1;
   }

   static float getLastPitchDelta(RoundedHeuristicStorage storage) {
      return storage.lastPitchDelta;
   }

   static int setDigitsBuffer(RoundedHeuristicStorage storage, int buffer) {
      return storage.digitsBuffer = buffer;
   }

   static int decreaseDigitsBuffer(RoundedHeuristicStorage storage) {
      return storage.digitsBuffer--;
   }

   static int increaseDigitsBuffer(RoundedHeuristicStorage storage) {
      return storage.digitsBuffer++;
   }

   static int getDigitsBuffer(RoundedHeuristicStorage storage) {
      return storage.digitsBuffer;
   }

   static float setLastPitchDelta(RoundedHeuristicStorage storage, float pitchDelta) {
      return storage.lastPitchDelta = pitchDelta;
   }

   static int decreaseDecimalBuffer(RoundedHeuristicStorage storage) {
      return storage.decimalBuffer--;
   }

   static int getDecimalBuffer(RoundedHeuristicStorage storage) {
      return storage.decimalBuffer;
   }

   static int a(RoundedHeuristicStorage storage) {
      return storage.c--;
   }

   static int setDecimalBuffer(RoundedHeuristicStorage storage, int buffer) {
      return storage.decimalBuffer = buffer;
   }
}
