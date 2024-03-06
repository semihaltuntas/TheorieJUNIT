package be.vdab.taken.taak4Veiling;

import java.math.BigDecimal;
import java.security.PublicKey;

public class Veiling {
    private BigDecimal hoogsteBod = BigDecimal.ZERO;


    public void doeBod(BigDecimal bedrag) {
        if (bedrag.compareTo(hoogsteBod) > 0) {
            hoogsteBod = bedrag;
        }
        // throw new UnsupportedOperationException();

    }

    public BigDecimal getHoogsteBod() {
        return hoogsteBod;
        // throw new UnsupportedOperationException();
    }
}
