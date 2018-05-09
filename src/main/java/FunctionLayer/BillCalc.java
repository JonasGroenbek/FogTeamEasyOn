package FunctionLayer;

import DBAccess.OrderMapper;
import java.util.ArrayList;

public class BillCalc {

    public ArrayList<Bill> createBill(int id) {
        ArrayList<Bill> bill = new ArrayList();
        //int height = OrderMapper.getOrder(id).getHeight();
        //int width = OrderMapper.getOrder(id).getWidth();
        //int length = OrderMapper.getOrder(id).getLength();
        bill.add(new Bill(this.calscrews(), this.calcwood(), this.calccrackets()));
        return bill;
    }

    private int calcwood() {

        return 1;
    }

    private int calscrews() {

        return 1;
    }

    private int calccrackets() {

        return 1;
    }

}
