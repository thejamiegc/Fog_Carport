package dat.backend.model.services;

import dat.backend.model.entities.Order;

public class CarportSVG {


    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    // DETTE ER SPÆR
    public static SVG addRafters(Order order, SVG svg) {

        for (int i = 0; i < order.getBillOfMaterialsList().get(10).getQuantity(); i ++ )
        { if (i*55 < order.getCarport().getLength()) {
            svg.addRect(i * 55, 0, 600.0, 4.5);
        } else {
            svg.addRect(order.getCarport().getLength()-4, 0, 600.0, 4.5);
        }
        }
        return svg;
    }
    // DETTE ER REMME
    public static SVG addBeams(Order order, SVG svg){
        svg.addRect(0,0,4.5,order.getCarport().getLength());
        svg.addRect(0,600,4.5,order.getCarport().getLength());
        return svg;
    }
    // DETTE ER STOLPER
    // RET IGENNEM
    public static SVG addPoles(Order order, SVG svg){
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity()/2; i++){
            if (100+i*250 < order.getCarport().getLength()) {
                svg.addRect(100 + i * 250, 0, 9.7, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength()-10,0,9.7,9.7);
            }
        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity()/2; i++){
            if (100+i*250 < order.getCarport().getLength()) {
                svg.addRect(100 + i * 250, 600-5, 9.7, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength()-10,600-5,9.7,9.7);
            }
        }
        return svg;
    }
}