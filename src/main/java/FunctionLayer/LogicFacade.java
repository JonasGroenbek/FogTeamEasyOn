package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, 1);
        user = UserMapper.createUser(user);
        return user;
    }

    public static int createShed(Shed shed, int userID) throws OrderException {
        return OrderMapper.createShed(shed, userID);
    }

    public static Shed getShed(int shedID) throws OrderException {
        return OrderMapper.getShed(shedID);
    }

    public static void createOrder(int userID, int price, Order order, int matType, int roofType, int shed) throws OrderException {
        OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
    }

    public static Order getOrder(int orderID) throws OrderException {
        return OrderMapper.getOrder(orderID);
    }

    public static ArrayList<Order> getUserOrders(int userId) throws OrderException {
        return OrderMapper.getUserOrders(userId);
    }

    public static ArrayList<Order> getAllOrders() throws OrderException {
        return OrderMapper.getAllOrders();
    }

    public static ArrayList<Order> getOrdersByMail(String email) throws OrderException {
        return OrderMapper.getUserOrders(UserMapper.getID(email));
    }

    public static String getEmail(int id) {
        return UserMapper.getMail(id);
    }


}
