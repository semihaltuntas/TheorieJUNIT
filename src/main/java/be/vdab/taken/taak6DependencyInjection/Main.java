package be.vdab.taken.taak6DependencyInjection;

public class Main {
    public static void main(String[] args) {
        try {
            var service = new WoonplaatsService(new WoonplaatsRepositoryStub());
            System.out.println(service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
