package takenTest.taak9Paswoord;

import be.vdab.taken.taak9Paswoord.Paswoord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class PaswoordTest {
    private Paswoord waarde;
    @BeforeEach
    void beforeEach(){
        waarde = new Paswoord("Joske123");
    }
    @Test
    void Joske123IsEenCorrectPaswoord() {
        Paswoord waarde1 = waarde;
    }

    @ParameterizedTest
    @ValueSource(strings = {"12344567", "1234567A", "1234567a", "AaBbCcDd"})
    void verkeerdPaswoord(String string) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Paswoord(string));
    }

    @Test
    void dePuntjesZijnEvenLangAlsHetPaswoord() {
        assertThat(waarde.getPuntjes()).isEqualTo("........");
    }

    @Test
    void eenPaswoordKomtOvereenMetZichZelf() {
        String s = "Joske123";
        assertThat(waarde.komtOvereenMet(s)).isTrue();
    }

    @Test
    void nullIsEenOngeldigPaswoord() {
        assertThatNullPointerException().isThrownBy(
                () -> new Paswoord(null));
    }
}