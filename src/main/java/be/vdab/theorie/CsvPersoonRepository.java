package be.vdab.theorie;

import be.vdab.theorie.exceptions.RepositoryException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class CsvPersoonRepository implements PersoonRepository {

    @Override
    public List<BigDecimal> findAllWeddes() {
        try (Stream<String> stream = Files.lines(Path.of("/data/personen.csv"))) {
            return stream.map(regel -> new BigDecimal(regel.split(",")[3])).toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }
}
