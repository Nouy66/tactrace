/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Sony
 */
public class VIChild {
    private int VIChildID,Age,Level,score;
    private String Name,Gender;
    public VIChild(int VIChildID,String Name,int Age,int Level,String Gender,int score){
    this.VIChildID=VIChildID;
    this.Name=Name;
    this.Age=Age;
    this.Level=Level;
    this.Gender=Gender;
    this.score=score;
    }
    public int getVIChildID(){
    return VIChildID;
    }
    public String getChildName(){
    
    return Name;
    }
    public int getAge(){
    return Age;
    }
    public int getLevel(){
    return Level;
    }
    public String getGender(){
    return Gender;
    }
    public int getScore(){
    return score;
    }
    
}
