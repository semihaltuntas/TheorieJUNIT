package takenTest.taak4VeilingTest;

import be.vdab.taken.taak4Veiling.Veiling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VeilingTest {
    private Veiling veiling;

    @BeforeEach
    void beforeEach(){
        veiling = new Veiling();
    }
    @Test
    void hetHoogsteBodVanEenNiueweVeilingIs0€() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void naEenBodVan10€IsHetHoogsteBod10€() {
        veiling.doeBod(BigDecimal.TEN);
        assertThat(veiling.getHoogsteBod())
                .isEqualByComparingTo("10");
    }

    @Test
    void naEenBodVan15€IsHetHooogsteBod13€() {
       // na de before each verwijdert ->  Veiling veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(100));
        veiling.doeBod(BigDecimal.TEN);
        veiling.doeBod(BigDecimal.valueOf(13));
        assertThat(veiling.getHoogsteBod())
                .isEqualByComparingTo("100");

    }

}