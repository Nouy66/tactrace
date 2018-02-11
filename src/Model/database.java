/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import test2.VIChild;
//import javax.swing.ImageIcon;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class database {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private final String driver = "com.mysql.jdbc.Driver";
    private Connection conn;
    private Statement state;
    private boolean connected = false;
         public Connection openConnection() {
        if (conn == null) {
            try {

                Class.forName(driver);
                conn = DriverManager.getConnection("jdbc:mysql://localhost/tactrace", USERNAME, PASSWORD);
                connected = true;
                //System.out.println("SUCESS");
            } catch (ClassNotFoundException | SQLException sqle) {
                connected = false;
                //System.out.println("ERROR");
            }
        }//if
        return conn;
    }
public ArrayList<VIChild> childernLists2(){
    
      ArrayList<VIChild>childern=new ArrayList();
      try{
           String sql = "SELECT VIChildID,Name,Age,Gender,Level,Score FROM vichild";
                state = conn.createStatement();
                ResultSet set = state.executeQuery(sql);
                VIChild child;
                while(!set.isAfterLast()){
                    set.next();
                child=new VIChild(set.getInt("VIChildID"),set.getString("Name"),set.getInt("Age"),set.getInt("Level"),set.getString("Gender"),set.getInt("Score"));
                childern.add(child);
                }
          
          }
      
       catch (SQLException sqle){
       
       }
      return childern;
   }


/***********************************MAKE CLASS CONNECTION IN PACAGE MODEL************************************/
    public boolean login(String username, String password) {
        boolean checklogin = false;
        if (connected) {
            try {
                String sql = "SELECT * FROM teacher";
                state = conn.createStatement();
                ResultSet set = state.executeQuery(sql);
                while (set.next()) {
                    String user = set.getString("Username");
                    String pass = set.getString("Password");
                    if ((username.equals(user)) && (password.equals(password))) {
                        checklogin = true;
                    }
                }//while

            }//try
            catch (SQLException sqle) {
                checklogin = false;
                System.out.println(sqle);
            }//catch 
        }
        return checklogin;

    }//method login
    /********************************************************************************************/
    public String shapeName(int index){
    String shape_name=""; 
            ResultSet rs;
try{
    String sql = "SELECT ShapeName FROM shape where ShapeID = '"+index+"'";
    state = conn.createStatement();
    rs = state.executeQuery(sql);
    while(rs.next()){
    shape_name = rs.getString("ShapeName");
    System.out.println(shape_name);
    }
}
     catch (SQLException sqle) {
                System.out.println(sqle);
            }//catch
    return shape_name; 

    }
   public void deleteStudent(String id){
            ResultSet rs;
try{
    String sql = "DELETE FROM vichild where VIChildID = '"+id+"'";
     PreparedStatement pst=conn.prepareStatement(sql);
  pst.executeUpdate();
        
}
     catch (SQLException sqle) {
                System.out.println(sqle);
            }//catch

    }
    
}//class
