package dat.backend.model.services;

import dat.backend.model.entities.Order;

public class CarportSVG {
    private static int startCarportX = 100;
    private static int startCarportY = 0;
    private static int endCarportY = 600;

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG makeSVGTop(Order order, SVG carportDrawTop) {
        carportDrawTop = CarportSVG.addRaftersTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.addBeamsOuterTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.addBeamsInnerTop(order, carportDrawTop);
        carportDrawTop = CarportSVG.makeSVGLines(order, carportDrawTop);
        carportDrawTop = CarportSVG.makeSVGTextSide(order, carportDrawTop);
        carportDrawTop = CarportSVG.makeSVGTextBottom(order, carportDrawTop);
        if (order.getShed().getShedLength() != 0) {
            carportDrawTop = CarportSVG.addShedTop(order, carportDrawTop);
            carportDrawTop = CarportSVG.addPolesTopShed(order, carportDrawTop);
        } else {
            carportDrawTop = CarportSVG.addPolesTop(order, carportDrawTop);
        }
        return carportDrawTop;
    }

    public static SVG makeSVGTextSide(Order order, SVG svg) {
        svg.addTextSide(10, endCarportY / 2, order.getCarport().getWidth() + "");
        svg.addTextSide(65, endCarportY / 2, order.getCarport().getWidth() - 70 + "");
        return svg;
    }

    public static SVG makeSVGTextBottom(Order order, SVG svg) {
        svg.addTextBottom(order.getCarport().getLength() / 2 + startCarportX - 10, 670, order.getCarport().getLength() + "");
        return svg;
    }

    public static SVG makeSVGLines(Order order, SVG svg) {
        //Arrow line left outer
        svg.addArrowLine(40, startCarportY, 40, endCarportY);

        //Arrow line left inner (length between poles)
        svg.addArrowLine(60, 0 + 40, 60, endCarportY - 40);

        //bottom
        svg.addArrowLine(startCarportX, 640, order.getCarport().getLength() + startCarportX, 640);

        //dashed lines /cross
        svg.addDashedLine(startCarportX + 55, startCarportY + 40, order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), endCarportY - 40);
        svg.addDashedLine(startCarportX + 55, endCarportY - 40, order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), startCarportY + 40);


        return svg;
    }

    public static SVG addShedTop(Order order, SVG svg) {
        svg.addRectShed(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), startCarportY + 40, endCarportY - 80 + 5, order.getShed().getShedLength());
        return svg;

    }

    // DETTE ER SPÆR
    public static SVG addRaftersTop(Order order, SVG svg) {
        for (int i = 0; i < order.getBillOfMaterialsList().get(10).getQuantity(); i++) {
            if (i * 55 < order.getCarport().getLength()) {
                svg.addRect((i * 55) + startCarportX, startCarportY, 600.0, 4.5);
            } else {
                svg.addRect(order.getCarport().getLength() - 4 + startCarportX, startCarportY, 600.0, 4.5);
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

    // DETTE ER STOLPER MED SKUR
    public static SVG addPolesTopShed(Order order, SVG svg) {
        double height = 9.7;
        double width = 9.7;

        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addRect((100 + i * 250) + startCarportX, startCarportY + 40, height, width);
            }
        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addRect((100 + i * 250) + startCarportX, endCarportY - 45, height, width);
            }
        }
        //venstre skur stolper
        svg.addRect(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), startCarportY + 40, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), endCarportY / 2, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), endCarportY - 45, height, width);
        //højre skur stolper
        svg.addRect(order.getCarport().getLength() + startCarportX - 65, startCarportY + 40, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - 65, endCarportY / 2, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - 65, endCarportY - 45, height, width);

        return svg;
    }

    //side drawing
    public static SVG makeSVGSide(Order order, SVG carportDrawSide) {
        carportDrawSide = CarportSVG.addBeamsSide(order, carportDrawSide);
        carportDrawSide = CarportSVG.addPolesSide(order, carportDrawSide);
        return carportDrawSide;
    }

    private static SVG addBeamsSide(Order order, SVG svg) {
        svg.addRect(startCarportX, startCarportY + 40, 9.5, order.getCarport().getLength());
        return svg;
    }

    private static SVG addPolesSide(Order order, SVG svg) {
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength()) {
                svg.addRect((100 + i * 250) + startCarportX, startCarportY + 40, 300, 9.7);
            } else {
                svg.addRect(order.getCarport().getLength() - 10, startCarportY + 40, 300, 9.7);
            }
        }
        return svg;
    }
}