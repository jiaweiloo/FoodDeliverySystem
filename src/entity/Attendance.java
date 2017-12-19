/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author jiawe
 */
public class Attendance {

    int attendance_id;
    int emp_id;
    String date;
    String time_checkin;
    String time_checkout;
    String lunch_checkin;
    String lunch_checkout;

    public Attendance() {
        
    }

    public Attendance(int attendance_id, int emp_id, String date, String time_checkin, String time_checkout, String lunch_checkin, String lunch_checkout) {
        this.attendance_id = attendance_id;
        this.emp_id = emp_id;
        this.date = date;
        this.time_checkin = time_checkin;
        this.time_checkout = time_checkout;
        this.lunch_checkin = lunch_checkin;
        this.lunch_checkout = lunch_checkout;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_checkin() {
        return time_checkin;
    }

    public void setTime_checkin(String time_checkin) {
        this.time_checkin = time_checkin;
    }

    public String getTime_checkout() {
        return time_checkout;
    }

    public void setTime_checkout(String time_checkout) {
        this.time_checkout = time_checkout;
    }

    public String getLunch_checkin() {
        return lunch_checkin;
    }

    public void setLunch_checkin(String lunch_checkin) {
        this.lunch_checkin = lunch_checkin;
    }

    public String getLunch_checkout() {
        return lunch_checkout;
    }

    public void setLunch_checkout(String lunch_checkout) {
        this.lunch_checkout = lunch_checkout;
    }


}
