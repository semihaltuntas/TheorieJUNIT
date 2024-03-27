package takenTest.taak6DependencyInjection;

import be.vdab.taken.taak6DependencyInjection.WoonplaatsRepository;
import be.vdab.taken.taak6DependencyInjection.WoonplaatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class WoonplaatsServiceTest {
    private WoonplaatsService service;
    @BeforeEach
    void beforeEach(){
        service = new WoonplaatsService(new WoonplaatsRepository());
    }
    @Test
    void maxAantalStreepjesInEenWoonplaats(){
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isNotNegative();
    }

}