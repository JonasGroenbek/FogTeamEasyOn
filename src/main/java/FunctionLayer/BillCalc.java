package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;

public class BillCalc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, LoginSampleException {
        BillCalc bill = new BillCalc();
        int width = 480;
        System.out.println(bill.posts(600, 370, 780));
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

    private int overSternBoardSides(int width) {
        int boards = width / 540;
        if (width % 540 != 0) {
            boards++;
        }

        return boards;
    }

    private int zOnDoor(int id){
       if(OrderMapper.getOrder(id).getShed() != 0){
       return 1;
       }
       return 0; 
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

    private int cladding(int ID) {
        int cladding = 0;

        return cladding;
    }

    private int vandbaetOnSternSides(int length) {
        int vandbreat = 0;
        return vandbreat;
    }

    private int vandbaetOnSternFront(int width) {
        int vandbaet = 0;
        return vandbaet;
    }

    private int SmallRoofPlates() {
        int plates = 0;
        return plates;
    }

    private int bigRoofPlates() {
        int plates = 0;
        return plates;
    }

    private int roofScrews() {
        int screws = 0;
        return screws;
    }

    private int holebant() {
        int holeband = 0;
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

    private int screwsForUniAndBand() {
        int screws = 0;
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
       if(OrderMapper.getOrder(id).getShed() != 0){
       return 1;
       }
       return 0; 
  }

    private int tbracket() {
        int brackets = 0;
        return brackets;
    }

    private int angelBrackets() {
        int brackets = 0;
        return brackets;
    }
}
