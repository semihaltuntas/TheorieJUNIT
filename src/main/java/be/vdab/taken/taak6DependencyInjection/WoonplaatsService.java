package be.vdab.taken.taak6DependencyInjection;

public class WoonplaatsService {
    private final WoonplaatsRepository repository;

    public WoonplaatsService(WoonplaatsRepository repository) {
        this.repository = repository;
    }

    public long maxAantalStreepjesInEenWoonplaats() {
        return repository.findMetStreepjes().stream()
                .map(woonplaats -> woonplaats.chars()
                        .filter(eenchar -> eenchar == '-').count())
                .max(Long::compare).orElse(0L);
    }
}
