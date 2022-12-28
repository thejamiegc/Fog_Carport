package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Order (userID, carportID, price, statusID) VALUES (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getUser().getUserID());
                ps.setInt(2, order.getCarport().getCarportID());
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

    public static void updateOrderPrice(Order order, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Order SET price = ? WHERE orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, order.getPrice());
                ps.setInt(2, order.getOrderID());
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public static List<Order> readOrdersAsCustomer(int userID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.orderID = Carport.orderID left join Shed on `Order`.orderID = Shed.orderID WHERE `Order`.userID = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("Order.orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("Carport.carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("Status.statusID");
                    String statusname = rs.getString("statusname");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    String rooftype = rs.getString("rooftype");

                    //shed
                    int shedID = rs.getInt("shed");
                    int shedLength = rs.getInt("Shed.length");
                    int shedWidth = rs.getInt("Shed.width");
                    int shedOrderID = rs.getInt("Shed.orderID");


                    Carport carport = new Carport(carportID, length, width, rooftype, orderID);
                    Shed shed = new Shed(shedID, shedLength, shedWidth, shedOrderID);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname, shed);
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
        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.orderID = Carport.orderID left join Shed on `Order`.orderID = Shed.orderID WHERE `Order`.statusID <= 2";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("Order.orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("Order.carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("Order.statusID");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String rooftype = rs.getString("rooftype");
                    String statusname = rs.getString("statusname");

                    //shed
                    int shedID = rs.getInt("shed");
                    int shedLength = rs.getInt("Shed.length");
                    int shedWidth = rs.getInt("Shed.width");
                    int shedOrderID = rs.getInt("Shed.orderID");

                    Carport carport = new Carport(carportID, length, width, rooftype, orderID);
                    Shed shed = new Shed(shedID, shedLength, shedWidth, shedOrderID);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname, shed);
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

        String sql = "SELECT * FROM `Order` inner join Status on `Order`.statusID = `Status`.statusID inner join Carport on `Order`.carportID = Carport.carportID left join Shed on `Order`.orderID = Shed.orderID WHERE `Order`.statusID >= 3";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("Order.orderID");
                    int customerID = rs.getInt("userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("Order.carportID");
                    int price = rs.getInt("price");
                    int statusID = rs.getInt("Order.statusID");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String rooftype = rs.getString("rooftype");
                    String statusname = rs.getString("statusname");

                    //shed
                    int shedID = rs.getInt("shed");
                    int shedLength = rs.getInt("Shed.length");
                    int shedWidth = rs.getInt("Shed.width");
                    int shedOrderID = rs.getInt("Shed.orderID");

                    Carport carport = new Carport(carportID, length, width, rooftype, orderID);
                    Shed shed = new Shed(shedID, shedLength, shedWidth, shedOrderID);
                    Order order = new Order(orderID, customerID, created, carportID, price, statusID, carport, statusname, shed);
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
        Map<Integer, BillOfMaterials> billOfMaterialsList = new HashMap<>();
        Order order = null;

        String sql = "SELECT * FROM `Order`" +
                "    inner join Status on `Order`.statusID = `Status`.statusID" +
                "    inner join Carport on `Order`.orderID = Carport.orderID" +
                "    inner join User on `Order`.userID = User.userID" +
                "    inner join Postalcode on User.postalcode = Postalcode.postalcode" +
                "    inner join Bom on `Order`.orderID = Bom.orderID" +
                "    inner join Material on Bom.materialID = Material.materialID" +
                "    inner join MaterialType on Material.type = MaterialType.typeID" +
                "    left join Shed on `Order`.orderID = Shed.orderID" +
                "    WHERE `Order`.orderID = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //user
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int postalcode = rs.getInt("User.postalcode");
                    int phonenumber = rs.getInt("phonenumber");
                    String city = rs.getString("city");

                    //order
                    int userID = rs.getInt("Order.userID");
                    Timestamp created = rs.getTimestamp("created");
                    int carportID = rs.getInt("Order.carportID");
                    int orderPrice = rs.getInt("Order.price");
                    int statusID = rs.getInt("Order.statusID");
                    String statusname = rs.getString("statusname");

                    //carport
                    int carportWidth = rs.getInt("Carport.width");
                    int carportLength = rs.getInt("Carport.length");
                    String rooftype = rs.getString("rooftype");

                    //shed
                    int shedID = rs.getInt("shed");
                    int shedLength = rs.getInt("Shed.length");
                    int shedWidth = rs.getInt("Shed.width");
                    int shedOrderID = rs.getInt("Shed.orderID");

                    //bom
                    int bomID = rs.getInt("bomID");
                    int materialID = rs.getInt("Bom.materialID");
                    String bomDescription = rs.getString("Bom.description");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("Bom.price");

                    //material
                    String matdescription = rs.getString("Material.description");
                    int matLength = rs.getInt("Material.length");
                    String unit = rs.getString("unit");
                    double priceperunit = rs.getInt("priceperunit");
                    int type = rs.getInt("type");
                    String typename = rs.getString("name");


                    User user = new User(firstname, lastname, email, address, postalcode, phonenumber, city);
                    Shed shed = new Shed(shedID, shedLength, shedWidth, shedOrderID);
                    Carport carport = new Carport(carportID, carportLength, carportWidth, rooftype, orderID);
                    Material material = new Material(materialID, matdescription, matLength, unit, priceperunit, type, typename);
                    billOfMaterialsList.put(materialID, new BillOfMaterials(bomID, orderID, materialID, bomDescription, quantity, price, material));
                    order = new Order(orderID, userID, created, carportID, orderPrice, statusID, carport, statusname, billOfMaterialsList, user, shed);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return order;
    }


    public static void deleteOrder(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from `Order` WHERE `Order`.orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete order from database");
        }
    }

    public static void deleteBom(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from Bom WHERE Bom.orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete order from database");
        }
    }

    public static void deleteCarport(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from Carport WHERE Carport.orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete order from database");
        }
    }


    public static void deleteShed(int orderID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "DELETE from Shed WHERE Shed.orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not delete shed from database");
        }
    }


    public static int createBom(BillOfMaterials billOfMaterials, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Bom (orderID, materialID, description, quantity, price) VALUES (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, billOfMaterials.getOrderID());
                ps.setInt(2, billOfMaterials.getMaterial().getMaterialID());
                ps.setString(3, billOfMaterials.getDescription());
                ps.setInt(4, billOfMaterials.getQuantity());
                ps.setDouble(5, billOfMaterials.getPrice());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert bom into database");
        }
    }

    public static Map<Integer, Material> readMaterials(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Map<Integer, Material> materialList = new HashMap<>();

        String sql = "SELECT * FROM Material inner join MaterialType on Material.type = MaterialType.typeID";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialID = rs.getInt("materialID");
                    String description = rs.getString("description");
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    double priceperunit = rs.getDouble("priceperunit");
                    int type = rs.getInt("type");
                    String typename = rs.getString("name");

                    materialList.put(materialID, new Material(materialID, description, length, unit, priceperunit, type, typename));
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return materialList;
    }

    public static int createMaterial(Material material, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "INSERT INTO carport.Material (description, length, unit, priceperunit, type) VALUES (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, material.getDescription());
                ps.setInt(2, material.getLength());
                ps.setString(3, material.getUnit());
                ps.setDouble(4, material.getPricePerUnit());
                ps.setInt(5, material.getType());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert material into database");
        }
    }

    public static void updateStatus(Order order, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Order SET `Order`.statusID = ? WHERE orderID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getStatusID());
                ps.setInt(2, order.getOrderID());
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public static Material readMaterial(int materialID, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Material material = null;
        String sql = "SELECT * FROM Material inner join MaterialType on Material.type = MaterialType.typeID WHERE materialID = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String description = rs.getString("description");
                    int length = rs.getInt("length");
                    String unit = rs.getString("unit");
                    double priceperunit = rs.getDouble("priceperunit");
                    int type = rs.getInt("type");
                    String typename = rs.getString("name");

                    material = new Material(materialID, description, length, unit, priceperunit, type, typename);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not read data from database");
        }
        return material;
    }

    public static void updateMatDescription(Material material, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Material SET description = ? WHERE materialID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, material.getDescription());
                ps.setInt(2, material.getMaterialID());

                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void updateMatLength(Material material, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Material SET length = ? WHERE materialID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, material.getLength());
                ps.setInt(2, material.getMaterialID());

                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void updateMatUnit(Material material, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Material SET unit = ? WHERE materialID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, material.getUnit());
                ps.setInt(2, material.getMaterialID());

                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void updateMatPriceperunit(Material material, ConnectionPool connectionPool) throws SQLException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE carport.Material SET priceperunit = ? WHERE materialID = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDouble(1, material.getPricePerUnit());
                ps.setInt(2, material.getMaterialID());

                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

