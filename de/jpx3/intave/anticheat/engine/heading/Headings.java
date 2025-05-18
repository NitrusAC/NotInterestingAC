package de.jpx3.intave.anticheat.engine.heading;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.engine.heading.impl.BoatHeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.impl.ElytraHeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.impl.HorseHeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.impl.VanillaHeadingHandler;
import java.util.Arrays;
import java.util.List;

@Relocate
public final class Headings {
   public static final HeadingHandler VANILLA = new VanillaHeadingHandler();
   public static final HeadingHandler ELYTRA = new ElytraHeadingHandler();
   private static final List values = Arrays.asList(VANILLA, ELYTRA, Headings.HORSE, Headings.BOAT);
   public static final HeadingHandler BOAT = new BoatHeadingHandler();
   public static final HeadingHandler HORSE = new HorseHeadingHandler();

   public static List getHandlers() {
      return values;
   }
}
