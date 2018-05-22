/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sebastian
 */
public class BillCalcTest {
    
    public BillCalcTest() {
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
     * Test of getList method, of class BillCalc.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        BillCalc instance = new BillCalc();
        int expResult = 29;
        int result = instance.getList().size();
        assertEquals(expResult, result);

    }
    
}
