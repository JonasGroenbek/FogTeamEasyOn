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

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        user.getEmail();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("email", email);
        try {
            switch (user.getRole()) {
                case 1:
                    return "customerpage";
                case 2:
                    ArrayList<Order> orders;
                    orders = LogicFacade.getAllOrders();
                    request.setAttribute("orders", orders);
                    return "employeepage";
                case 3:
                    orders = LogicFacade.getAllOrders();
                    request.setAttribute("orders", orders);
                    return "adminpage";
            }
        } catch (OrderException ex) {
            request.setAttribute("error", ex.getStackTrace());
            return "errorPage";
        }
        return "customerpage";

    }

}
