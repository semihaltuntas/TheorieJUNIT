package takenTest.theorie;

import be.vdab.theorie.Jaar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JaarTest {
    @Test
    @DisplayName("Een jaar deelbaar door 400 Is Een Schrikkeljaar")
        // deze manier kan je documentatie lezen.*Specificeert de naam van de testadministratie.
    void eenJaarDeelbaarDoor400IsEenSchrikkeljaar() {
        Jaar jaar = new Jaar(2000);
        assertThat(jaar.isSchrikkeljaar()).isTrue();
    }

    @Test
    void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {
        assertThat(new Jaar(1900).isSchrikkeljaar()).isFalse();
    }

    @Test
    void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
        assertThat(new Jaar(2012).isSchrikkeljaar()).isTrue();
    }

    @Test
    void eenJaarDeelbaarDoor4IsGeenSchrikkeljaar() {
        assertThat(new Jaar(2015).isSchrikkeljaar()).isFalse();
    }

    @Test
    void toStringGeeftHetJaarAlsTekst() {
        assertThat(new Jaar(2015)).hasToString("2015");
    }

    //Equals method control
    @Test
    void jarenMetHetzelfdeJaartalZijnGelijk() {
        assertThat(new Jaar(2015)).isEqualTo(new Jaar(2015));
    }

    @Test
    void jarenMetEenVerschillendJaartalZijnGelijk() {
        assertThat(new Jaar(2013)).isEqualTo(new Jaar(2016));
    }

    //Hashcode control
    @Test
    void deHashCodeVanGelijkeJarenIsGelijk(){
        assertThat(new Jaar(2020)).hasSameHashCodeAs(new Jaar(2020));
    }


}
