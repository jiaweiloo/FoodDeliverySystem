/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author jiaweiloo
 */
public class emp_handled_list {
    int handle_id;
    int emp_id;
    int order_id;
    String date;
    String time;
    String handled_status;
    String message;

    public emp_handled_list() {
    }

    public emp_handled_list(int handle_id, int emp_id, int order_id, String date, String time, String handled_status, String message) {
        this.handle_id = handle_id;
        this.emp_id = emp_id;
        this.order_id = order_id;
        this.date = date;
        this.time = time;
        this.handled_status = handled_status;
        this.message = message;
    }

    public int getHandle_id() {
        return handle_id;
    }

    public void setHandle_id(int handle_id) {
        this.handle_id = handle_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHandled_status() {
        return handled_status;
    }

    public void setHandled_status(String handled_status) {
        this.handled_status = handled_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
