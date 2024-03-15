package takenTest.theorie;

import be.vdab.theorie.Rekening;
import jdk.incubator
         .vector.Vector;
import jdk.incubator.vector.VectorOperators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RekeningTest {
    private Rekening rekening;

    @BeforeEach
    void beforeEach() {
        rekening = new Rekening();
    }

    @Test
    void hetSaldoVanEenNieuweRekeningIs0€() {
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void nadatJe10€StortIsHetSaldo10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void nadatJe10€En1€StortHetSaldo11€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(BigDecimal.valueOf(9));
        assertThat(rekening.getSaldo()).isEqualByComparingTo("20");
    }

    @Test
    void hetGestorteBedragMagNietNullZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> rekening.stort(BigDecimal.ZERO));
    }

    @Test
    void hetGestortBedragMagNietNegatifZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> rekening.stort(BigDecimal.valueOf(-1)));
    }

    @Test
    void stortMetNullKanNiet() {
        assertThatNullPointerException().isThrownBy(
                () -> rekening.stort(null));
    }

    /* Method die een collection teruggeeft */

    private static final BigDecimal TWEE = BigDecimal.valueOf(2);

    @Test
    void eenNieuweRekeningHeeftGeenStortingen() {
        assertThat(rekening.getStortingen()).isEmpty();
    }

    @Test
    void nadatJe10€StortIsErEenStortingVan10€() {
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }

    @Test
    void nadatJe10€En1€StortZijnDeStortingen10€En1€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen())
                .containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test
    void nadatJe10€En1€En2€StortZijnDeStortingenGesorteerd1€En2€En10€(){
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(TWEE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted()
                .containsExactly(BigDecimal.ONE,TWEE,BigDecimal.TEN);
    }

}