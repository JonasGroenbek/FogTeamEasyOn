package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderSearch extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> Orders = new ArrayList();
        try {
            if (user.getRole() == 2) {
                switch (Integer.parseInt(request.getParameter("search"))) {
                    case 1:
                        Orders = LogicFacade.getAllOrders();
                        break;
                    case 2:
                        Orders = LogicFacade.getUserOrders(Integer.parseInt(request.getParameter("query").trim()));
                        break;
                    case 3:
                        Orders = LogicFacade.getOrdersByMail(request.getParameter("query"));
                        break;
                    default:
                        break;
                }
                request.setAttribute("orders", Orders);
                return "employeepage";
            } else if (user.getRole() == 3) {
                switch (Integer.parseInt(request.getParameter("search"))) {
                    case 1:
                        Orders = LogicFacade.getAllOrders();
                        break;
                    case 2:
                        Orders = LogicFacade.getUserOrders(Integer.parseInt(request.getParameter("query").trim()));
                        break;
                    case 3:
                        Orders = LogicFacade.getOrdersByMail(request.getParameter("query"));
                        break;
                    default:
                        break;
                }
                request.setAttribute("orders", Orders);
                return "adminpage";
            }
        } catch (OrderException ex) {
            request.setAttribute("error", ex.getStackTrace());
            return "errorPage";
        }

        return "customerpage";
    }

}
