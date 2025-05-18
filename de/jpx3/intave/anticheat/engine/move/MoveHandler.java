package de.jpx3.intave.anticheat.engine.move;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;

public interface MoveHandler {
   MotionContext moveEntity(PlayerData data, Motion motion, double motionX, double motionY, double motionZ, boolean inWeb);
}
