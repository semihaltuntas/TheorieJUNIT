package takenTest.theorie;

import be.vdab.theorie.Statistiek;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;

class StatistiekTest {
    @Test
    void hetGemiddeldeVan70EnIs35() {
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{BigDecimal.valueOf(30),
                BigDecimal.valueOf(40)})).isEqualByComparingTo("35");
    }

    @Test
    void hetGemiddeldeVanEenGetalIsDatGetal() {
        BigDecimal enigGetal = BigDecimal.valueOf(1.23);
        assertThat(Statistiek.getGemiddelde(new BigDecimal[]{enigGetal}))
                .isEqualByComparingTo(enigGetal);
    }

    @Test
    void hetGemiddeldeVanEenLegeVerzamelingKanJeNietBerekenen() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[]{}));
    }

    @Test
    void hetGemiddeldeVanNullKanJeNietBerekenen() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(null));
    }

    @Test
    void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(
                () -> Statistiek.getGemiddelde(new BigDecimal[]{null}));
    }
}