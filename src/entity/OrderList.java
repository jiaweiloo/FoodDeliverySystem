/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Loi Kah Hou
 */
public class OrderList {

    String orderList_id;
    String order_id;
    String item_id;
    String quantity;
    String subTotal;

    public OrderList(String orderList_id, String order_id, String item_id, String quantity, String subTotal) {
        this.orderList_id = orderList_id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public String getOrderList_id() {
        return orderList_id;
    }

    public void setOrderList_id(String orderList_id) {
        this.orderList_id = orderList_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

}
