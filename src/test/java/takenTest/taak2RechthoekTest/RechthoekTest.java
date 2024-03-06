package takenTest.taak2RechthoekTest;

import be.vdab.taken.taak2Rechthoek.Rechthoek;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RechthoekTest {
    @Test
    void deOppervlakteVanEenRechtHoekVan5Op3Is15(){
        assertThat(new Rechthoek(3,5)
                .getOppervlakte()).isEqualTo(15);
    }
    @Test
    void deOmtrekVanEenRechtHoekVan6Op5Is15(){
        assertThat(new Rechthoek(4,5)
                .getOmtrek()).isEqualTo(18);
    }

}
