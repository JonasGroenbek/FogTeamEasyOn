package PresentationLayer;

import FunctionLayer.OrderException;
import FunctionLayer.OrderUpdate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            new OrderUpdate(
                    Integer.parseInt(request.getParameter("orderID").trim()),
                    Integer.parseInt(request.getParameter("price").trim()),
                    300,
                    Integer.parseInt(request.getParameter("length").trim()),
                    Integer.parseInt(request.getParameter("width").trim()));
        } catch (OrderException ex) {
            request.setAttribute("error", ex.getStackTrace());
            return "errorPage";
        }
        return "adminpage";
    }

}
