package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;
import java.util.Map;

public class Calculator {


    //DETTE ER STOLPER
    public static void calculatePoles(Order order, Map<Integer,Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(11);
        int quantity = 0;
        int squareMeter = order.getCarport().getCarportSquareMeter();

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
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Stolper nedgraves 90 cm i jord",quantity,price,tmpmaterial);
        OrderFacade.createBom(billOfMaterials,connectionPool);
    }


    //DETTE ER SPÆR
    public static void calculateRafters(Order order, Map<Integer,Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(10);
        int i = 0;
        int quantity = 1;

        while (i < order.getCarport().getLength()) {
            quantity++;
            i += 55;
        }
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Spær monteres på rem",quantity,price,tmpmaterial);
        OrderFacade.createBom(billOfMaterials,connectionPool);
    }

    //DETTE ER REMME
    public static void calculateBeams(Order order, Map<Integer,Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(8);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Remme i siderne, sadles ned i stolper",quantity,price,tmpmaterial);
        OrderFacade.createBom(billOfMaterials,connectionPool);
    }

    public static void calculateAll(Order order, ConnectionPool connectionPool) throws DatabaseException {
        Map<Integer,Material> materialList = OrderFacade.readMaterials(connectionPool);
        calculatePoles(order, materialList, connectionPool);
        calculateRafters(order, materialList, connectionPool);
        calculateBeams(order, materialList, connectionPool);
    }
}
