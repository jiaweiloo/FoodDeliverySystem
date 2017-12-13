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
public class Order {

    int order_id;
    String cust_name;
    String cust_phone;
    String cust_email;
    String cust_deliveryAddress;
    int restaurant_id;
    String total_amount;
    String total_item;
    String current_status;

    public Order() {
    }

    public Order(int order_id, String cust_name, String cust_phone, String cust_email, String cust_deliveryAddress, int restaurant_id, String total_amount, String total_item, String current_status) {
        this.order_id = order_id;
        this.cust_name = cust_name;
        this.cust_phone = cust_phone;
        this.cust_email = cust_email;
        this.cust_deliveryAddress = cust_deliveryAddress;
        this.restaurant_id = restaurant_id;
        this.total_amount = total_amount;
        this.total_item = total_item;
        this.current_status = current_status;
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

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTotal_item() {
        return total_item;
    }

    public void setTotal_item(String total_item) {
        this.total_item = total_item;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }
    
    
    
    

}
