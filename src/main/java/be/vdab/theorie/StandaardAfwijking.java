package be.vdab.theorie;

import be.vdab.theorie.exceptions.RepositoryException;

import java.util.Scanner;

public class StandaardAfwijking {
    public static void main(String[] args) {
        System.out.println("1=weddes.csv, 2=database:");
        Scanner scanner = new Scanner(System.in);
        int keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.println("Verkeerd keuze,Opnieuw probeer!");
            keuze = scanner.nextInt();
        }

        PersoonRepository repository = keuze == 1 ? new CsvPersoonRepository() :
                new JdbcPersoonRepository();

        PersoonService service = new PersoonService(repository);
        try {
            System.out.println(service.staandaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            System.out.println("Kan personen niet lezen.!");
            ex.printStackTrace(System.err);
        }
    }
}
