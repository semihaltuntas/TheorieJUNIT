package takenTest.taak3ArtikelTest;

import static org.assertj.core.api.Assertions.assertThat;

import be.vdab.taken.taak3Artikel.Artikel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ArtikelTest {
    @Test
    @DisplayName("Prijs Exclusief 40 en Btw Percentage 8 Moet 43 komma 2 Prijs InclusiefZijn")
    void prijsExclusief40enBtwPercentage8Moet43komma2PrijsInclusiefZijn() {
        assertThat(new Artikel(BigDecimal.valueOf(40), BigDecimal.valueOf(8))
                .getPrijsİnclusiefBtw()).isEqualByComparingTo("43.2");
    }
}
