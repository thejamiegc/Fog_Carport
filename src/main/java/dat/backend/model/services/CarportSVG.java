package dat.backend.model.services;

public class CarportSVG {


    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {


        return new SVG(x, y, height, width, viewbox);
    }

    // DETTE ER SPÆR
    public static SVG addRafters(SVG svg) {

        for (int i = 0; i < 800; i +=55 )
        {
            svg.addRect(i, 0, 600.0, 4.5);
        }
        return svg;
    }
}