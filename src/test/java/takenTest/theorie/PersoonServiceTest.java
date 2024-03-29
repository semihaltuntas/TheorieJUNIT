package takenTest.theorie;

import be.vdab.theorie.PersoonRepository;
import be.vdab.theorie.PersoonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class PersoonServiceTest {
    @Mock
    private PersoonRepository repository;

    private PersoonService service;


    @BeforeEach
    void beforeEach(){
        service = new PersoonService(repository);
    }

    @Test
    void deWeddeStandaardAfwijkingIs2(){
        when(repository.findAllWeddes()).thenReturn(
                Stream.of(2, 4, 4, 4, 5, 5, 7, 9)
                        .map(getal -> BigDecimal.valueOf(getal))
                        .toList());

        assertThat(service.staandaardAfwijkingWeddes()).isEqualByComparingTo("2");
        verify(repository).findAllWeddes();
    }


//    @BeforeEach
//    void beforeEach2 () {
//        service = new PersoonService(new PersoonRepositoryStub());
//    }
//    @Test
//    void deWeddeStandaardAfwijkingIs2(){
//        assertThat(service.staandaardAfwijkingWeddes()).isEqualByComparingTo("2");
//    }

}