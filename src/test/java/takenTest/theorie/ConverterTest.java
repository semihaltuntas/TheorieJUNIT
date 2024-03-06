package takenTest.theorie;

import be.vdab.theorie.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    void eenInchIs2Komma54Centimeters(){
        assertThat(new Converter().inchesNaarCentimeters(BigDecimal.ONE))
                .isEqualByComparingTo("2.54");
    }
    @Test
    void tweeHonderdInchesIs508Centimeters(){
        assertThat(new Converter().inchesNaarCentimeters(BigDecimal.valueOf(200)))
                .isEqualByComparingTo("508");
    }
}
