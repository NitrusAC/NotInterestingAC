package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.UUID;
import org.bukkit.util.Vector;

public final class Unknown97 extends Unknown95 {
   private Vector attackedPosition;
   private UUID attacker;
   private boolean damage;

   public Vector getAttackedPosition() {
      return this.attackedPosition;
   }

   public void setDamage(boolean var1) {
      this.damage = var1;
   }

   public void setAttackedPosition(Vector var1) {
      this.attackedPosition = var1;
   }

   @Override
   public void deserialize(JsonElement var1) {
      JsonObject var6 = var1.getAsJsonObject();
      this.attacker = UUID.fromString(var6.get("attackerId").getAsString());
      this.attackedPosition = new Vector();
      this.attackedPosition.setX(var6.get("attackedPositionX").getAsDouble());
      this.attackedPosition.setY(var6.get("attackedPositionY").getAsDouble());
      this.attackedPosition.setZ(var6.get("attackedPositionZ").getAsDouble());
      this.damage = var6.get("damage").getAsBoolean();
   }

   public boolean isDamage() {
      return this.damage;
   }

   public void setAttacker(UUID var1) {
      this.attacker = var1;
   }

   public UUID getAttacker() {
      return this.attacker;
   }

   public Unknown97() {
      super("out-attack-cancel");
   }

   @Override
   public JsonElement serialize() {
      JsonObject var4 = new JsonObject();
      var4.addProperty("attackerId", this.attacker.toString());
      var4.addProperty("attackedPositionX", this.attackedPosition.getX());
      var4.addProperty("attackedPositionY", this.attackedPosition.getY());
      var4.addProperty("attackedPositionZ", this.attackedPosition.getZ());
      var4.addProperty("damage", this.damage);
      return var4;
   }
}
