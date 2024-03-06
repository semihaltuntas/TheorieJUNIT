package takenTest.taak1WoordTest;

import be.vdab.taken.taak1Woord.Woord;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


public class WoordTest {
    @Test
    void lepelİsPalindroom(){
        assertThat(new Woord("lepel").isPalindroom()).isTrue();
    }
    @Test
    void semihİsPalindroom(){
        assertThat(new Woord("semih").isPalindroom()).isFalse();
    }
    @Test
    void legeWoordİsPalindroom(){
        assertThat(new Woord("").isPalindroom()).isFalse();
    }
}
