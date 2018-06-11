package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Bill;
import FunctionLayer.BillCalc;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.Shed;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BillDrawing extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String site = request.getParameter("site");
        if (site.equals("tegning")) {
            try {
                int id = Integer.parseInt(request.getParameter("orderID").trim());
                Order order = LogicFacade.getOrder(id);
                Shed shed;
                shed = LogicFacade.getShed(order.getShed());
                int material = 1;
                int roof = order.getRoofID();
                int length = order.getLength();
                int width = order.getWidth();
                SVGBuilderTop svgTop = new SVGBuilderTop(roof, length, width, shed, material);
                SVGBuilderSide svgSide = new SVGBuilderSide(roof, length, width, shed, material);
                session.setAttribute("SVGTopView", svgTop.buildSvgTopView(svgTop));
                session.setAttribute("SVGSideView", svgSide.buildSvgSideView(svgSide));
            } catch (OrderException ex) {
                request.setAttribute("error", ex.getStackTrace());
                return "errorPage";
            }
            return "ShowDrawing";
        } else {
            int id = Integer.parseInt(request.getParameter("orderID").trim());
            request.setAttribute("id", id);
            try {
                ArrayList<Bill> list = OrderMapper.getBom(id);
                request.setAttribute("bill", list);
            } catch (OrderException ex) {
                request.setAttribute("error", ex.getStackTrace());
                return "errorPage";
            }
            return "bill";
        }
    }

}
