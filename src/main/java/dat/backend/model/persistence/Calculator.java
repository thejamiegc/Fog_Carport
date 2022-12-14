package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;

public class Calculator {

    //DETTE ER STOLPER
    public static void calculatePoles(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        int quantity = 0;
        int squareMeter = carport.getCarportSquareMeter();

        if (squareMeter <= 25) {
            quantity = 4;
        } else if (squareMeter >= 26 && squareMeter <= 35) {
            quantity = 6;
        } else if (squareMeter >= 36 && squareMeter <= 45) {
            quantity = 8;
        } else {
            quantity = 10;
        }
        Material tmpMaterial = new Material("",300,quantity,"stk","",49.95,"Pole",2);
        OrderFacade.createMaterial(tmpMaterial,bomID, connectionPool);
    }
    //DETTE ER SPÆR
    public static void calculateRafters(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        int i = 0;
        int quantity = 1;

        while (i < carport.getLength()) {
            quantity++;
            i += 55;
        }
        Material tmpMaterial = new Material("",carport.getWidth(),quantity,"stk","",77.95, "Rafter",3);
        OrderFacade.createMaterial(tmpMaterial,bomID, connectionPool);
    }

    //DETTE ER REMME
    public static void calculateBeams(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpMaterial = new Material("",carport.getLength(),2, "stk","",77.95,"Beam",1);
        OrderFacade.createMaterial(tmpMaterial,bomID, connectionPool);
    }

    public static void calculateAll(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        calculateBeams(carport, bomID, connectionPool);
        calculatePoles(carport, bomID, connectionPool);
        calculateRafters(carport, bomID, connectionPool);
    }

}
