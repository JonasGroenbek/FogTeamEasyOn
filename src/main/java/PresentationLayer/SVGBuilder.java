package PresentationLayer;

public class SVGBuilder {

    StringBuilder sb = new StringBuilder();
    int roofType;
    int length;
    int width;
    int lengthShed;
    int widthShed;
    int material;

    public SVGBuilder(int roofType, int length, int width, int lengthShed, int widthShed, int material) {
        this.roofType = roofType;
        this.length = length;
        this.width = width;
        this.lengthShed = lengthShed;
        this.widthShed = widthShed;
        this.material = material;
    }

    // x er width, y er length
    public String buildSvg(SVGBuilder svg) {
        int viewboxWidth = svg.width + 150;
        int viewboxLength = svg.length + 150;
        sb.append("<svg width=\"750\" height=\"750\" viewBox=\"0 0 ").append(viewboxWidth).append(" ").append(viewboxLength).append("\">\n");
        sb.append(buildRectangle(svg));
        sb.append(buildYArrow(svg));
        sb.append(buildXArrow(svg));
        buildRafter(svg);
        sb.append("\n</svg>");
        String res = sb.toString();

        return res;
    }

    private String buildRectangle(SVGBuilder svg) {
        String res = " <rect x=\"20\" y=\"20\" width=\"" + svg.width + "\""
                + "height=\"" + svg.length + "\""
                + "style=\"fill:white;stroke:black;stroke-width:3;\"/>\n";
        return res;
    }

    private String buildYArrow(SVGBuilder svg) {
        int x = svg.width + 50;
        int y2 = svg.length + 20;
        String line = "<line x1=\"" + x + "\" y1=\"20\" x2=\"" + x + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n";
        int textX = x + 10;
        int textY = y2 / 2 - 10;
        String res = line.concat("<text x=\"" + textX + "\" y=\"" + textY + "\" font-family=\"Verdana\" font-size=\"15\">\n"
                + " " + svg.length + "cm\n </text>");
        return res;
    }

    private String buildXArrow(SVGBuilder svg) {
        int x2 = svg.width + 20;
        int y = svg.length + 50;
        String line = "<line x1=\"20\" y1=\"" + y + "\" x2=\"" + x2 + "\" y2=\"" + y
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n";
        int textX = x2 / 2 - 10;
        int textY = y + 15;
        String res = line.concat("<text x=\"" + textX + "\" y=\"" + textY + "\" font-family=\"Verdana\" font-size=\"15\">\n"
                + " " + svg.width + "cm\n </text>");
        return res;
    }

    private void buildRafter(SVGBuilder svg) { //spær
        final double rafter = 4.5;
        final int y1 = 20;
        final int y2 = svg.length + 20;
        double x = 24;
        final int xe = svg.width + 16;
        double spacing = calcSpacing(svg.width);
        
        
        sb.append("<line x1=\"" + x + "\" y1=\"" + y1 + "\" x2=\"" + x + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
        sb.append("<line x1=\"" + xe + "\" y1=\"" + y1 + "\" x2=\"" + xe + "\" y2=\"" + y2
                + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
   
        for (double i = spacing*2+4.5; i < svg.width-9; i+= spacing) {
            x+=spacing;
            sb.append("<line x1=\"" + x + "\" y1=\"" + y1 + "\" x2=\"" + x + "\" y2=\"" + y2
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");
            x+=4.5;
            sb.append("<line x1=\"" + x + "\" y1=\"" + y1 + "\" x2=\"" + x + "\" y2=\"" + y2
                    + "\" stroke=\"#000\" stroke-width=\"2\"/> \n");

        }
    }
    
    private double calcSpacing(int width){
        //9 represents the size of the two outer rafters, which has to be considered 
        //to get a precise spacing.
        int amountOfRafters = (int) Math.ceil((width-9) / 64.5);
        return (width-amountOfRafters*4.5) / amountOfRafters;
    }

}