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
public class Item {

    int item_id;
    String item_name;
    double item_price;
    int rest_id;
    String item_season;
    String desc;
    public Item(int item_id, String item_name, double item_price, int rest_id,String desc,String Season) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.rest_id = rest_id;
        this.desc=desc;
        this.item_season=Season;
    }
    
    public String getItem_season() {
        return item_season;
    }

    public void setItem_season(String item_season) {
        this.item_season = item_season;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public void setDesc(String desc){
        this.desc=desc;
    }
    
    
}
