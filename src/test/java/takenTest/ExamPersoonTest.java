package takenTest;

import be.vdab.taken.ExamPersoon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExamPersoonTest {
    private ExamPersoon persoon;

    @BeforeEach
    void beforeEach() {
        persoon = new ExamPersoon();
        persoon.voornamen = new LinkedHashSet<>(Arrays.asList("semih", "enes", "burak", "kadir"));
    }

    @Test
    void eenNullWaardeKanNiet() {
        assertThatNullPointerException().isThrownBy(
                () -> persoon.add(null));
    }

    @Test
    void eenLegeWaardeKanNiet() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> persoon.add(" "));
    }

    @Test
    void dezelfdeVoornaamBevat() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> persoon.add("semih"));
    }

    @Test
    void metSpatieToString() {
        persoon.add("frank");
        persoon.add("jutta");
        assertThat(persoon.toString()).hasToString("semih enes burak kadir frank jutta");
    }

}