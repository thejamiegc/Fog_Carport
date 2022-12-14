package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Order (userID, carportID, price, statusID) VALUES (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getCustomerID());
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

    public static List<Order> readOrdersAsCustomer(int userID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        //String sql = "SELECT * FROM carport.`Order` WHERE userID = ?";
        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.carportID = Carport.carportID WHERE `Order`.userID = ?";

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
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String rooftype = rs.getString("rooftype");
                    int shed = rs.getInt("shed");
                    String statusname = rs.getString("statusname");

                    Carport carport = new Carport(carportID, length, width, rooftype, shed);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return orderList;
    }

    public static List<Order> readRequestAsAdmin(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.carportID = Carport.carportID WHERE `Order`.statusID = 1";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("statusID");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String rooftype = rs.getString("rooftype");
                    int shed = rs.getInt("shed");
                    String statusname = rs.getString("statusname");

                    Carport carport = new Carport(carportID, length, width, rooftype, shed);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return orderList;
    }

    public static List<Order> readOrdersAsAdmin(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.carportID = Carport.carportID WHERE `Order`.statusID != 1";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("statusID");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String rooftype = rs.getString("rooftype");
                    int shed = rs.getInt("shed");
                    String statusname = rs.getString("statusname");

                    Carport carport = new Carport(carportID, length, width, rooftype, shed);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return orderList;
    }

    public static Order readDataFromAnOrder(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        BillOfMaterials billOfMaterials = new BillOfMaterials();
        Order order = null;

        String sql = "SELECT * FROM `Order`\n" +
                "    inner join Status on `Order`.statusID = `Status`.statusID\n" +
                "    inner join Carport on `Order`.carportID = Carport.carportID\n" +
                "    inner join Shed on Carport.shed = Shed.shed\n" +
                "    inner join User on `Order`.userID = User.userID\n" +
                "    inner join Postalcode on User.postalcode = Postalcode.postalcode\n" +
                "    inner join Bom on `Order`.orderID = Bom.orderID\n" +
                "    inner join Material on Bom.bomID = Material.bomID\n" +
                "    inner join MaterialType on Material.type = MaterialType.typeID\n" +
                "    WHERE Order.orderID VALUES (?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int postalcode = rs.getInt("User.postalcode");
                    int phonenumber = rs.getInt("phonenumber");
                    String city = rs.getString("city");

                    int userID = rs.getInt("Order.userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("Order.carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("Order.statusID");
                    String statusname = rs.getString("statusname");
                    int bomID = rs.getInt("Bom.bomID");

                    int width = rs.getInt("Carport.width");
                    int carportLength = rs.getInt("Carport.length");
                    String rooftype = rs.getString("rooftype");
                    int shed = rs.getInt("Carport.shed");

                    String description = rs.getString("description");
                    int matLength = rs.getInt("Material.length");
                    int quantity = rs.getInt("quantity");
                    String unit = rs.getString("unit");
                    String itemDescription = rs.getString("itemDescription");
                    double pricepermeter = rs.getDouble("pricepermeter");
                    String typeName = rs.getString("name");
                    int typeID = rs.getInt("typeID");


                    User user = new User(firstname,lastname, email, address, postalcode, phonenumber, city);
                    Carport carport = new Carport(carportLength, width, rooftype, shed);
                    billOfMaterials.addMaterialToList(new Material(description,matLength,quantity,unit,itemDescription,pricepermeter,typeName,typeID));
                    order = new Order(orderID,userID,created,carportID,price,statusID,carport,statusname,bomID,billOfMaterials,user);

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return order;
    }


    public static void deleteOrder(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        //CarportFacade.deleteCarport(orderItem.getCarportID(), connectionPool);

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from Bom WHERE orderID = ?; DELETE from Shed WHERE orderID = ?; DELETE from Carport WHERE orderID = ?; DELETE from `Order` WHERE orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.setInt(2, orderID);
                ps.setInt(3, orderID);
                ps.setInt(4, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete order from database");
        }
    }


    public static int createBom(int orderID, ConnectionPool connectionPool)throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Bom (orderID) VALUES (?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert bom into database");
        }
    }



    public static int createMaterial(Material material, int bomID, ConnectionPool connectionPool) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Material (description, length, quantity, unit, itemdescription, pricepermeter, totalprice, type, bomID) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, material.getDescription());
                ps.setInt(2, material.getLength());
                ps.setInt(3, material.getQuantity());
                ps.setString(4, material.getUnit());
                ps.setString(5, material.getItemDescription());
                ps.setDouble(6, material.getPricePerMeter());
                ps.setDouble(7, material.getTotalPrice());
                ps.setInt(8, material.getTypeID());
                ps.setInt(9, bomID);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert material into database");
        }
    }
}

