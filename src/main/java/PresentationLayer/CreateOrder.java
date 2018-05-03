package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Shed;
import FunctionLayer.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession(); 
        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        int material = Integer.parseInt(request.getParameter("material"));
        int roof = Integer.parseInt(request.getParameter("roof"));
        int lengthShed = Integer.parseInt(request.getParameter("lengthShed"));
        int widthShed = Integer.parseInt(request.getParameter("widthShed"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int assemble = Integer.parseInt(request.getParameter("assemble"));
        
        Shed shed = new Shed(lengthShed, widthShed, 500);
        Order order = new Order(length, width, height);
        
        request.setAttribute("length", length);
        request.setAttribute("width", width);

        LogicFacade.createShed(shed, email);
        LogicFacade.createOrder(user.getEmail(), 500, order,  material, roof, shed, assemble);

        return "placedorderpage";

    }
}
