package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static Map<Integer,Carport> getCarportMap(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Carport> carportList = new ArrayList<>();
        Map<Integer,Carport> carportMap = new HashMap<>();

        String sql = "SELECT * FROM carport.`Carport`";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportID = rs.getInt("carportID");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String rooftype = rs.getString("rooftype");
                    int shed = rs.getInt("shed");

                    Carport carport = new Carport(carportID, length, width, rooftype, shed);
                    carportMap.put(carportID,carport);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return carportMap;
    }
    }