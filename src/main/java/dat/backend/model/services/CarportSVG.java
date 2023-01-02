package dat.backend.model.services;

import dat.backend.model.entities.Order;

public class CarportSVG {

    // VARIABLES
    private static int startCarportX = 100;
    private static int startCarportY = 0;
    private static int endCarportY = 600;
    private static int frontPole = 100;

    // METODE DER OPRETTER NY SVG OVERFLADE
    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    //METODE DER TEGNER TEGNER CARPORT FRA OVEN
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
    // METODE DER INDSÆTTER MÅL-TEKST TIL BREDDEN AF CARPORT TIL HØJRE PÅ TEGNING
    public static SVG makeSVGTextSide(Order order, SVG svg) {
        svg.addTextSide(10, endCarportY / 2, order.getCarport().getWidth() + "");
        svg.addTextSide(65, endCarportY / 2, order.getCarport().getWidth() - 70 + "");
        return svg;
    }
    // METODE DER INDSÆTTER MÅL-TEKST TIL LÆNGDEN AF CARPORT I BUNDEN AF TEGNING
    public static SVG makeSVGTextBottom(Order order, SVG svg) {
        svg.addTextBottom(order.getCarport().getLength() / 2 + startCarportX - 10, 670, order.getCarport().getLength() + "");
        return svg;
    }
    // INDSÆTTER FORSKELLIGE TYPER AF LINJER I TEGNING
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
    // INDSÆTTER SKUR TIL TEGNING SET FRA OVEN
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
        int poleSpace = order.getCarport().getLength()/(order.getBillOfMaterialsList().get(11).getQuantity() / 2);

        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {

                svg.addRect((frontPole + i * poleSpace) + startCarportX, startCarportY + 40, height, width);

        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
                svg.addRect((frontPole + i * poleSpace) + startCarportX, endCarportY - 45, height, width);
        }
        return svg;
    }

    // DETTE ER STOLPER MED SKUR
    public static SVG addPolesTopShed(Order order, SVG svg) {
        double height = 9.7;
        double width = 9.7;
        int poleSpace = 250;

        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (frontPole + i * poleSpace < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addRect((frontPole + i * poleSpace) + startCarportX, startCarportY + 40, height, width);
            }
        }
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (frontPole + i * poleSpace < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addRect((frontPole + i * poleSpace) + startCarportX, endCarportY - 45, height, width);
            }
        }
        int shedPoleLeftX = 55;
        int shedPoleRightX = 65;
        //venstre skur stolper
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleLeftX - order.getShed().getShedLength(), startCarportY + 40, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleLeftX - order.getShed().getShedLength(), endCarportY / 2, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleLeftX - order.getShed().getShedLength(), endCarportY - 45, height, width);
        //højre skur stolper
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleRightX, startCarportY + 40, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleRightX, endCarportY / 2, height, width);
        svg.addRect(order.getCarport().getLength() + startCarportX - shedPoleRightX, endCarportY - 45, height, width);

        return svg;
    }

    // METODE TEGNER CARPORT FRA SIDEN
    public static SVG makeSVGSide(Order order, SVG carportDrawSide) {
        carportDrawSide = CarportSVG.addBeamsSide(order, carportDrawSide);
        if(order.getShed().getShedLength()!=0){
            carportDrawSide = CarportSVG.addPolesSideShed(order, carportDrawSide);
            carportDrawSide = addLinesSideAndTextShed(order,carportDrawSide);
            carportDrawSide = CarportSVG.addShedSide(order,carportDrawSide);
        }else {
            carportDrawSide = CarportSVG.addPolesSide(order, carportDrawSide);
            carportDrawSide = CarportSVG.addLinesSideAndText(order,carportDrawSide);

        }
        return carportDrawSide;
    }
    // METODE INDSÆTTER REMME TIL SIDE TEGNING
    private static SVG addBeamsSide(Order order, SVG svg) {
        svg.addRect(startCarportX, startCarportY + 40, 9.5, order.getCarport().getLength());
        return svg;
    }
    // METODE INDSÆTTER PÆLE TIL SIDE TEGNING
    private static SVG addPolesSide(Order order, SVG svg) {
        int poleSpace = order.getCarport().getLength()/(order.getBillOfMaterialsList().get(11).getQuantity() / 2);
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
                svg.addRect((frontPole + i * poleSpace) + startCarportX, startCarportY + 40, 300, 9.7);
        }
        return svg;
    }
    // METODE INDSÆTTER PÆLE TIL SKUR I SIDE TEGNING
    private static SVG addPolesSideShed(Order order,SVG svg){
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (100 + i * 250 < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addRect((100 + i * 250) + startCarportX, startCarportY + 40, 300, 9.7);
            }
        }

        svg.addRect(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), startCarportY + 40, 300, 9.7);
        svg.addRect(order.getCarport().getLength() + startCarportX - 65, startCarportY + 40, 300, 9.7);
        return svg;
    }
    // METODE INDSÆTTER LINJER OG TEKST TIL PILE TIL SKUR I SIDE TEGNING
    private static SVG addLinesSideAndTextShed(Order order, SVG svg){
        int poleSpace = 250;
        // line length of poles aka the line on the side
        svg.addArrowLine(50, startCarportY+40, 50, 300+40);
        svg.addTextSide(10, 300 / 2, "300");

        int poleStartX = startCarportX;


        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (frontPole + i * poleSpace < order.getCarport().getLength() - order.getShed().getShedLength()) {
                svg.addArrowLine(poleStartX, 360, (frontPole + i * poleSpace) + startCarportX, 360);
                svg.addTextSide((poleStartX+(frontPole + i * poleSpace) + startCarportX)/2,390 , ((frontPole + i * poleSpace) + startCarportX)-poleStartX+"");
                poleStartX = (frontPole + i * poleSpace) + startCarportX;
            }
        }

        svg.addArrowLine(poleStartX, 360, order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), 360);
        svg.addTextSide(((poleStartX)+(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength()))/2,390 , (order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength())-(poleStartX)+"");
        poleStartX += order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength() - poleStartX;

        svg.addArrowLine(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), 360, order.getCarport().getLength() + startCarportX - 65, 360);
        svg.addTextSide(((order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength())+(order.getCarport().getLength() + startCarportX - 65))/2,390 , order.getShed().getShedLength()+"");
        poleStartX += order.getShed().getShedLength();

        svg.addArrowLine(order.getCarport().getLength() + startCarportX - 65, 360, order.getCarport().getLength() + startCarportX, 360);
        svg.addTextSide(((order.getCarport().getLength() + startCarportX - 65)+(order.getCarport().getLength() + startCarportX))/2,390 , (order.getCarport().getLength())-(poleStartX-startCarportX) +"");
        return svg;
    }

    // METODE INDSÆTTER SKUR TIL SIDE TEGNING
    public static SVG addShedSide(Order order, SVG svg) {
        svg.addRectShed(order.getCarport().getLength() + startCarportX - 55 - order.getShed().getShedLength(), startCarportY + 40, 300, order.getShed().getShedLength());
        return svg;

    }
    // METODE INDSÆTTER LINJER OG TESKT TIL PILE TIL SIDETEGNING
    private static SVG addLinesSideAndText(Order order, SVG svg){
        int poleSpace = order.getCarport().getLength()/(order.getBillOfMaterialsList().get(11).getQuantity() / 2);
        // line length of poles aka the line on the side
        svg.addArrowLine(50, startCarportY+40, 50, 300+40);
        svg.addTextSide(10, 300 / 2, "300");

        int poleStartX = startCarportX;
        for (int i = 0; i < order.getBillOfMaterialsList().get(11).getQuantity() / 2; i++) {
            if (frontPole + i * poleSpace < order.getCarport().getLength()) {
                svg.addArrowLine(poleStartX, 360, (frontPole + i * poleSpace) + startCarportX, 360);
                svg.addTextSide((poleStartX+(frontPole + i * poleSpace) + startCarportX)/2,390 , ((frontPole + i * poleSpace) + startCarportX)-poleStartX+"");
                poleStartX = (frontPole + i * poleSpace) + startCarportX;
            }
        }
        svg.addArrowLine(poleStartX, 360, order.getCarport().getLength() + startCarportX, 360);
        svg.addTextSide((poleStartX + startCarportX+order.getCarport().getLength())/2,390 , order.getCarport().getLength()-(poleStartX-startCarportX)+"");

        return svg;
    }

}