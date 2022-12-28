package dat.backend.model.services;

public class SVG {

    private int x;
    private int y;
    private int height;
    private int width;
    private String viewbox;
    private StringBuilder svgString = new StringBuilder();

    private final static String HEADERTEMPLATE =
            "<svg x=\"%d\" y=\"%d\" height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";

    private final static String RECTTEMPLATE =
            "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill-opacity: 0\" />";

    private final static String RECTSHEDTEMPLATE =
            "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke-width:4; stroke:#000000; fill-opacity: 0\" />";

    private final static String LINETEMPLATE =
            "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; stroke-width:2;\" />";

    private final static String ARROWLINETEMPLATE =
            "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; stroke-width:2; marker-start: url(#beginArrow); marker-end: url(#endArrow);\" />";

    private final static String DASHEDLINETEMPLATE =
            "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; stroke-width:2\" stroke-dasharray=\"4\"/>";

    private final static String TEXTTEMPLATESIDE =
            "<text x=\"%d\" y=\"%d\" fill=\"black\" transform=\"translate() rotate(-90)\">";

    private final static String TEXTTEMPLATEBOTTOM =
            "<text x=\"%d\" y=\"%d\" fill=\"black\">";

    private final static String TEXTTEMPLATEEND = "</text>";


    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";

    public SVG(int x, int y, int height, int width, String viewbox) {
        svgString.append(String.format(HEADERTEMPLATE, x, y, height, width, viewbox));
        svgString.append(ARROWHEADSTEMPLATE);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.viewbox = viewbox;
    }

    public void addRect(int x, int y, double height, double width) {
        svgString.append(String.format(RECTTEMPLATE, x, y, height, width));
    }

    public void addRectShed(int x, int y, double height, double width) {
        svgString.append(String.format(RECTSHEDTEMPLATE, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        svgString.append(String.format(LINETEMPLATE, x1, y1, x2, y2));
    }

    public void addArrowLine(int x1, int y1, int x2, int y2) {
        svgString.append(String.format(ARROWLINETEMPLATE, x1, y1, x2, y2));
    }

    public void addDashedLine(int x1, int y1, int x2, int y2) {
        svgString.append(String.format(DASHEDLINETEMPLATE, x1, y1, x2, y2));
    }

    public void addTextSide(int x, int y, String text) {
        svgString.append(String.format(TEXTTEMPLATESIDE, x, y, text));
        svgString.append(String.format(text));
        svgString.append(String.format(TEXTTEMPLATEEND));
    }

    public void addTextBottom(int x, int y, String text) {
        svgString.append(String.format(TEXTTEMPLATEBOTTOM, x, y, text));
        svgString.append(String.format(text));
        svgString.append(String.format(TEXTTEMPLATEEND));
    }

    public void addInnerSvg(SVG innerSVGDrawing) {
        svgString.append(innerSVGDrawing);
    }

    @Override
    public String toString() {
        return svgString + "</svg>";
    }
}