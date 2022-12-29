package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Map<Integer, Material> materialList;
    Material tmpmaterial = new Material(11,"Stolper nedgraves 90 cm i jord",1000,"stk",20,1,"pizza");
    Carport tmpcarport = new Carport(400,800,"fladt");
    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculatePoles() {
        int quantity = 0;


        int squareMeter = tmpcarport.getCarportSquareMeter();

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

        Assertions.assertEquals(6,quantity);

    }

    @Test
    void calculateRafters() {

        int i = 0;
        int quantity = 1;

        while (i < tmpcarport.getLength()) {
            quantity++;
            i += 55;
        }
        Assertions.assertEquals(9,quantity);

    }@Test
    void calculateRoof() {

        int quantity = 6; // mængden skal være på 6 hvis 46.8 = kvadratmeter
        int squareMeter = tmpcarport.getCarportSquareMeter();

        if (squareMeter <= 25) {
            quantity = 1; //1 tagplade har længde = 600
        } else if (squareMeter >= 26 && squareMeter <= 35) {
            quantity = 2;
        } else if (squareMeter >= 36 && squareMeter <= 45) {
            quantity = 4;
        } else if (squareMeter >= 46 && squareMeter <= 55) {
            quantity = 6;
        } else {
            quantity = 8;
        }
        Assertions.assertEquals(2,quantity);

    }
}