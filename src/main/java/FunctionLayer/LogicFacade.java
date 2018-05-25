package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException, NoSuchAlgorithmException, NoSuchProviderException {
        User user = new User(email, password, 1);
        user = UserMapper.createUser(user);
        return user;
    }

    public static int createShed(Shed shed, int userID) throws LoginSampleException {
        return OrderMapper.createShed(shed, userID);
    }

    public static Shed getShed(int shedID) throws ClassNotFoundException, SQLException, LoginSampleException {
        return OrderMapper.getShed(shedID);
    }

    public static void createOrder(int userID, int price, Order order, int matType, int roofType, int shed) throws LoginSampleException {
        OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
    }
    
    public static Order getOrder(int orderID){
        return OrderMapper.getOrder(orderID);
    }

    public static void updateBuilder(int test, int test1) {

    }
    

    public static ArrayList<Order> getUserOrders(int userId) throws SQLException{
    return OrderMapper.getUserOrders(userId);
    }
}
