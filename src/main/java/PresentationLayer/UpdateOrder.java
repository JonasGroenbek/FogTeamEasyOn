package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderUpdate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        new OrderUpdate(
                Integer.parseInt(request.getParameter("orderID")), 
                Integer.parseInt(request.getParameter("price")),
                Integer.parseInt(request.getParameter("height")),
                Integer.parseInt(request.getParameter("length")),
                Integer.parseInt(request.getParameter("width")));
        return "adminpage";
    }
    
}
