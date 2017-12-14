/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import adt.*;
import java.util.*;

/**
 *
 * @author Loi Kah Hou
 */
public class Order {

    int order_id;
    String cust_name;
    String cust_phone;
    String cust_email;
    String cust_deliveryAddress;
    int restaurant_id;
    double total_amount;
    int total_item;
    String current_status;
    String orderDate;
    String purchase_time;
    LList<OrderList> orderList;
    Customer cust;

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public Order() {
    }

    public Order(int order_id, String cust_name, String cust_phone, String cust_email, String cust_deliveryAddress, int restaurant_id, double total_amount, int total_item, String current_status, String purchase_time) {
        this.order_id = order_id;
        this.cust_name = cust_name;
        this.cust_phone = cust_phone;
        this.cust_email = cust_email;
        this.cust_deliveryAddress = cust_deliveryAddress;
        this.restaurant_id = restaurant_id;
        this.total_amount = total_amount;
        this.total_item = total_item;
        this.current_status = current_status;
        this.orderDate = orderDate;
        this.orderList = orderList;
    }

    
    

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public LList<OrderList> getOrderList() {
        return orderList;
    }

    public void setOrderList(LList<OrderList> orderList) {
        this.orderList = orderList;
    }

    public void setPurchase_time(String purchase_time) {
        this.purchase_time = purchase_time;
    }   

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getCust_deliveryAddress() {
        return cust_deliveryAddress;
    }

    public void setCust_deliveryAddress(String cust_deliveryAddress) {
        this.cust_deliveryAddress = cust_deliveryAddress;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public int getTotal_item() {
        return total_item;
    }

    public void setTotal_item(int total_item) {
        this.total_item = total_item;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }
    
    
}
