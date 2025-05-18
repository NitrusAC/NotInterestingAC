package de.jpx3.intave.anticheat.check.place.suspicious;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayList;
import java.util.List;

public class SuspiciousBlockStorage extends Storable {
   public long lastFlag;
   public List deltas = new ArrayList();
   public double buffer;
   public long lastFlying;
}
