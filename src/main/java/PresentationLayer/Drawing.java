package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.Shed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Drawing extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("orderID").trim());
            Order order = LogicFacade.getOrder(id);
            Shed shed = LogicFacade.getShed(order.getShed());
            int material = order.getMaterial();
            int roof = order.getRoofID();
            int length = order.getLength();
            int width = order.getWidth();
            int height = 300;
            SVGBuilderTop svgTop = new SVGBuilderTop(roof, length, width, shed, material);
            SVGBuilderSide svgSide = new SVGBuilderSide(roof, length, width, shed, material);
            session.setAttribute("SVGTopView", svgTop.buildSvgTopView(svgTop));
            session.setAttribute("SVGSideView", svgSide.buildSvgSideView(svgSide));

            return "ShowDrawing";
        } catch (OrderException ex) {
            request.setAttribute("error", ex.getStackTrace());
            return "errorPage";
        }
    }

}
