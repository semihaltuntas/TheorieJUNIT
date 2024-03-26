package be.vdab.theorie.exceptions;

public class RepositoryException extends RuntimeException {
    public RepositoryException(Exception oorzaak) {
        super(oorzaak);
    }
}
