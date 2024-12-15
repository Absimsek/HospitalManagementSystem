/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;

import java.util.Stack;

/**
 *
 * @author ysr
 */
public class Doctor {
    private String name, age, joiningDate, clinic, identity;

   
    
    private Stack<String> inspectionHistory;
    
    public Doctor(String name, String age, String joiningDate, String clinic) {
        this.name = name;
        this.age = age;
        this.joiningDate = joiningDate;
        this.clinic = clinic;
        inspectionHistory=new Stack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public Stack<String> getInspection() {
        return inspectionHistory;
    }

    public void setInspection(Stack<String> inspection) {
        this.inspectionHistory = inspection;
    }
    
     public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
    
    
}
