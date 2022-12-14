package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Order;
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
        } else if (squareMeter >= 46 && squareMeter <= 55) {
            quantity = 10;
        } else {
            quantity = 12;
        }

        //ADD QUANTITY FROM BOM ???
        //BillOfMaterials bom = new BillOfMaterials(bomID, order.getOrderID(), material.getMaterialID(), "", quantity, material.getTotalPrice());
        Material tmpMaterial = new Material("", 300, "stk", 49.95, 1);
        OrderFacade.createMaterial(tmpMaterial, bomID, connectionPool);
    }


    //DETTE ER SPÆR
    public static void calculateRafters(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        int i = 0;
        int quantity = 1;

        while (i < carport.getLength()) {
            quantity++;
            i += 55;
        }

        Material tmpMaterial = new Material("", 300, "stk", 49.95, 1);
        OrderFacade.createMaterial(tmpMaterial, bomID, connectionPool);
    }

    //DETTE ER REMME
    public static void calculateBeams(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpMaterial = new Material("", 300, "stk", 49.95, 1);
        OrderFacade.createMaterial(tmpMaterial, bomID, connectionPool);
    }

    public static void calculateAll(Carport carport, int bomID, ConnectionPool connectionPool) throws DatabaseException {
        calculatePoles(carport, bomID, connectionPool);
        calculateRafters(carport, bomID, connectionPool);
        calculateBeams(carport, bomID, connectionPool);
    }
}
