package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Shed;
import dat.backend.model.exceptions.DatabaseException;

import java.util.Map;

public class CarportFacade {

    public static int createCarport(Carport carport, ConnectionPool connectionPool) throws DatabaseException {
        return CarportMapper.createCarport(carport, connectionPool);
    }

    public static Map<Integer, Carport> getCarportMap(ConnectionPool connectionPool) throws DatabaseException {
        return CarportMapper.getCarportMap(connectionPool);
    }

    public static void deleteCarport(int carportID, ConnectionPool connectionPool) throws DatabaseException {
        CarportMapper.deleteCarport(carportID, connectionPool);
    }

    public static void updateOrderID(int orderID, int carportID, ConnectionPool connectionPool) throws DatabaseException {
        CarportMapper.updateOrderID(orderID, carportID, connectionPool);
    }

    public static int createShed(Shed shed, ConnectionPool connectionPool) throws DatabaseException {
        return CarportMapper.createShed(shed, connectionPool);
    }

    public static void updateShedID(int orderID, Shed shed, ConnectionPool connectionPool) throws DatabaseException {
        CarportMapper.updateShedID(orderID, shed, connectionPool);
    }
}