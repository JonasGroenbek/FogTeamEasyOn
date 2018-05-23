package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Bill;
import FunctionLayer.BillCalc;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            request.setAttribute("id", id);
            Order order = OrderMapper.getOrder(id);
        try {
            ArrayList <Bill> list = OrderMapper.getBom(id);
            request.setAttribute("bill", list);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeBill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MakeBill.class.getName()).log(Level.SEVERE, null, ex);
        }

            return "bill";
            
            }
    }
