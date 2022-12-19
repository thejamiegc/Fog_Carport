package dat.backend.model.services;

import dat.backend.model.entities.Order;

public class CarportSVG {

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    // DETTE ER SPÆR
    public static SVG addRaftersTop(Order order, SVG svg) {

        for (int i = 0; i < order.getBillOfMaterialsList().get(10).getQuantity(); i++) {
            if (i * 55 < order.getCarport().getLength()) {
                svg.addRect(i * 55, 0, 600.0, 4.5);
            } else {
                svg.addRect(order.getCarport().getLength() - 4, 0, 600.0, 4.5);
            }
        }
        return svg;
    }

    // DETTE ER REMME
    public static SVG addBeamsTop(Order order, SVG svg) {
        svg.addRect(0, 0, 4.5, order.getCarport().getLength());
        svg.addRect(0, 600, 4.5, order.getCarport().getLength());
        return svg;
    }

    // DETTE ER STOLPER
    public static SVG addPolesTop(Order order, SVG svg) {
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect(100 + i * 250, 0, 9.7, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength() - 10, 0, 9.7, 9.7);
            }
        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect(100 + i * 250, 600 - 5, 9.7, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength() - 10, 600 - 5, 9.7, 9.7);
            }
        }
        return svg;
    }

    public static SVG makeSVGTop(Order order, SVG carportDrawTop) {
        carportDrawTop = CarportSVG.addRaftersTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.addBeamsTop(order,carportDrawTop);
        carportDrawTop = CarportSVG.addPolesTop(order,carportDrawTop);
        return carportDrawTop;
    }

    //side drawing
    public static SVG makeSVGSide(Order order, SVG carportDrawSide) {
        carportDrawSide = CarportSVG.addBeamsSide(order, carportDrawSide);
        carportDrawSide = CarportSVG.addPolesSide(order, carportDrawSide);
        return carportDrawSide;
    }

    private static SVG addBeamsSide(Order order, SVG svg) {
        svg.addRect(0, 0, 9.5, order.getCarport().getLength());
        return svg;
    }

    private static SVG addPolesSide(Order order, SVG svg) {
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect(100 + i * 250, 0, 300, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength(), 0, 300, 9.7);
            }
        }
        return svg;
    }
}