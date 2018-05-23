///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package FunctionLayer;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author sebastian
// */
//public class BillCalcTest {
//    
//    public BillCalcTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
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
//    /**
//     * Test of underSternBoardFrontAndBack method, of class BillCalc.
//     */
//    @Test
//    public void testUnderSternBoardFrontAndBack() {
//        System.out.println("underSternBoardFrontAndBack");
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 4;
//        int result = instance.underSternBoardFrontAndBack(length);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of underSternBoardSides method, of class BillCalc.
//     */
//    @Test
//    public void testUnderSternBoardSides() {
//        System.out.println("underSternBoardSides");
//        int width = 780;
//        BillCalc instance = new BillCalc();
//        int expResult = 4;
//        int result = instance.underSternBoardSides(width);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of overSternBoardFront method, of class BillCalc.
//     */
//    @Test
//    public void testOverSternBoardFront() {
//        System.out.println("overSternBoardFront");
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 4;
//        int result = instance.overSternBoardFront(length);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of overSternBoardSides method, of class BillCalc.
//     */
//    @Test
//    public void testOverSternBoardSides() {
//        System.out.println("overSternBoardSides");
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.overSternBoardSides(length);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of zOnDoor method, of class BillCalc.
//     */
//    @Test
//    public void testZOnDoor() {
//        System.out.println("zOnDoor");
//        int shedl = 180;
//        int shedw = 530;
//        BillCalc instance = new BillCalc();
//        int expResult = 1;
//        int result = instance.zOnDoor(shedl, shedw);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of interTiesShedGabled method, of class BillCalc.
//     */
//    @Test
//    public void testInterTiesShedGabled() {
//        System.out.println("interTiesShedGabled");
//        int shedl = 530;
//        BillCalc instance = new BillCalc();
//        int expResult = 12;
//        int result = instance.interTiesShedGabled(shedl);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of interTiesChedSides method, of class BillCalc.
//     */
//    @Test
//    public void testInterTiesChedSides() {
//        System.out.println("interTiesChedSides");
//        int shedw = 120;
//        BillCalc instance = new BillCalc();
//        int expResult = 4;
//        int result = instance.interTiesChedSides(shedw);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of remsOnSides method, of class BillCalc.
//     */
//    @Test
//    public void testRemsOnSides() {
//        System.out.println("remsOnSides");
//        int width = 780;
//        int shedl = 120;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.remsOnSides(width, shedl);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of remsOnShed method, of class BillCalc.
//     */
//    @Test
//    public void testRemsOnShed() {
//        System.out.println("remsOnShed");
//        int shedWidth = 120;
//        BillCalc instance = new BillCalc();
//        int expResult = 1;
//        int result = instance.remsOnShed(shedWidth);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of rafter method, of class BillCalc.
//     */
//    @Test
//    public void testRafter() {
//        System.out.println("rafter");
//        int width = 780;
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 15;
//        int result = instance.rafter(width, length);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of posts method, of class BillCalc.
//     */
//    @Test
//    public void testPosts() {
//        System.out.println("posts");
//        int width = 780;
//        int length = 600;
//        int shedl = 120;
//        BillCalc instance = new BillCalc();
//        int expResult = 11;
//        int result = instance.posts(width, length, shedl);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of cladding method, of class BillCalc.
//     */
//    @Test
//    public void testCladding() {
//        System.out.println("cladding");
//        int shedWidth = 530;
//        int shedLength = 120;
//        BillCalc instance = new BillCalc();
//        int expResult = 200;
//        int result = instance.cladding(shedWidth, shedLength);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of vandbraetOnSternSides method, of class BillCalc.
//     */
//    @Test
//    public void testVandbraetOnSternSides() {
//        System.out.println("vandbraetOnSternSides");
//        int overSternBoardsSides = 0;
//        BillCalc instance = new BillCalc();
//        int expResult = 4;
//        int result = instance.vandbraetOnSternSides(overSternBoardsSides);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of vandbraetOnSternFront method, of class BillCalc.
//     */
//    @Test
//    public void testVandbraetOnSternFront() {
//        System.out.println("vandbraetOnSternFront");
//        int overSternBoardsFront = 2;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.vandbraetOnSternFront(overSternBoardsFront);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of bigRoofPlates method, of class BillCalc.
//     */
//    @Test
//    public void testBigRoofPlates() {
//        System.out.println("bigRoofPlates");
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 6;
//        int result = instance.bigRoofPlates(length);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of SmallRoofPlates method, of class BillCalc.
//     */
//    @Test
//    public void testSmallRoofPlates() {
//        System.out.println("SmallRoofPlates");
//        int length = 600;
//        BillCalc instance = new BillCalc();
//        int expResult = 6;
//        int result = instance.SmallRoofPlates(length);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of roofScrews method, of class BillCalc.
//     */
//    @Test
//    public void testRoofScrews() {
//        System.out.println("roofScrews");
//        int roofplates = 0;
//        BillCalc instance = new BillCalc();
//        int expResult = 3;
//        int result = instance.roofScrews(roofplates);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of holeband method, of class BillCalc.
//     */
//    @Test
//    public void testHoleband() {
//        System.out.println("holeband");
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.holeband();
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of rafterBracketRight method, of class BillCalc.
//     */
//    @Test
//    public void testRafterBracketRight() {
//        System.out.println("rafterBracketRight");
//        int rafters = 15;
//        BillCalc instance = new BillCalc();
//        int expResult = 15;
//        int result = instance.rafterBracketRight(rafters);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of rafterBracketLeft method, of class BillCalc.
//     */
//    @Test
//    public void testRafterBracketLeft() {
//        System.out.println("rafterBracketLeft");
//        int rafters = 15;
//        BillCalc instance = new BillCalc();
//        int expResult = 15;
//        int result = instance.rafterBracketLeft(rafters);
//        assertEquals(expResult, result);
//      
//    }
//
//    /**
//     * Test of screwsVandbraetAndStern method, of class BillCalc.
//     */
//    @Test
//    public void testScrewsVandbraetAndStern() {
//        System.out.println("screwsVandbraetAndStern");
//        int underSternFrontAndBack = 4;
//        int underSternSides = 4;
//        int overSternFront = 2;
//        int overSternSides = 4;
//        BillCalc instance = new BillCalc();
//        int expResult = 1;
//        int result = instance.screwsVandbraetAndStern(underSternFrontAndBack, underSternSides, overSternFront, overSternSides);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of screwsForUniAndBand method, of class BillCalc.
//     */
//    @Test
//    public void testScrewsForUniAndBand() {
//        System.out.println("screwsForUniAndBand");
//        int uniBrackets = 30;
//        BillCalc instance = new BillCalc();
//        int expResult = 3;
//        int result = instance.screwsForUniAndBand(uniBrackets);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of carriageBolt method, of class BillCalc.
//     */
//    @Test
//    public void testCarriageBolt() {
//        System.out.println("carriageBolt");
//        int posts = 11;
//        BillCalc instance = new BillCalc();
//        int expResult = 18;
//        int result = instance.carriageBolt(posts);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of squareSlices method, of class BillCalc.
//     */
//    @Test
//    public void testSquareSlices() {
//        System.out.println("squareSlices");
//        int posts = 11;
//        BillCalc instance = new BillCalc();
//        int expResult = 12;
//        int result = instance.squareSlices(posts);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of claddingScrewsExternal method, of class BillCalc.
//     */
//    @Test
//    public void testCladdingScrewsExternal() {
//        System.out.println("claddingScrewsExternal");
//        int cladding = 200;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.claddingScrewsExternal(cladding);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of claddingScrewsInternal method, of class BillCalc.
//     */
//    @Test
//    public void testCladdingScrewsInternal() {
//        System.out.println("claddingScrewsInternal");
//        int cladding = 200;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.claddingScrewsInternal(cladding);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of handle method, of class BillCalc.
//     */
//    @Test
//    public void testHandle() {
//        System.out.println("handle");
//        int shedw = 120;
//        int shedl = 530;
//        BillCalc instance = new BillCalc();
//        int expResult = 1;
//        int result = instance.handle(shedw, shedl);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of tHinge method, of class BillCalc.
//     */
//    @Test
//    public void testTHinge() {
//        System.out.println("tHinge");
//        int shedw = 120;
//        int shedl = 530;
//        BillCalc instance = new BillCalc();
//        int expResult = 2;
//        int result = instance.tHinge(shedw, shedl);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of angleBrackets method, of class BillCalc.
//     */
//    @Test
//    public void testAngleBrackets() {
//        System.out.println("angleBrackets");
//        int interTiesGabel = 12;
//        int interTiesSides = 4;
//        BillCalc instance = new BillCalc();
//        int expResult = 32;
//        int result = instance.angleBrackets(interTiesGabel, interTiesSides);
//        assertEquals(expResult, result);
//
//    }
//    
//}
