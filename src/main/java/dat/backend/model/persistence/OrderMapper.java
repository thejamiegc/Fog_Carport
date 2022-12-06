package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException{

            Logger.getLogger("web").log(Level.INFO, "");
            String sql = "INSERT INTO `Order` (userID, created, carportID, price, statusID, bom) VALUES (?,?,?,?,?,?)";
            try (Connection connection = connectionPool.getConnection()) {
                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1,order.getCustomerID());
                    ps.setInt(2, order.getCarportID());
                    ps.setDouble(3, 0);
                    ps.setInt(4, order.getStatusID());
                    ps.setString(5, "B O M");
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

