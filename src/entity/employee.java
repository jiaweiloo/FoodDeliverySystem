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
public class employee {

    int emp_id;
    String email;
    String password;
    String status;
    String ic_number;
    String address;
    String phone_num;
    String rank;

    public employee() {
    }
/*
    public employee(int emp_id, String email, String password, String status, String ic_number, String address, String phone_num) {
        this.emp_id = emp_id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.ic_number = ic_number;
        this.address = address;
        this.phone_num = phone_num;
    } */

    public employee(int emp_id, String email, String password, String status, String ic_number, String address, String phone_num, String rank) {
        this.emp_id = emp_id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.ic_number = ic_number;
        this.address = address;
        this.phone_num = phone_num;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIc_number() {
        return ic_number;
    }

    public void setIc_number(String ic_number) {
        this.ic_number = ic_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    
}
