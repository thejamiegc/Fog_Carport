package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;
import java.util.Map;

public class OrderFacade
{

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException {
       return OrderMapper.createOrder(order,connectionPool);
    }

    public static List<Order> readOrdersAsCustomer(int userID, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readOrdersAsCustomer(userID,connectionPool);
    }

    public static List<Order> readRequestAsAdmin(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readRequestAsAdmin(connectionPool);
    }
    public static List<Order> readOrdersAsAdmin(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readOrdersAsAdmin(connectionPool);
    }

    public static void deleteOrder(int orderID,ConnectionPool connectionPool)throws DatabaseException{
        OrderMapper.deleteOrder(orderID,connectionPool);
    }

    public static int createBom(BillOfMaterials billOfMaterials, ConnectionPool connectionPool) throws DatabaseException{
        return OrderMapper.createBom(billOfMaterials,connectionPool);
    }

    public static int createMaterial(Material material, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.createMaterial(material, bomID, connectionPool);
    }

    public static Order readDataFromAnOrder(int orderID,ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readDataFromAnOrder(orderID, connectionPool);
    }

    public static Map<Integer,Material> readMaterials(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readMaterials(connectionPool);
    }
}
