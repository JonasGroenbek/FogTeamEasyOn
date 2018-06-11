package FunctionLayer;

import DBAccess.OrderMapper;

public class OrderUpdate {

    public OrderUpdate(int orderID, int price, int height, int length, int width) throws OrderException {
        Order newOrder = OrderMapper.getOrder(orderID);
        newOrder.setPrice(price);
        newOrder.setHeight(height);
        newOrder.setLength(length);
        newOrder.setWidth(width);
        OrderMapper.updateOrder(orderID, newOrder);
    }
}
