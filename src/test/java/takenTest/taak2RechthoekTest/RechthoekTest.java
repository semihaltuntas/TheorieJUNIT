package takenTest.taak2RechthoekTest;

import be.vdab.taken.taak2Rechthoek.Rechthoek;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RechthoekTest {
    @Test
    void deOppervlakteVanEenRechtHoekVan5Op5Is30() {
        assertThat(new Rechthoek(6, 5)
                .getOppervlakte()).isEqualTo(30);
    }

    @Test
    void deOmtrekVanEenRechtHoekVan4Op3Is14() {
        assertThat(new Rechthoek(4, 3)
                .getOmtrek()).isNotEqualTo(16);
    }

    @Test
    void deHashCodeVanGelijke() {
        assertThat(new Rechthoek(6, 5))
                .hasSameHashCodeAs(new Rechthoek(6, 5));
    }

    @Test
    void rechthoekEenVerschillendeParameters() {
        assertThat(new Rechthoek(5, 4))
                .isEqualTo(new Rechthoek(5, 4));
    }

    @Test
    void rechthoekEenHetzelfdeParameters() {
        assertThat(new Rechthoek(4, 3))
                .isEqualTo(new Rechthoek(4, 3));
    }

    @Test
    void eenNegatieveLengteNietZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Rechthoek(-1, 4));
    }

    @Test
    void eenNegatieveBreedteKanNietZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Rechthoek(4, -3));
    }

    @Test
    void deLengteKanNietKleinerDanBreedteZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Rechthoek(3, 9));
    }

}
