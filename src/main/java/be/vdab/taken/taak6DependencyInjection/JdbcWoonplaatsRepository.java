package be.vdab.taken.taak6DependencyInjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcWoonplaatsRepository extends AbstractRepository implements WoonplaatsRepository {
    @Override
    public List<String> findMetStreepjes() {
        ArrayList<String> namen = new ArrayList<>();
        String sql = """
                SELECT * FROM woonplaatsen
                where naam like '%-%'
                """;
        try (Connection connection = super.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                namen.add(result.getString("naam"));
            }
            connection.commit();
            return namen;
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }
    }
}
