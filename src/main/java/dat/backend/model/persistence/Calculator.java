package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;

public class Calculator {

    //DETTE ER STOLPER
    public static Material calculatePoles(Carport carport) {
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
        Material tmpMaterial = new Material("",300,quantity,"stk","",49.95,"Pole",1);
        return tmpMaterial;
    }
    //DETTE ER SPÆR
    public static Material calculateRafters(Carport carport) {
        int i = 0;
        int quantity = 0;

        while (i <= carport.getLength()) {
            quantity++;
            i += 55;
        }
        Material tmpMaterial = new Material("",carport.getWidth(),quantity,"stk","",77.95, "Rafter",2);
        return tmpMaterial;
    }

    //DETTE ER REMME
    public static Material calculateBeams(Carport carport) {
        Material tmpMaterial = new Material("",carport.getLength(),2, "stk","",77.95,"Beam",3);
        return tmpMaterial;
    }


}
