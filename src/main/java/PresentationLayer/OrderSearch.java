package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderSearch extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> Orders = new ArrayList();
        if (user.getRole() == 2) {
            if (Integer.parseInt(request.getParameter("search")) == 1) {
                Orders = LogicFacade.getAllOrders();
            } else if (Integer.parseInt(request.getParameter("search")) == 2) {
                try {
                    Orders = LogicFacade.getUserOrders(Integer.parseInt(request.getParameter("query").trim()));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Integer.parseInt(request.getParameter("search")) == 3) {
                try {
                    Orders = LogicFacade.getOrdersByMail(request.getParameter("query"));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            request.setAttribute("orders", Orders);
            return "employeepage";
        } else if (user.getRole() == 3) {
            if (Integer.parseInt(request.getParameter("search")) == 1) {
                Orders = LogicFacade.getAllOrders();
            } else if (Integer.parseInt(request.getParameter("search")) == 2) {
                try {
                    Orders = LogicFacade.getUserOrders(Integer.parseInt(request.getParameter("query").trim()));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Integer.parseInt(request.getParameter("search")) == 3) {
                try {
                    Orders = LogicFacade.getOrdersByMail(request.getParameter("query"));
                } catch (SQLException ex) {
                    Logger.getLogger(OrderSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            request.setAttribute("orders", Orders);
            return "adminpage";
        }
        return "customerpage";
    }

}
