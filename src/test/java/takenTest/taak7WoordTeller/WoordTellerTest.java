package takenTest.taak7WoordTeller;

import be.vdab.taken.taak7WoordTeller.WoordTeller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class WoordTellerTest {

    private WoordTeller woordTeller;

    @BeforeEach
    void BeforeEach() {
        woordTeller = new WoordTeller();
    }

    @Test
    void eenNullWaardeKanNiet() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> woordTeller.telWoorden(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " ", ",", ",,,", " , ,, "})
    void bevat0Woorden(String tekst) {
        assertThat(woordTeller.telWoorden(tekst)).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"semih", " semih", "semih "})
    void bevat1Woord(String tekst) {
        assertThat(woordTeller.telWoorden(tekst)).isOne();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ik ook", "ik  ook", "ik,ook", "ik, ook", "ik , ook"})
    void bevat2Woord(String tekst) {
        assertThat(woordTeller.telWoorden(tekst)).isEqualTo(2);
    }
}