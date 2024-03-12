package be.vdab.theorie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rekeningnummer {
    private static final Pattern PATTERN =
            Pattern.compile("^BE(\\d{2})(\\d{12})$");
    private final String nummer;

    public Rekeningnummer(String nummer) {
        Matcher matcher = PATTERN.matcher(nummer);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Verkeerd Formaat");
        }
        Integer controleGetal = Integer.valueOf(matcher.group(1));
        if (controleGetal < 2 || controleGetal > 98) {
            throw new IllegalArgumentException("1 of 2 cijfer verkeerd!");
        }
            Long teControlerenNummer = Long.valueOf(matcher.group(2) +
                    "1114" + matcher.group(1));
            if (teControlerenNummer % 97 != 1) {
                throw new IllegalArgumentException("Nummer bevat verkeerde cijfers");
            }
            this.nummer = nummer;
    }

    @Override
    public String toString() {
        return nummer;
    }
}
