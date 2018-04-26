package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Shed;

public class test {
    public static void main(String[] args) throws LoginSampleException {
        Shed shed = new Shed(5, 100, 100);
        Order order = new Order(5, 5, 5);
        OrderMapper.createShed(shed, "jens@lol.dk");
        OrderMapper.createOrder("jens@lol.dk", 500, order, 1, 1, shed, 1);
    }
    
}
