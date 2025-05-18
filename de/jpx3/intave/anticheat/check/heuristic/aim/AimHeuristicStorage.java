package de.jpx3.intave.anticheat.check.heuristic.aim;

import de.jpx3.intave.anticheat.storage.Storable;

public final class AimHeuristicStorage extends Storable {
   private int constantTicks;
   private float distance;
   private double a;
   private long lastFlag;
   private double offsetSum;
   private double rotations;
   private double buffer;
   private double secondBuffer;
   private int onTarget;

   static int setTicks(AimHeuristicStorage storage, int ticks) {
      return storage.constantTicks = ticks;
   }

   static double increaseRotationsBuffer(AimHeuristicStorage storage) {
      return (double)(storage.rotations++);
   }

   static double increaseSecondBuffer(AimHeuristicStorage storage) {
      return (double)(storage.secondBuffer++);
   }

   static int setOnTarget(AimHeuristicStorage storage, int bit) {
      return storage.onTarget = bit;
   }

   static double setOffsetAvg(AimHeuristicStorage storage, double var1) {
      return storage.a = var1;
   }

   static long getLastFlag(AimHeuristicStorage storage) {
      return storage.lastFlag;
   }

   static int getTicks(AimHeuristicStorage storage) {
      return storage.constantTicks;
   }

   static double setBuffer(AimHeuristicStorage storage, double buffer) {
      return storage.buffer = buffer;
   }

   static double getSecondBuffer(AimHeuristicStorage storage) {
      return storage.secondBuffer;
   }

   static double getOffsetSum(AimHeuristicStorage storage, double value) {
      return storage.offsetSum = value;
   }

   static double getBuffer(AimHeuristicStorage storage) {
      return storage.buffer;
   }

   static double setSecondBuffer(AimHeuristicStorage storage, double buffer) {
      return storage.secondBuffer = buffer;
   }

   static float setDistance(AimHeuristicStorage storage, float distance) {
      return storage.distance = distance;
   }

   static int getOnTarget(AimHeuristicStorage storage) {
      return storage.onTarget;
   }

   static double setRotationsBuffer(AimHeuristicStorage storage, double rotations) {
      return storage.rotations = rotations;
   }

   static double getOffsetAvg(AimHeuristicStorage storage) {
      return storage.a;
   }

   static double setOffsetSum(AimHeuristicStorage storage) {
      return storage.offsetSum;
   }

   static long setLastFlag(AimHeuristicStorage storage, long time) {
      return storage.lastFlag = time;
   }

   static double increaseBuffer(AimHeuristicStorage storage) {
      return (double)(storage.buffer++);
   }

   static float getDistance(AimHeuristicStorage storage) {
      return storage.distance;
   }

   static double getRotations(AimHeuristicStorage storage) {
      return storage.rotations;
   }
}
