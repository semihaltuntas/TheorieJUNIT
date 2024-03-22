package takenTest.taak5ISBN;

import be.vdab.taken.taak5ISBN.Isbn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class IsbnTest {
    @Test
    void hetNummer0IsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(0));
    }

    @Test
    void eenNegatievbeNummerIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(-9782563549549L));
    }

    @Test
    void eenNummerMet12CijfersIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(978569832147L));
    }

    @Test
    void eenNummerMet14CijfersIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(97856983214758L));
    }

    @Test
    void deEerste3CijfersMoeten978of979Zijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(9779227439643L));
    }

    @Test
    void eenNummerMet13CijfersMetCorrectControleGetal2() {
        new Isbn(9789027439642L);
    }

    @Test
    void eenNummerMet13CijfersMetVerkeerdControleGetal3() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(9789027439643L));
    }

    @Test
    void eenNummerMet13CijfersMetCorrectControleGetal0() {
        new Isbn(9789227439640L);
    }


    @ParameterizedTest
    @ValueSource(longs = {0, -9782563549549L, 978569832147L, 97856983214758L, 9779227439643L, 9789027439643L})
    void verkeerdeNummers(long nummer) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn(nummer));
    }

    @ParameterizedTest
    @ValueSource(longs = {9789027439642L, 9789227439640L})
    void correcteNummer(long nummer) {
        new Isbn(nummer);
    }

    @Test
    void toStringMoetHetNummerTeruggeven() {
        assertThat(new Isbn(9789227439640L)).hasToString("9789227439640");
    }
}
