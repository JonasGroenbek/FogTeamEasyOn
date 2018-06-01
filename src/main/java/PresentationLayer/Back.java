package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Back extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orders;
        
        try {
            orders = LogicFacade.getAllOrders();
            request.setAttribute("orders", orders);
        } catch (OrderException ex) {
            Logger.getLogger(Back.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (user.getRole()== 2) {
            return "employeepage";
        } else {
            return "adminpage";
        }

    }

}
