package be.vdab.taken.taak1Woord;

public class Woord {
    private final String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

   public boolean isPalindroom(){
        String omgekeerd = new StringBuilder(woord).reverse().toString();
        return woord.equals(omgekeerd);
    }
}
