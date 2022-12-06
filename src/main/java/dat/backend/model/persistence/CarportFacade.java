package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.exceptions.DatabaseException;

public class CarportFacade {

    public static void createCarport(Carport carport, ConnectionPool connectionPool) throws DatabaseException {
        CarportMapper.createCarport(carport, connectionPool);
    }
}
