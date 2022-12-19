package dat.backend.model.services;

import dat.backend.model.entities.Order;

public class CarportSVG {
    private static int startCarportX = 60;
    private static int startCarportY = 0;
    private static int endCarportY = 600;

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG makeSVGTop(Order order, SVG carportDrawTop) {
        carportDrawTop = CarportSVG.addRaftersTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.addBeamsOuterTop(order,carportDrawTop);
        carportDrawTop = CarportSVG.addBeamsInnerTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.addPolesTop(order,carportDrawTop);
        carportDrawTop = CarportSVG.makeSVGLines(order, carportDrawTop);
        carportDrawTop = CarportSVG.addShed(order, carportDrawTop);
        return carportDrawTop;
    }

    public static SVG makeSVGLines(Order order, SVG svg) {
        //left outer (length of rafter)
        svg.addLine(1, 0, 1, endCarportY,1,endCarportY/2,order.getCarport().getWidth());

        //left inner (length between poles)
        svg.addLine(30, 0 + 40, 30, endCarportY - 40,30,endCarportY/2,order.getCarport().getWidth()-75);

        //bottom
        svg.addLine(startCarportX, 650, order.getCarport().getLength() + startCarportX, 650,(order.getCarport().getLength()+startCarportX)/2,650,order.getCarport().getLength());

        //dashed lines /cross
        svg.addDashedLine(80, 50, 520,  565);
        svg.addDashedLine(80, 565, 520, 50);
        return svg;
    }

    public static SVG addShed(Order order, SVG svg) {
        svg.addRect(400, 400, 100, 100);
        return svg;
    }


    // DETTE ER SPÆR
    public static SVG addRaftersTop(Order order, SVG svg) {
        for (int i = 0; i < order.getBillOfMaterialsList().get(10).getQuantity(); i++) {
            if (i * 55 < order.getCarport().getLength()) {
                svg.addRect((i * 55) + startCarportX, startCarportY, 600.0, 4.5);
            } else {
                svg.addRect(order.getCarport().getLength() - 4, startCarportY, 600.0, 4.5);
            }
        }
        return svg;
    }

    // DETTE ER REMME
    public static SVG addBeamsOuterTop(Order order, SVG svg) {
        svg.addRect(startCarportX, startCarportY, 4.5, order.getCarport().getLength());
        svg.addRect(startCarportX, endCarportY, 4.5, order.getCarport().getLength());
        return svg;
    }

    public static SVG addBeamsInnerTop(Order order, SVG svg) {
        svg.addRect(startCarportX, startCarportY + 40, 4.5, order.getCarport().getLength());
        svg.addRect(startCarportX, endCarportY - 40, 4.5, order.getCarport().getLength());
        return svg;
    }

    // DETTE ER STOLPER
    public static SVG addPolesTop(Order order, SVG svg) {
        double height = 9.7;
        double width = 9.7;

        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect((100 + i * 250) + startCarportX, startCarportY + 40, height, width);
            } else {
                svg.addRect(order.getCarport().getLength() - 10, startCarportY + 40, height, width);
            }
        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect((100 + i * 250) + startCarportX, endCarportY - 45, height, width);
            } else {
                svg.addRect(order.getCarport().getLength() - 10, endCarportY - 45, height, height);
            }
        }
        return svg;
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