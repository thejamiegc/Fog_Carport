package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class CarportFacade {

    public static int createCarport(Carport carport, ConnectionPool connectionPool) throws DatabaseException {
       return CarportMapper.createCarport(carport, connectionPool);
    }

    public static List<Carport> readCarport(List<Order> orderList, ConnectionPool connectionPool) throws DatabaseException {
        return CarportMapper.readCarport(orderList,connectionPool);
    }
}
