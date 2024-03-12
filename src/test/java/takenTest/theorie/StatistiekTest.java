package takenTest.theorie;

import be.vdab.theorie.Statistiek;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class StatistiekTest {
    @Test void hetGemiddeldeVan0EnIs5(){
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{BigDecimal.ZERO,
        BigDecimal.TEN})).isEqualByComparingTo("5");

    }

}