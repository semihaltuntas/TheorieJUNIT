package takenTest.theorie;

import be.vdab.theorie.PersoonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PersoonServiceTest {
    private PersoonService service;
    @BeforeEach
    void beforeEach(){
        service = new PersoonService();
    }
    @Test
    void deWeddeStandaardAfwijkingIsPositief(){
        assertThat(service.staandaardAfwijkingWeddes()).isPositive();
    }
}