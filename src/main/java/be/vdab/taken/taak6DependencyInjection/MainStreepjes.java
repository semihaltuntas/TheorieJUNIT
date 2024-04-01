package be.vdab.taken.taak6DependencyInjection;

import java.util.Scanner;

public class MainStreepjes {
    public static void main(String[] args) {
        System.out.println("1=woonplaatsen.txt, 2=database");
        Scanner scanner = new Scanner(System.in);
        int keuze = scanner.nextInt();
        while (keuze != 1 && keuze != 2) {
            System.out.println("Verkeerde keuze,opnieuw probeer!");
            keuze = scanner.nextInt();
        }
        WoonplaatsRepository repository = keuze == 1 ?
                new TxtWoonplaatsRepository() :
                new JdbcWoonplaatsRepository();
        WoonplaatsService service = new WoonplaatsService(repository);
        try {
            System.out.println(service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
