package PresentationLayer;

import FunctionLayer.Shed;
import java.text.DecimalFormat;

public class SVGBuilderTop {

    private StringBuilder sb = new StringBuilder();
    private final int roofType;
    private final int length;
    private final int width;
    private final Shed shed;
    private final int material; //will be used later
    private final int firstX = 80; //if below 45 then the text for rafterspacers will be messed up
    private final int firstY = 90;
    private final int roofOverhang = 35;
    private final int firstXRoofOverhang = firstX + roofOverhang;
    final double rafter = 4.5;
    private double spacing;

    public SVGBuilderTop(int roofType, int length, int width, Shed shed, int material) {
        this.roofType = roofType;
        this.length = length;
        this.width = width;
        this.shed = shed;
        this.material = material;
    }

    private int getMaxY(SVGBuilderTop svg) {
        return svg.length + firstY;
    }

    private int getMaxX(SVGBuilderTop svg) {
        return svg.width + firstX;
    }

    // x er width, y er length
    public String buildSvgTopView(SVGBuilderTop svg) {
        int viewboxWidth = svg.width + firstX + 150;
        int viewboxLength = svg.length + firstY + 150;
        sb.append("<svg width=\"750\" height=\"750\" viewBox=\"0 0 ").append(viewboxWidth).append(" ").append(viewboxLength).append("\">\n");
        buildRectangle(svg);
        buildYArrow(svg);
        buildXArrow(svg);
        buildRafter(svg);
        buildRem(svg);
        createShed(svg);
        createPosts(svg);
        sb.append("\n</svg>");
        String res = sb.toString();
        return res;
    }

    private void buildRectangle(SVGBuilderTop svg) {
        sb.append(" <rect x=\"" + firstX + "\" y=\"" + firstY + "\" width=\"" + svg.width + "\""
                + "height=\"" + svg.length + "\""
                + "style=\"fill:white;stroke:black;stroke-width:3;\"/>\n");
    }

    //The line going vertical
    private void buildYArrow(SVGBuilderTop svg) {
        int x = svg.width + firstX + 30; //it has to be a bit more to the right than the house to be visible.
        int y2 = svg.length + firstY;
        sb.append("<line x1=\"" + x + "\" y1=\"" + firstY + "\" x2=\"" + x + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
        int textX = x + 10;
        int textY = svg.length / 2 + firstY;
        sb.append("<text x=\"" + textX + "\" y=\"" + textY + "\" font-family=\"Verdana\" font-size=\"15\">\n"
                + " " + svg.length + "cm\n </text>");
    }

    private void buildXArrow(SVGBuilderTop svg) {
        int x2 = svg.width + firstX;
        int y = svg.length + firstY + 30; // it has to be a bit lower than the house to be visible.
        sb.append("<line x1=\"" + firstX + "\" y1=\"" + y + "\" x2=\"" + x2 + "\" y2=\"" + y
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
        int textX = x2 / 2 - 10; //in the middle, and -10 more for the text to be centered
        int textY = y + 15; //a bit underneath the line
        sb.append("<text x=\"" + textX + "\" y=\"" + textY + "\" font-family=\"Verdana\" font-size=\"15\">\n" + svg.width + "cm\n </text>");
    }

    private void buildRafter(SVGBuilderTop svg) { //spær
        final int y2 = svg.length + firstY;
        double x = firstX + rafter; //this is the leftmost rafter which has to be placed before any others
        double xe = svg.width + firstX - rafter; //this is the rightmost rafter which has to be placed before any others
        spacing = calcSpacing(svg.width);

        sb.append("<line x1=\"" + x + "\" y1=\"" + firstY + "\" x2=\"" + x + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
        sb.append("<line x1=\"" + xe + "\" y1=\"" + firstY + "\" x2=\"" + xe + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");

        for (double i = spacing * 2 + rafter; i < svg.width - (rafter * 2); i += spacing) {
            x += spacing;
            sb.append("<line x1=\"" + x + "\" y1=\"" + firstY + "\" x2=\"" + x + "\" y2=\"" + y2
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            x += 4.5;
            sb.append("<line x1=\"" + x + "\" y1=\"" + firstY + "\" x2=\"" + x + "\" y2=\"" + y2
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");

        }
        spacingMarkers(spacing, svg);
    }

    private double calcSpacing(int width) {
        //first the number of rafters needed if the optimal spacing is used. If it is
        //a decimal number, it gets rounded up to find the amount closest to the optimal amount.
        int amountOfRafters = (int) Math.ceil((width - (rafter * 2)) / (60 + rafter));
        //since the amountofrafters
        return ((width - rafter) - amountOfRafters * rafter) / amountOfRafters;
    }

    private void spacingMarkers(double spacing, SVGBuilderTop svg) {
        for (double i = 0 + spacing; i < svg.width; i += spacing + rafter) {
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            int textPlacementY = firstY - 20;
            double textPlacement = i + firstX - 45;
            sb.append("<text x=\"" + textPlacement + "\" y=\"" + textPlacementY + "\" font-family=\"Verdana\" font-size=\"10\">\n"
                    + " " + numberFormat.format(spacing) + "cm\n </text>");
        }
    }

    private void buildRem(SVGBuilderTop svg) {
        int y = firstY + roofOverhang;
        int maxY = svg.getMaxY(svg) - (roofOverhang + 5);
        //int maxX = svg.getMaxX(svg);
        int textPlacementXtop = firstX - 40;
        int textPlacementYtop = firstY + roofOverhang / 2;
        int textPlacementYbot = svg.getMaxY(svg) - roofOverhang / 2;
        int textPlacementXbot = firstX - 40;

        sb.append("<rect x=\"" + firstX + "\" y=\"" + y + "\" width=\"" + svg.width + "\" height=\"4\"/>");

        sb.append("<rect x=\"" + firstX + "\" y=\"" + maxY + "\" width=\"" + svg.width + "\" height=\"4\"/>");

        sb.append("<line x1=\"" + firstX + "\" y1=\"" + firstY + "\" x2=\"" + firstX + "\" y2=\"" + y + "\" stroke=\"#000\" stroke-width=\"2\"/> ");
        sb.append("<text x=\"" + textPlacementXtop + "\" y=\"" + textPlacementYtop + "\" font-family=\"Verdana\" font-size=\"10\"> 35cm </text>\"");
        sb.append("<text x=\"" + textPlacementXbot + "\" y=\"" + textPlacementYbot + "\" font-family=\"Verdana\" font-size=\"10\"> 35cm </text>\"");
    }

    private void createShed(SVGBuilderTop svg) {
        int innerMostX = firstX + roofOverhang;
        int y = firstY + roofOverhang;
        sb.append("<rect x=\"" + innerMostX + "\" y=\"" + y + "\" width=\"" + svg.shed.getWidth() + "\" "
                + "height=\"" + svg.shed.getLength() + "\" stroke-width= \"4\"; stroke=\"black\" fill= \"none\";/>");
    }

    private void createPosts(SVGBuilderTop svg) {
        int outerMostX = firstX + svg.getMaxX(svg) - roofOverhang;
        int innerMostX = firstX + roofOverhang;
        int middleOfY = firstY + svg.length / 2;
        int middleOfX = firstX + svg.width / 2;
        int minYPole = firstY + roofOverhang;
        int maxYPole = svg.getMaxY(svg) - roofOverhang;
        double minXPlusSpacing = firstX + spacing + rafter;
        double maxXMinusSpacing = svg.getMaxX(svg) - (spacing + rafter);

        if (svg.shed.getLength() > 100) {
            int shedWidth = svg.shed.getWidth() + firstX + roofOverhang;
            int shedLength = svg.shed.getLength() + firstY + roofOverhang;
            int middleOfShedX = firstX + roofOverhang + svg.shed.getWidth() / 2;

            sb.append("<circle cx=\"" + innerMostX + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + innerMostX + "\" cy=\"" + shedLength + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + shedWidth + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + shedWidth + "\" cy=\"" + shedLength + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + middleOfShedX + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + middleOfShedX + "\" cy=\"" + shedLength + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");

            sb.append("<circle cx=\"" + innerMostX + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + maxXMinusSpacing + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + maxXMinusSpacing + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");

            sb.append("<line stroke-dasharray=\"5, 5, 1, 5\"  x1=\"" + shedWidth + "\" y1=\"" + minYPole + "\" x2=\"" + maxXMinusSpacing + "\" y2=\"" + shedLength
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            sb.append("<line stroke-dasharray=\"5, 5, 1, 5\"  x1=\"" + maxXMinusSpacing + "\" y1=\"" + minYPole + "\" x2=\"" + shedWidth + "\" y2=\"" + shedLength
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            if (svg.width > 500) {
                sb.append("<circle cx=\"" + middleOfX + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            }
        } else { //setting up the poles markers, without a shed.
            double firstPoles = firstX + spacing + rafter;
            sb.append("<circle cx=\"" + firstPoles + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + firstPoles + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + maxXMinusSpacing + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            sb.append("<circle cx=\"" + maxXMinusSpacing + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            //creating 
            sb.append("<line stroke-dasharray=\"5, 5, 1, 5\"  x1=\"" + minXPlusSpacing + "\" y1=\"" + minYPole + "\" x2=\"" + maxXMinusSpacing + "\" y2=\"" + maxYPole
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            sb.append("<line stroke-dasharray=\"5, 5, 1, 5\"  x1=\"" + maxXMinusSpacing + "\" y1=\"" + minYPole + "\" x2=\"" + minXPlusSpacing + "\" y2=\"" + maxYPole
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            if (svg.width > 500) {
                sb.append("<circle cx=\"" + middleOfX + "\" cy=\"" + maxYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
                sb.append("<circle cx=\"" + middleOfX + "\" cy=\"" + minYPole + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            }
            if (svg.length > 500) {
                sb.append("<circle cx=\"" + firstPoles + "\" cy=\"" + middleOfY + "\" r=\"4\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"/>");
            }
        }

    }
}
