package be.vdab.theorie;

import java.math.BigDecimal;
import java.util.List;

public class Rekening {
    private BigDecimal saldo = BigDecimal.ZERO;
    public void stort(BigDecimal bedrag) {
      if (bedrag.compareTo(BigDecimal.ZERO) <= 0){
          throw new IllegalArgumentException("Bedrag moet positief zijn");
      }
        saldo = saldo.add(bedrag);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<BigDecimal> getStortingen(){
        throw new UnsupportedOperationException();
    }
    public List<BigDecimal> getStortingenGesorteerd(){
        throw new UnsupportedOperationException();
    }
}
