package be.vdab.taken.taak6DependencyInjection;

public class RepositoryException extends RuntimeException{
    public RepositoryException(Exception oorzaak) {
        super(oorzaak);
    }
}
