package FunctionLayer;

import DBAccess.OrderMapper;
import java.util.ArrayList;

public class BillCalc {

    public Bill createBill(int id) {

        //int height = OrderMapper.getOrder(id).getHeight();
        //int width = OrderMapper.getOrder(id).getWidth();
        //int length = OrderMapper.getOrder(id).getLength();
        return (new Bill(this.calscrews(), this.calcwood(), this.calccrackets()));
        
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
