/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.Roof;
import FunctionLayer.Shed;
import java.util.ArrayList;
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
public class OrderMapperTest {
    
    public OrderMapperTest() {
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
     * Test of getMaterial method, of class OrderMapper.
     */
    @Test
    public void testGetMaterial() throws Exception {
        System.out.println("getMaterial");
        int id = 1;
        Material expResult = new Material(1, "bræt", "25x200", 50, "25x200 mm. trykimp. bræt");
        Material result = OrderMapper.getMaterial(id);
        assertEquals(result.toString(), expResult.toString());
    }

    /**
     * Test of getRoof method, of class OrderMapper.
     */
    @Test
    public void testGetRoof() throws Exception {
        System.out.println("getRoof");
        int id = 1;
        Roof expResult = new Roof(1, "flat", 100, "Fladt tag i plast");
        Roof result = OrderMapper.getRoof(id);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of createOrder method, of class OrderMapper.
     */
    /*@Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        int userID = 1;
        int price = 16070;
        Order order = new Order(240, 300, 300);
        int matType = 1;
        int roofType = 1;
        Shed shed = null;
        //OrderMapper.createOrder(userID, price, order, matType, roofType, shed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createShed method, of class OrderMapper.
     */
    /*@Test
    public void testCreateShed() throws Exception {
        System.out.println("createShed");
        Shed shed = new Shed(300, 150, 1000);
        int userID = 1;
        //OrderMapper.createShed(shed, userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getShed method, of class OrderMapper.
     */
    /*@Test
    public void testGetShed() throws Exception {
        System.out.println("getShed");
        int userID = 0;
        int expResult = 0;
        int result = OrderMapper.getShed(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of getUserOrders method, of class OrderMapper.
     */
    @Test
    public void testGetUserOrders() throws Exception {
        System.out.println("getUserOrders");
        int userID = 0;
        //ArrayList<Order> expResult = null;
        int expResult = 0;
        ArrayList<Order> result = OrderMapper.getUserOrders(userID);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getOrder method, of class OrderMapper.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        int ID = 342;
        Order expResult = new Order(342, 4, 500, 1, 240, 240, 300, 1, 11);
        Order result = OrderMapper.getOrder(ID);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getAllOrders method, of class OrderMapper.
     */
    @Test
    public void testGetAllOrders() {
        System.out.println("getAllOrders");
        OrderMapper instance = new OrderMapper();
        //ArrayList<Order> expResult = null;
        int expResult = 7;
        ArrayList<Order> result = instance.getAllOrders();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of updateOrder method, of class OrderMapper.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        int ID = 0;
        Order newOrder = null;
        OrderMapper instance = new OrderMapper();
        boolean expResult = true;
        boolean result = instance.updateOrder(324, new Order(342, 4, 500, 1, 240, 240, 300, 1, 11));
        assertEquals(expResult, result);
    }
    
}
