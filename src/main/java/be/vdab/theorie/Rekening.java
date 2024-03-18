package be.vdab.theorie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private BigDecimal saldo = BigDecimal.ZERO;
    private final List<BigDecimal> stortingen = new ArrayList<>();
    public void stort(BigDecimal bedrag) {
      if (bedrag.compareTo(BigDecimal.ZERO) <= 0){
          throw new IllegalArgumentException("Bedrag moet positief zijn");
      }
        stortingen.add(bedrag);
    }

    public BigDecimal getSaldo() {
        return stortingen.stream().reduce(
                BigDecimal.ZERO,(vorigeSaldo,storting)-> vorigeSaldo.add(storting));
    }

    public List<BigDecimal> getStortingen(){
        return stortingen;
    }
    public List<BigDecimal> getStortingenGesorteerd(){
        return stortingen.stream().sorted().toList();
    }
}
