package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;

public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, 1);
        UserMapper.createUser( user );
        return user;
    }
    
    public static int createShed(Shed shed, int userID) throws LoginSampleException {
        return OrderMapper.createShed(shed, userID);
    }
    
    public static int getShed(int userID) throws ClassNotFoundException, SQLException, LoginSampleException {
        return OrderMapper.getShed(userID);
    }
    
    public static void createOrder(int userID,int price, Order order, int matType, int roofType, int shed) throws LoginSampleException {
        OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
    }
    public static void updateBuilder(int test, int test1){
    
    }
}
