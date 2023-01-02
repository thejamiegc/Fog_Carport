package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Shed;
import dat.backend.model.exceptions.DatabaseException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportMapper {
    // METODE FOR AT OPRETTE / INDSÆTTE CARPORT I DATABASE
    static int createCarport(Carport carport, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO Carport (length, width, rooftype) VALUES (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, carport.getLength());
                ps.setInt(2, carport.getWidth());
                ps.setString(3, "Fladt tag");
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert order into database");
        }
    }
    // METODE HENTER OG CARPORTE FRA DATABASE OG GEMMER CARPORTE I ET MAP
    public static Map<Integer, Carport> getCarportMap(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Map<Integer, Carport> carportMap = new HashMap<>();

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
                    carportMap.put(carportID, carport);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return carportMap;
    }
    // METODE SLETTER CARPORT I DB
    public static void deleteCarport(int carportID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "delete from carport.Carport WHERE carportID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carportID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete order from database");
        }
    }
    // METODE OPDATERER orderID PÅ CARPORT I DATABASE
    public static void updateOrderID(int orderID, int carportID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Carport SET orderID = ? WHERE carportID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.setInt(2, carportID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not update order from database");
        }
    }
    // OPRETTER / INDSÆTTER CARPORT I DATABASE
    public static int createShed(Shed shed, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO Shed (length, width) VALUES (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, shed.getShedLength());
                ps.setInt(2, shed.getShedWidth());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert shed into database");
        }

    }
    // OPDATERER orderID PÅ SHED I DATABASE
    public static void updateShedID(int orderID, Shed shed, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Shed SET orderID = ? WHERE shed = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.setInt(2, shed.getShedID());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not update orderID in shed from database");
        }
    }
}