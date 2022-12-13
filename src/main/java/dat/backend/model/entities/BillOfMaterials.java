package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

    private List<Material> materialsList = new ArrayList<>();
    int bomID;

    public void addMaterialToList(Material material){
        materialsList.add(material);
    }

    public List<Material> getMaterialsList() {
        return materialsList;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (Material material :materialsList) {
            totalPrice += material.totalPrice;
            
        }
        return totalPrice;
    }

    public int getBomID() {
        return bomID;
    }
}
