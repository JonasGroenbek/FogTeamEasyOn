package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Bill;
import FunctionLayer.BillCalc;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Shed;
import FunctionLayer.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BillDrawing extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String site = request.getParameter("site");
        if (site.equals("drawing")) {
            int id = Integer.parseInt(request.getParameter("orderID").trim());
            Order order = LogicFacade.getOrder(id);
            Shed shed;
            try {
                shed = LogicFacade.getShed(order.getShed());
                int material = order.getMaterial();               
                int roof = order.getRoofID();             
                int length = order.getLength();
                int width = order.getWidth();
                SVGBuilderTop svgTop = new SVGBuilderTop(roof, length, width, shed, material);
                SVGBuilderSide svgSide = new SVGBuilderSide(roof, length, width, shed, material);
                session.setAttribute("SVGTopView", svgTop.buildSvgTopView(svgTop));
                session.setAttribute("SVGSideView", svgSide.buildSvgSideView(svgSide));
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BillDrawing.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "ShowDrawing";
        } else {
            BillCalc calc = new BillCalc();
            User user = (User) session.getAttribute("user");
            int id = Integer.parseInt(request.getParameter("orderID").trim());
            request.setAttribute("id", id);
            Order order = OrderMapper.getOrder(id);
            try {
                ArrayList<Bill> list = OrderMapper.getBom(id);
                request.setAttribute("bill", list);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MakeBill.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "bill";
        }
    }

}
