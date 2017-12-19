/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

/**
 *
 * @author Loi Kah Hou
 */
import adt.*;
public class testList {
    public static void main(String[] args){
        LList testList = new LList();
        for(int a=1;a<10;a++){
            testList.add(a);
            System.out.println(testList.getEntry(a));
        }
    }
}
