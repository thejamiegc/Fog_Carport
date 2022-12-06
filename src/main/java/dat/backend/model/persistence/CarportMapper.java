package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportMapper {

    static int createCarport(Carport carport, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO Carport (length, width, rooftype, shed) VALUES (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, carport.getLength());
                ps.setInt(2, carport.getWidth());
                ps.setString(3, "Fladt Tag");
                ps.setInt(4, 2);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
         }
        }
    }