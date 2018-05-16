package PresentationLayer;

import FunctionLayer.Shed;

public class SVGBuilderSide {

    private StringBuilder sb = new StringBuilder();
    private final int roofType;
    private final int length;
    private final int width;
    private final Shed shed;
    private final int material; //will be used later
    private final int firstX = 80; //if below 45 then the text for rafterspacers will be messed up
    private final int firstY = 80;
    private final int roofOverhang = 35;
    final double rafter = 4.5;
    private double spacing;

    public SVGBuilderSide(int roofType, int length, int width, Shed shed, int material) {
        this.roofType = roofType;
        this.length = length;
        this.width = width;
        this.shed = shed;
        this.material = material;
    }

    private int getMaxY() {
        return length + firstY;
    }

    private int getMaxX() {
        return width + firstX;
    }

    public String buildSvgSideView(SVGBuilderTop svg) {
        int viewboxWidth = width + firstX + 150;
        int viewboxLength = length + firstY + 150;
        sb.append("<svg width=\"750\" height=\"750\" viewBox=\"0 0 ").append(viewboxWidth).append(" ").append(viewboxLength).append("\">\n");
        createRoof();
        sb.append("\n</svg>");
        String res = sb.toString();
        return res;
    }

    private void createRoof() {      
    sb.append("<rect x=\""+firstX+"\" y=\""+firstY+"\" width=\""+width+"\" length=\""+length+" \"");
    }

}
