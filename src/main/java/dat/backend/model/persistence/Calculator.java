package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.Shed;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.Map;

public class Calculator {

    //DETTE ER STOLPER
    public static double calculatePoles(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
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
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Stolper nedgraves 90 cm i jord", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //DETTE ER SPÆR
    public static double calculateRafters(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(10);
        int i = 0;
        int quantity = 1;

        while (i < order.getCarport().getLength()) {
            quantity++;
            i += 55;
        }
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Spær monteres på rem", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //DETTE ER REMME
    public static double calculateOuterBeams(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(8);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Remme i siderne, sadles ned i stolper", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateInnerBeams(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(8);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Remme i siderne, sadles ned i stolper", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //ende stern under
    public static double calculateEndSternUnder(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(1);
        int quantity = 4;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Understernbrædder til for og bag ende", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //side stern under
    public static double calculateSideSternUnder(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(2);
        int quantity = 4;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Understernbrædder til side", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //ende stern over
    public static double calculateEndSternOver(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(3);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Oversternbrædder til forenden", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //side stern over
    public static double calculateSideSternOver(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(4);
        int quantity = 4;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Oversternbrædder til side", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateSideWaterStern(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(13);
        int quantity = 4;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "vandbrædt på stern i sider", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateEndWaterStern(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(14);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "vandbrædt på stern i forenden", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calulateAllStern(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        double price = 0;
        price += calculateEndSternUnder(order, materialList, connectionPool);
        price += calculateEndSternOver(order, materialList, connectionPool);
        price += calculateEndWaterStern(order, materialList, connectionPool);
        price += calculateSideSternUnder(order, materialList, connectionPool);
        price += calculateSideSternOver(order, materialList, connectionPool);
        price += calculateSideWaterStern(order, materialList, connectionPool);
        return price;
    }


    // SKRUER OG BESLAG

    //SKRUER
    public static double calculatePlastmoScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(17);
        int quantity = 3;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Skruer til tagplader", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculate60mmScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(21);
        int quantity = 1;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Til montering af stern og vandbrædt", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculate50mmFittingScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(22);
        int quantity = 3;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Til montering af universalbeslag og hulbånd", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculate70mmScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(25);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering yderste beklædning", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculate50mmScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(26);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering inderste beklædning", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateAllScrews(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        double price = 0;
        price += calculatePlastmoScrews(order, materialList, connectionPool);
        price += calculate60mmScrews(order, materialList, connectionPool);
        price += calculate50mmFittingScrews(order, materialList, connectionPool);
        price += calculate70mmScrews(order, materialList, connectionPool);
        price += calculate50mmScrews(order, materialList, connectionPool);
        return price;
    }

    public static double calculateFittingRight(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(19);
        int quantity = 15;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering af spær på rem højre", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateFittingLeft(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(20);
        int quantity = 15;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering af spær på rem venstre", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateFittings(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        double price = 0;
        price += calculateFittingRight(order, materialList, connectionPool);
        price += calculateFittingLeft(order, materialList, connectionPool);
        return price;
    }


    // Hulbånd
    public static double calculateTape(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(18);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Vindkryds på spær", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // Bræddebolt
    public static double calculateBolt(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(23);
        int quantity = 18;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering af rem på stolper", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // Firkantsskive
    public static double calculateSquareDisc(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(24);
        int quantity = 12;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering af rem på stolper", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    public static double calculateOtherMaterials(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        double price = 0;
        price += calculateTape(order, materialList, connectionPool);
        price += calculateBolt(order, materialList, connectionPool);
        price += calculateSquareDisc(order, materialList, connectionPool);
        return price;
    }

    public static double calculateRoof(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(15);
        int quantity = 6;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Tagplader, monteres på spær", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }


    public static void calculateAllBom(Order order, Shed shed, ConnectionPool connectionPool) throws SQLException, DatabaseException {
        double totalprice = 0;

        Map<Integer, Material> materialList = OrderFacade.readMaterials(connectionPool);
        totalprice += calculatePoles(order, materialList, connectionPool);
        totalprice += calculateRafters(order, materialList, connectionPool);
        totalprice += calculateOuterBeams(order, materialList, connectionPool);
        totalprice += calculateInnerBeams(order, materialList, connectionPool);
        totalprice += calculateAllScrews(order, materialList, connectionPool);
        totalprice += calculateFittings(order, materialList, connectionPool);
        totalprice += calculateOtherMaterials(order, materialList, connectionPool);
        totalprice += calculateRoof(order, materialList, connectionPool);
        totalprice += calulateAllStern(order, materialList, connectionPool);

        if (shed != null) {
            totalprice += calculateShed(order, materialList, connectionPool);
        }
        order.setPrice(totalprice);
        OrderFacade.updateOrderPrice(order, connectionPool);
    }


    // ER TIL SKUR
    public static double calculateShed(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        double price = 0;
        price += calculateAngleFitting(order, materialList, connectionPool);
        price += calculateHandle(order, materialList, connectionPool);
        price += calculateHinge(order, materialList, connectionPool);
        price += calculateZ(order, materialList, connectionPool);
        price += calculateGable(order, materialList, connectionPool);
        price += calculateSideRaftering(order, materialList, connectionPool);
        price += calculateSidePlating(order, materialList, connectionPool);
        return price;
    }

    // Vinkelbeslag
    public static double calculateAngleFitting(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(29);
        int quantity = 32;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Montering af løsholter i skur", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // Stalddørsgreb
    public static double calculateHandle(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(27);
        int quantity = 1;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Til lås på dør til skur", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // Hængsel
    public static double calculateHinge(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(28);
        int quantity = 2;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Til skurdør", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //lægte til dør
    public static double calculateZ(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(5);
        int quantity = 1;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "Til z på bagside af dør", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    //reglarer
    public static double calculateSideRaftering(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(7);
        int quantity = 4;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "løsholter til skur side", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // gavle
    public static double calculateGable(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(6);
        int quantity = 12;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "løsholter til skur gavle", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }

    // beklædning
    public static double calculateSidePlating(Order order, Map<Integer, Material> materialList, ConnectionPool connectionPool) throws DatabaseException {
        Material tmpmaterial = materialList.get(12);
        int quantity = 200;
        double price = quantity * tmpmaterial.getPricePerUnit();
        BillOfMaterials billOfMaterials = new BillOfMaterials(order.getOrderID(), tmpmaterial.getMaterialID(), "løsholter til skur gavle", quantity, price, tmpmaterial);
        OrderFacade.createBom(billOfMaterials, connectionPool);
        return price;
    }
}
