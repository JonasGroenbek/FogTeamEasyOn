package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.BillCalc;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MakeBill extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        BillCalc calc = new BillCalc();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("orderID").trim());
        Order order = OrderMapper.getOrder(id);
        for (int i = 0; i == calc.getList().size(); i++){
        OrderMapper.createBill(user.getId(), calc.getList().get(i)+1, calc.getList().get(i),i+1);
        }
        int length = order.getLength();
        int width = order.getWidth();
        
        return "bill";
    }
    
    
}
