package FunctionLayer;

import DBAccess.OrderMapper;

public class BillCalc {

    public static void main(String[] args) {
        BillCalc bill = new BillCalc();
        int width = 480;
        System.out.println(bill. overSterBoardFront(width));
    }

    private int underSternBoardFrontAndBack(int width) {
        int boards = width / 360;
        if (width % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    private int underSternBoardSides(int length) {
        int boards = length / 540;
        if (length % 540 != 0) {
            boards++;
        }

        return boards;
    }

    private int overSterBoardFront(int width) {
        int boards = width / 360;
        if (width % 360 != 0) {
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

//    private int zOnDoor(int id){
//       if(OrderMapper.getOrder(id).getShed() != 0)
//       return 0; 
//    }
    private int remsOnSides(int length) {
        if (OrderMapper.getOrder(1).getShed() == 0) {
        }
        return 0;
    }

}
