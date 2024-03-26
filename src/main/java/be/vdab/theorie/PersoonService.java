package be.vdab.theorie;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PersoonService {
    private final PersoonRepository repository = new PersoonRepository();

    public BigDecimal staandaardAfwijkingWeddes() {
        var weddes = repository.findAllWeddes();
        BigDecimal totaal = weddes.stream().reduce(BigDecimal.ZERO, (vorigTotaal, huidigeWedde) ->
                vorigTotaal.add(huidigeWedde));

        BigDecimal gemiddelde = totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        totaal = weddes.stream()
                .map(wedde -> wedde.subtract(gemiddelde))
                .map(verschil -> verschil.pow(2))
                .reduce(BigDecimal.ZERO, (vorigTotaal, huidigeKwadraat) ->
                        vorigTotaal.add(huidigeKwadraat));
        BigDecimal variantie = totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        BigDecimal staandardAfwijking = variantie.sqrt(new MathContext(10, RoundingMode.HALF_UP));
        return staandardAfwijking;
    }
}
