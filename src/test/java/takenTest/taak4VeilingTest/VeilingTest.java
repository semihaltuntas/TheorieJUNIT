package takenTest.taak4VeilingTest;

import be.vdab.taken.taak4Veiling.Veiling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VeilingTest {
    @Test
    void hetHoogsteBodVanEenNiueweVeilingIs0€() {
        Veiling veiling = new Veiling();
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void naEenBodVan10€IsHetHoogsteBod10€() {
        Veiling veiling = new Veiling();
        veiling.doeBod(BigDecimal.TEN);
        assertThat(veiling.getHoogsteBod())
                .isEqualByComparingTo("10");
    }

    @Test
    void naEenBodVan15€IsHetHooogsteBod13€() {
        Veiling veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(100));
        veiling.doeBod(BigDecimal.TEN);
        veiling.doeBod(BigDecimal.valueOf(13));
        assertThat(veiling.getHoogsteBod())
                .isEqualByComparingTo("100");

    }

}