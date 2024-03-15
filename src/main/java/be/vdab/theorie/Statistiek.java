package be.vdab.theorie;

import java.math.BigDecimal;
import java.util.Arrays;

public class Statistiek {
    public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
      if (getallen.length == 0){
          throw new IllegalArgumentException("Lege Array!");
      }
            return Arrays.stream(getallen)
                    .reduce(BigDecimal.ZERO , (vorigeTotaal,getal)-> vorigeTotaal.add(getal))
                    .divide(BigDecimal.valueOf(getallen.length));
    }
}
