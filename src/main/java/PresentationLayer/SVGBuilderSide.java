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
    private final int xUnderRoof = firstX + roofOverhang;
    final double rafter = 4.5;
    final int roofHeight = 10;
    private final int height = 240 - roofHeight;
    final int yUnderRoof = firstX + roofHeight;
    private double spacing;
    private int poleWidth = 7;

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

    public String buildSvgSideView(SVGBuilderSide svg) {
        int viewboxWidth = width + firstX + 150;
        int viewboxLength = length + firstY + 150;
        sb.append("<svg width=\"750\" height=\"750\" viewBox=\"0 0 ").append(viewboxWidth).append(" ").append(viewboxLength).append("\">\n");
        createRoof(svg);
        sb.append("\n</svg>");
        String res = sb.toString();
        return res;
    }

    private void createRoof(SVGBuilderSide svg) {
        int finalPole = firstX + width - roofOverhang;
        int middlePoleX = firstX + roofOverhang/2 + length / 2;
        sb.append("<rect id=\"svg_1\" height=\"" + roofHeight + "\" width=\"" + width + "\" y=\"" + firstY + ""
                + "\" x=\"" + firstX + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
        if (svg.shed.getLength() > 100) {
            int middleShedPole = firstX + roofOverhang + svg.shed.getWidth() / 2;
            int outerPoleOfShed = xUnderRoof + svg.shed.getWidth() - 7;
            int middleShedpole = firstX + roofOverhang + svg.shed.getLength() / 2;
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + svg.shed.getWidth() + "\" y=\"" + yUnderRoof + "\" x=\"" + xUnderRoof + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + xUnderRoof + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + outerPoleOfShed + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + finalPole + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + finalPole + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + middleShedPole + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
        } else {

            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + xUnderRoof + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                    + "\" x=\"" + finalPole + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            if (svg.width > 500) {
                sb.append("<rect id=\"svg_2\" height=\"" + height + "\" width=\"" + poleWidth + "\" y=\"" + yUnderRoof + ""
                        + "\" x=\"" + middlePoleX + "\" stroke-width=\"1.5\" stroke=\"#000\" fill=\"#fff\"/>\n");
            }
        }
    }
}
