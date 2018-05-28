package DBAccess;

import FunctionLayer.Bill;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.Roof;
import FunctionLayer.Shed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderMapperTest {

}
//
//    private static final String URLTEST = "jdbc:mysql://159.65.56.14/fogtest";
//    private static final String USERNAME = "crud";
//    private static final String PASSWORD = "crud42";
//
//    private static Connection testDB;
//
//    public static void setConnection(Connection con) {
//        testDB = con;
//    }
//
//    public static Connection connection() throws ClassNotFoundException, SQLException {
//        if (testDB == null) {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            testDB = DriverManager.getConnection(URLTEST, USERNAME, PASSWORD);
//        }
//        return testDB;
//    }
//
//    public OrderMapperTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws ClassNotFoundException, SQLException {
//        Connector.setConnection(testDB);
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws ClassNotFoundException, SQLException {
//        Connector.connection();
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testGetMaterial() throws Exception {
//        System.out.println("getMaterial");
//        int id = 1;
//        Material expResult = new Material(1, "25x200 mm. trykimp. Brædt", "25x200", 50, "25x200 mm. trykimp. bræt");
//        Material result = OrderMapper.getMaterial(id);
//        assertEquals(result.toString(), expResult.toString());
//    }
//
//    @Test
//    public void testGetRoof() throws Exception {
//        System.out.println("getRoof");
//        int id = 1;
//        Roof expResult = new Roof(1, "flat", 100, "Fladt tag i plast");
//        Roof result = OrderMapper.getRoof(id);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    //@Test
//    public void testCreateOrder() throws Exception {
//        System.out.println("createOrder");
//        int userID = 1;
//        int price = 16070;
//        Order order = new Order(240, 300, 300);
//        int matType = 1;
//        int roofType = 1;
//        Shed shed = null;
//        //OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testCreateShed() throws Exception {
//        System.out.println("createShed");
//        Shed shed = new Shed(300, 150, 1000);
//        int userID = 1;
//        int expResult = 0;
//        int result = 0;//OrderMapper.createShed(shed, userID);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetUserOrders() throws Exception {
//        System.out.println("getUserOrders");
//        int userID = 0;
//        //ArrayList<Order> expResult = null;
//        int expResult = 0;
//        ArrayList<Order> result = OrderMapper.getUserOrders(userID);
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testGetOrder() {
//        System.out.println("getOrder");
//        int ID = 342;
//        Order expResult = new Order(342, 4, 500, 1, 240, 240, 300, 1, 11);
//        Order result = OrderMapper.getOrder(ID);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    //@Test
//    public void testGetAllOrders() {
//        System.out.println("getAllOrders");
//        OrderMapper instance = new OrderMapper();
//        //ArrayList<Order> expResult = null;
//        int expResult = 7;
//        ArrayList<Order> result = instance.getAllOrders();
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testUpdateOrder() {
//        System.out.println("updateOrder");
//        int ID = 0;
//        Order newOrder = null;
//        OrderMapper instance = new OrderMapper();
//        boolean expResult = true;
//        boolean result = instance.updateOrder(324, new Order(342, 4, 500, 1, 240, 240, 300, 1, 11));
//        assertEquals(expResult, result);
//    }
//
//    //@Test
//    public void testGetBill() throws Exception {
//        System.out.println("getBill");
//        int orderID = 0;
//        ArrayList<Bill> expResult = null;
//        ArrayList<Bill> result = OrderMapper.getBill(orderID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetShed() throws Exception {
//        System.out.println("getShed");
//        int shedID = 325;
//        Shed expResult = new Shed(325, 180, 270, 500);
//        Shed result = OrderMapper.getShed(shedID);
//        assertEquals(expResult.toString(), result.toString());
//    }
//}
//
//
//    @Test
//    public void testGetRoof() throws Exception {
//        System.out.println("getRoof");
//        int id = 1;
//        Roof expResult = new Roof(1, "flat", 100, "Fladt tag i plast");
//        Roof result = OrderMapper.getRoof(id);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    //@Test
//    public void testCreateOrder() throws Exception {
//        System.out.println("createOrder");
//        int userID = 1;
//        int price = 16070;
//        Order order = new Order(240, 300, 300);
//        int matType = 1;
//        int roofType = 1;
//        Shed shed = null;
//        //OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testCreateShed() throws Exception {
//        System.out.println("createShed");
//        Shed shed = new Shed(300, 150, 1000);
//        int userID = 1;
//        int expResult = 0;
//        int result = 0;//OrderMapper.createShed(shed, userID);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetUserOrders() throws Exception {
//        System.out.println("getUserOrders");
//        int userID = 0;
//        //ArrayList<Order> expResult = null;
//        int expResult = 0;
//        ArrayList<Order> result = OrderMapper.getUserOrders(userID);
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testGetOrder() {
//        System.out.println("getOrder");
//        int ID = 342;
//        Order expResult = new Order(342, 4, 500, 1, 240, 240, 300, 1, 11);
//        Order result = OrderMapper.getOrder(ID);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    //@Test
//    public void testGetAllOrders() {
//        System.out.println("getAllOrders");
//        OrderMapper instance = new OrderMapper();
//        //ArrayList<Order> expResult = null;
//        int expResult = 7;
//        ArrayList<Order> result = instance.getAllOrders();
//        assertEquals(expResult, result.size());
//    }
//
//    @Test
//    public void testUpdateOrder() {
//        System.out.println("updateOrder");
//        int ID = 0;
//        Order newOrder = null;
//        OrderMapper instance = new OrderMapper();
//        boolean expResult = true;
//        boolean result = instance.updateOrder(324, new Order(342, 4, 500, 1, 240, 240, 300, 1, 11));
//        assertEquals(expResult, result);
//    }
//
//    //@Test
//    public void testGetBill() throws Exception {
//        System.out.println("getBill");
//        int orderID = 0;
//        ArrayList<Bill> expResult = null;
//        ArrayList<Bill> result = OrderMapper.getBill(orderID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetShed() throws Exception {
//        System.out.println("getShed");
//        int shedID = 325;
//        Shed expResult = new Shed(325, 180, 270, 500);
//        Shed result = OrderMapper.getShed(shedID);
//        assertEquals(expResult.toString(), result.toString());
//    }
//}
//
