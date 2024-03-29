package be.vdab.theorie;

import be.vdab.taken.taak6DependencyInjection.RepositoryException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersoonRepository extends AbstractRepository implements PersoonRepository {
    @Override
    public List<BigDecimal> findAllWeddes() {
        ArrayList<BigDecimal> weddes = new ArrayList();
        String sql = """
                select wedde
                from personen
                """;
        try (Connection connection = super.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                weddes.add(result.getBigDecimal("wedde"));
            }
            connection.commit();
            return weddes;
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }

    }
}
