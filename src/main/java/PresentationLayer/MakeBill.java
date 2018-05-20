package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.BillCalc;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeBill extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        BillCalc calc = new BillCalc();
        
        int id = Integer.parseInt(request.getParameter("orderID").trim());
        Order order = OrderMapper.getOrder(id);
        
        int length = order.getLength();
        int width = order.getWidth();
        
        return "bill";
    }
    
    
}
