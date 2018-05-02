package PresentationLayer;

import DBAccess.OrderMapper;
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

public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        User user = (User) request.getSession().getAttribute("user");
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

        LogicFacade.createShed(shed, email);
        try {
            LogicFacade.createOrder(user.getEmail(), 500, order,  material, roof, LogicFacade.getShed(email), assemble );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "placedorderpage";

    }
}
