package be.vdab.theorie;

import be.vdab.theorie.exceptions.RepositoryException;

public class StandaardAfwijking {
    public static void main(String[] args) {
        try{
            var service = new PersoonService(new PersoonRepositoryStub());
            System.out.println(service.staandaardAfwijkingWeddes());
        }catch (RepositoryException ex){
            System.out.println("Kan personen niet lezen.!");
            ex.printStackTrace(System.err);
        }
    }
}
