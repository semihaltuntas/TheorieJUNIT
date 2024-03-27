package be.vdab.taken.taak6DependencyInjection;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class WoonplaatsRepository {
    public List<String> findMetStreepjes() {
        try (Stream<String> stream = Files.lines(Path.of("/data/woonplaatsen.txt"))) {
            return stream.filter(woonplaats -> woonplaats.contains("-")).toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }
}
