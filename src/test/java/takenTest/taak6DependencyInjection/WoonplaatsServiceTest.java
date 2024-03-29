package takenTest.taak6DependencyInjection;

import be.vdab.taken.taak6DependencyInjection.WoonplaatsRepository;
import be.vdab.taken.taak6DependencyInjection.WoonplaatsRepositoryStub;
import be.vdab.taken.taak6DependencyInjection.WoonplaatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class WoonplaatsServiceTest {
    @Mock
    private WoonplaatsRepository repository;
    private WoonplaatsService service;

    //    @BeforeEach
//    void beforeEach(){
//        service = new WoonplaatsService(new WoonplaatsRepository());
//    }
//    @Test
//    void maxAantalStreepjesInEenWoonplaats(){
//        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isNotNegative();
//    }
    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(repository);

    }

    @Test
    void eenWoonplaatsBevatMax5Streepjes() {
        when(repository.findMetStreepjes()).thenReturn(
                List.of("L-e-u-v-e-n", "H-a-a-cht", "L-ieg-e-", "Antwe-rpe-n"));

        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(5L);
        verify(repository).findMetStreepjes();
    }
}