/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import adt.*;

/**
 *
 * @author Loi Kah Hou
 */
public class Affiliate {
    int affiliate_id;
    String rest_name;
    String rest_address;
    String owner_name;
    String contact_no;
    String restrt_zone;
    ListInterface<Item> itemList;
    String password;
   
    public Affiliate() {
    }

    public Affiliate(int affiliate_id, String rest_name, String rest_address, String owner_name, String contact_no, String restrt_zone,String password) {
        this.affiliate_id = affiliate_id;
        this.rest_name = rest_name;
        this.rest_address = rest_address;
        this.owner_name = owner_name;
        this.contact_no = contact_no;
        this.restrt_zone = restrt_zone;
        this.password = password;
    }

    public ListInterface<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ListInterface<Item> itemList) {
        this.itemList = itemList;
    }


    public int getAffiliate_id() {
        return affiliate_id;
    }

    public void setAffiliate_id(int affiliate_id) {
        this.affiliate_id = affiliate_id;
    }

    public String getRestrt_zone() {
        return restrt_zone;
    }

    public void setRestrt_zone(String restrt_zone) {
        this.restrt_zone = restrt_zone;
    }
    
    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getRest_address() {
        return rest_address;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setRest_address(String rest_address) {
        this.rest_address = rest_address;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    
    public void setPassword(String password) {
        this.password=password;
    }
  
}
