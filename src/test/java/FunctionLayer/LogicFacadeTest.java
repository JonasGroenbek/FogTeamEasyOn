/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stgre
 */
public class LogicFacadeTest {
    
    public LogicFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class LogicFacade.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        int ID = getNextID("users");
        String email = "test"+ID;
        String password = "test";
        User expResult = new User(email, password, 1);
        expResult.setId(ID);
        User result = LogicFacade.createUser(email, password);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of login method, of class LogicFacade.
     */
 
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String email = "testtest";
        String password = "test";
        User expResult = new User(email, password, 1);
        expResult.setId(59);
        User result = LogicFacade.login(email, password);
        assertEquals(expResult.toString(), result.toString());
    }
    

//    @Test
//    public void testCreateShed() throws Exception {
//        System.out.println("createShed");
//        System.out.println(getNextID("shed"));
//        Shed shed = new Shed(180, 180, 250);
//        int userID = 59;
//        int expResult = getNextID("shed");
//        int result = LogicFacade.createShed(shed, userID);
//        assertEquals(expResult, result);
//    }

    @Test
    public void testGetShed() throws Exception {
        System.out.println("getShed");
        int shedID = 407;
        Shed expResult = new Shed(shedID, 210, 240, 500);
        Shed result = LogicFacade.getShed(shedID);
        assertEquals(expResult.toString(), result.toString());
    }

//    @Test
//    public void testCreateOrder() throws Exception {
//        System.out.println("createOrder");
//        int userID = 59;
//        int price = 1500;
//        Order order = new Order(240, 360, 360);
//        int matType = 1;
//        int roofType = 1;
//        int shed = 0;
//        int orderID = getNextID("orders");
//        LogicFacade.createOrder(userID, price, order, matType, shed);
//        testGetOrder(orderID);
//    }

    @Test
    public void testGetOrder() throws Exception{
        System.out.println("getOrder");
        int orderID = 527;
        Order expResult = new Order(527, 59, 1500, 
                240, 360, 360, 1, 0);
        Order result = LogicFacade.getOrder(orderID);
        assertEquals(expResult.toString(), result.toString());
    }
    
    public void testGetOrder(int orderID) throws Exception{
        System.out.println("getOrder");
        Order expResult = new Order(orderID, 59, 1500, 
                                    1, 240, 360, 360, 0);
        Order result = LogicFacade.getOrder(orderID);
        assertEquals(expResult.toString(), result.toString());
    }
    
    public int getNextID(String table){
        try {
            int id = 0;
            Connection con = Connector.connection();
            String SQL = "SELECT MAX(id) FROM ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, table);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID")+1;
            }
            return id;
            } catch (Exception e) {
        }
        return 0;
    }
    
}
