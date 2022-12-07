package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException{

            Logger.getLogger("web").log(Level.INFO, "");
            String sql = "INSERT INTO carport.Order (userID, carportID, price, statusID) VALUES (?,?,?,?)";
            try (Connection connection = connectionPool.getConnection()) {
                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1,order.getCustomerID());
                    ps.setInt(2, order.getCarportID());
                    ps.setDouble(3, 0);
                    ps.setInt(4, order.getStatusID());
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();
                    rs.next();
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Could not insert order into database");
            }
    }

    public static List<Order> readOrder(int userID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM carport.`Order` WHERE userID = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("statusID");

                    Order order = new Order(orderID, customerID, created, carportID, price, statusID);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return orderList;
    }
    }
