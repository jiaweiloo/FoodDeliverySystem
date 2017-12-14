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
public class Customer {

    int cust_id;
    String cust_name;
    String email;
    String password;
    String cust_phone;
    String cust_deliveryAddress;
    int order_count;

    public Customer(int cust_id, String cust_name, String email, String password, String cust_phone, String cust_deliveryAddress, int order_count) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.email = email;
        this.password = password;
        this.cust_phone = cust_phone;
        this.cust_deliveryAddress = cust_deliveryAddress;
        this.order_count = order_count;
    }


    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_deliveryAddress() {
        return cust_deliveryAddress;
    }

    public void setCust_deliveryAddress(String cust_deliveryAddress) {
        this.cust_deliveryAddress = cust_deliveryAddress;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }
    
    
}
