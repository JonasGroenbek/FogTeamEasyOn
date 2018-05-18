package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;

public class BillCalc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, LoginSampleException {
        BillCalc bill = new BillCalc();
        int width = 480;

        System.out.println(bill.screwsForUniAndBand(15));
    }

    private int underSternBoardFrontAndBack(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    private int underSternBoardSides(int width) {
        int boards = width / 540;
        if (width % 540 != 0) {
            boards++;
        }

        return boards;
    }

    private int overSterBoardFront(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    private int overSternBoardSides(int length) {
        int boards = length / 540;
        if (length % 540 != 0) {
            boards++;
        }
        return boards;
    }

    private int zOnDoor(int id) {
        if (OrderMapper.getOrder(id).getShed() != 0) {
            return 1;
        }
        return 0;
    }

    private int interTiesChedGabled(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        int interTies = (shedLength / 270);
        if (shedLength % 270 != 0) {
            interTies++;
        }
        interTies *= 2;
        return interTies * 2;
    }

    private int interTiesChedSides(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedWidth = shed.getWidth();
        int interTies = shedWidth / 240;
        if (shedWidth % 240 != 0) {
            interTies++;
        }
        return interTies * 2;
    }

    private int remsOnSides(int width, int OrderID) throws ClassNotFoundException, SQLException, LoginSampleException {
        if (OrderMapper.getOrder(OrderID).getShed() == 0) {
            int boards = width / 600;
            if (width % 600 != 0) {
                boards++;
            }
            return boards * 2;
        }
        if (OrderMapper.getOrder(OrderID).getShed() != 0) {
            Order order = OrderMapper.getOrder(OrderID);
            Shed shed = OrderMapper.getShed(order.getShed());
            int shedLength = shed.getLength();
            int boards = (width - shedLength) / 600;
            if ((width - shedLength) % 600 != 0) {
                boards++;
            }
            return boards * 2;
        }

        return 0;
    }

    private int remsOnShed(int shedWidth) {
        int boards = shedWidth / 480;
        if (shedWidth % 480 != 0) {
            boards++;
        }
        if (shedWidth / 2 <= 480) {
            return boards;
        } else {
            return boards * 2;
        }

    }

    private int rafter(int width, int length) {
        int rafter = 0;
        if (length <= 600) {
            rafter = (width - rafter * 2) / (60 + rafter) + 2;
            return rafter;
        } else {
            int rest = length - 600;
            rafter = (width - rafter * 2) / (60 + rafter) + 2 + (600 / rest);
        }
        return rafter;
    }

    private int posts(int width, int ID, int length) throws ClassNotFoundException, SQLException, LoginSampleException {
        int posts = 1;
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        if (OrderMapper.getOrder(ID).getShed() == 0) {
            posts += (width / 250) * 2 + (length / 250);
            return posts;
        } else if (length - 70 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 3;
            return posts;
        } else if ((length - 70) / 2 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 2;
            return posts;
        } else {
            posts += (width / 250) * 2 + (length / 250) + 3;
        }

        return posts;
    }

    private int cladding(int shedWidth, int shedLength) throws ClassNotFoundException, SQLException, LoginSampleException {
        int circumference = (shedLength * 2) + (shedWidth * 2);
        int cladding = circumference / 6;
        if (circumference % 6 != 0) {
            cladding++;
        }
        return cladding;
    }

    private int vandbaetOnSternSides(int overSternBoardsSides) {
        int vandbreat = overSternBoardsSides;
        return vandbreat;
    }

    private int vandbaetOnSternFront(int overSternBoardsFront) {
        int vandbaet = overSternBoardsFront;
        return vandbaet;
    }

    private int bigRoofPlates(int length) {
        int plates = length/10;
        if(length%10 != 0){
        plates++;
        }
        return plates;
    }

    private int SmallRoofPlates(int length) {
        int plates = length/10;
        if(length%10 != 0){
        plates++;
        }
        return plates;
    }
    private int roofScrews(int roofplates) {
        int screws = roofplates/2;
        if(roofplates % 2 != 0){
        screws++;
        }
        return screws;
    }

    private int holebant() {
        int holeband = 2;
        return holeband;
    }

    private int rafterBracketRight(int rafters) {
        int brackets = rafters;
        return brackets;
    }

    private int rafterBracketLeft(int rafters) {
        int brackets = rafters;
        return brackets;
    }

    private int screwsForUniAndBand(int uniBrackets) {
        int screws = 250/(uniBrackets*2+2)/3;
        if(250%(uniBrackets*2+2)/3 != 0){
        screws++;
        }
        return screws;
    }

    private int carriageBolt() {
        int bolt = 0;
        return 0;
    }

    private int squareSlices() {
        int slices = 0;
        return slices;
    }

    private int claddingScrewsExternal() {
        int screws = 0;
        return screws;
    }

    private int claddingScrewsInternal() {
        int screws = 0;
        return screws;
    }

    private int handle(int id) {
        if (OrderMapper.getOrder(id).getShed() != 0) {
            return 1;
        }
        return 0;
    }

    private int tHinge(int id) {
        if (OrderMapper.getOrder(id).getShed() != 0) {
            return 2;
        } else {
            return 0;
        }
    }

    private int angelBrackets() {
        int brackets = 0;
        return brackets;
    }
}
