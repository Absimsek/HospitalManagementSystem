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
public class Patient {

    private String name, surname, gender, diases, age, height, weight, bloodGroup, Identity;

    private Stack<String> medicalHistory;

   
    
    public Patient(String name, String surname, String gender, String diases, String age, String height, String weight, String bloodGroup,String Identity) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.diases = diases;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.Identity=Identity;
        medicalHistory = new Stack();
    }
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiases() {
        return diases;
    }

    public void setDiases(String diases) {
        this.diases = diases;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String Identity) {
        this.Identity = Identity;
    }

    public Stack<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Stack<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
}
