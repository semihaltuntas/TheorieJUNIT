package be.vdab.taken.taak9Paswoord;

import java.util.regex.Pattern;

public class Paswoord {
    private final static Pattern MINSTENS_1_KLEİNE_LETTER =
            Pattern.compile("^.*[a-z]{1,}.*$");
    private final static Pattern MINSTENS_1_HOOFDLETTER =
            Pattern.compile("^.*[A-Z]{1,}.*$");
    private final static Pattern MINSTENS_1_CIJFER =
            Pattern.compile("^.*[0-9]{1,}.*$");
    private String waarde;

    public Paswoord(String waarde) {
        if (waarde.length() < 8) {
            throw new IllegalArgumentException("Minstens 8 tekens");
        }
        if (!MINSTENS_1_KLEİNE_LETTER.matcher(waarde).matches()) {
            throw new IllegalArgumentException("Minstens 1 kleine letter");
        }
        if (!MINSTENS_1_HOOFDLETTER.matcher(waarde).matches()) {
            throw new IllegalArgumentException("Minstens 1 hoofdletter");
        }
        if (!MINSTENS_1_CIJFER.matcher(waarde).matches()) {
            throw new IllegalArgumentException("Minstens 1 Cijfer");
        }
        this.waarde = waarde;
    }

    public String getPuntjes() {
        return ".".repeat(waarde.length());
    }

    public boolean komtOvereenMet(String paswoord) {
        return this.waarde.equals(paswoord);
    }
}
