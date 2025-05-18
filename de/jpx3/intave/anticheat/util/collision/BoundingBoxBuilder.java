package de.jpx3.intave.anticheat.util.collision;

import de.jpx3.intave.unknown.Unknown121;
import java.util.ArrayList;
import java.util.List;

public final class BoundingBoxBuilder {
   private double minZ;
   private double maxY;
   private final List boundingBoxes = new ArrayList(1);
   private double maxZ;
   private double minX;
   private double maxX;
   private double minY;

   public Boxable create() {
      return Unknown121.c(this.pushAndGetBoundingBoxes());
   }

   public void ofEmpty() {
      this.bounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void bounds(Box box) {
      this.minX = box.minX;
      this.minY = box.minY;
      this.minZ = box.minZ;
      this.maxX = box.maxX;
      this.maxY = box.maxY;
      this.maxZ = box.maxZ;
   }

   public List getBoundingBoxes() {
      return this.boundingBoxes;
   }

   public void pushBox() {
      Box var1 = new Box(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
      var1.a();
      this.boundingBoxes.add(var1);
   }

   public List pushAndGetBoundingBoxes() {
      this.pushBox();
      return this.getBoundingBoxes();
   }

   public static BoundingBoxBuilder of() {
      return new BoundingBoxBuilder();
   }

   public void bounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
      this.minX = (double)minX;
      this.minY = (double)minY;
      this.minZ = (double)minZ;
      this.maxX = (double)maxX;
      this.maxY = (double)maxY;
      this.maxZ = (double)maxZ;
   }

   private BoundingBoxBuilder() {
   }

   public String toString() {
      return "BoundingBoxBuilder{boundingBoxes="
         + this.boundingBoxes
         + ", minX="
         + this.minX
         + ", minY="
         + this.minY
         + ", minZ="
         + this.minZ
         + ", maxX="
         + this.maxX
         + ", maxY="
         + this.maxY
         + ", maxZ="
         + this.maxZ
         + '}';
   }
}
