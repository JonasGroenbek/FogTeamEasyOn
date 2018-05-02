/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.OrderMapper;

/**
 *
 * @author stgre
 */

public class OrderUpdate {

    public OrderUpdate(int orderID, int price, int height, int length, int width) {
        OrderMapper om = new OrderMapper();
            Order newOrder = om.getOrder(orderID);
            newOrder.setPrice(price);
            newOrder.setHeight(height);
            newOrder.setLength(length);
            newOrder.setWidth(width);
            om.updateOrder(orderID, newOrder);
    }
}
