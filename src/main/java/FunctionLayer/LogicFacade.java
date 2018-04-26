package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, 1);
        UserMapper.createUser( user );
        return user;
    }
    
    public static void createShed(Shed shed, String email) throws LoginSampleException {
        OrderMapper.createShed(shed, email);
    }
    
    public static Shed getShed(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        return OrderMapper.getShed(email);
    }
    
    public static void createOrder(String email,int price, Order order, int matType, int roofType, Shed shed, int assemble) throws LoginSampleException {
        OrderMapper.createOrder(email, price, order, matType, roofType, shed, assemble);
    }
    
    public static void updateBuilder(Integer orderId, Integer builds){
        UserMapper.updateAssembler(orderId, builds);
    }

}
