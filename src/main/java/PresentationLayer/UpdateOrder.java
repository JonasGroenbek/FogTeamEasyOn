package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderUpdate;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("User");
        int id = Integer.parseInt(request.getParameter("orderID").trim());
        int price = Integer.parseInt(request.getParameter("price").trim());
        int length = Integer.parseInt(request.getParameter("length").trim());
        int width = Integer.parseInt(request.getParameter("width").trim());
        
        LogicFacade.updateOrder(id, price, 300, length, width);
        
        ArrayList<Order> orders = LogicFacade.getAllOrders();
        request.setAttribute("orders", orders);
        
        if(user.getRole() == 2){
        return "employeepage";
        } else {
            return "adminpage";
        }
        
    }

}
