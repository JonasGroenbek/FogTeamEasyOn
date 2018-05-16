package FunctionLayer;

public class BillCalc {

    
    public static void main(String[] args) {
        BillCalc bill = new BillCalc();
        int width = 480;
        System.out.println(bill.overSterBoardsFront(width));
    }
    private int underSternBoardFrontAndBack(int width) {
        int boards = width/360*2;
        
        return boards;
    }
    private int underSternBoardSides(int length){
        int boards = length/540*2;
        
        return boards;
    }
    private int overSterBoardsFront(int width){
        int boards = width/360;
        if(width%360 != 0){
        boards++;
        }
    return boards;
    }
    
}