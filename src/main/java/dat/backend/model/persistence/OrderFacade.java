package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class OrderFacade
{

    public static int createOrder(Order order, ConnectionPool connectionPool) throws DatabaseException {
       return OrderMapper.createOrder(order,connectionPool);
    }

    public static List<Order> readOrder(int userID, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readOrder(userID,connectionPool);
    }

    public static List<Order> readOrderAsAdmin(ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.readOrderAsAdmin(connectionPool);
    }
}
