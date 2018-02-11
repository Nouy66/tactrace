/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.database;
import View.ControlPanel;
import java.util.ArrayList;
import test2.VIChild; //Ithink it needs to be in model package insted of test2

/**
 *
 * @author Sony
 */
public class Test2 {
    
    
    
    public ArrayList<VIChild> viewChildren(){
        
        database db = new database();
        db.openConnection();
        
        return db.childernLists2();
    }
    public static void testDelete(String id){
       database db= new database();
        db.openConnection(); 
       db.deleteStudent(id);
    }
    
  //***********************TEACHER LOGIN***********************************************************  
    /**public static boolean testlogin (String n, String p){
   
        database db= new database();
        db.openConnection();
        login log=new login();
        log.setVisible(true);
        
      boolean b=db.login(n, p);
      return b;
        // TODO code application logic here
    }*/
    //**************************************Print Shape Barcode**********************************
        /**public static String testname (int index){
database db= new database();
        db.openConnection();
        generate_shape s=new generate_shape();
        s.setVisible(true);
        String t=db.shapeName(index);
        return t;
    
    
}*/
    
    
}
