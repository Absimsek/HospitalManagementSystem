package Berkay;

import Berkay.History;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Patient {
    private String FirstName;
    private String SecondName;
    private String ID;
    private String diagnosis;

    private String dateIn;
    LocalDateTime date=LocalDateTime.now();

    public Patient(String name,String surname,String ID){
        this.FirstName=name;
        this.SecondName=surname;
        this.ID=ID;
    }
        History patienthistory=new History();
    void filList2024(){
        Scanner input=new Scanner(System.in);
        int size;
        System.out.println("please enter the count of appointments in 2024");
        size=input.nextInt();input.nextLine();
        for (int i=0;i<size*2;i+=2){
            System.out.println("enter the diagnosis");
            diagnosis=input.nextLine();
            patienthistory.year2024.add(i,diagnosis);
            System.out.println("enter the date DD/MM/YYYY");
            dateIn=input.nextLine();
            patienthistory.year2024.add(i+1,dateIn);
        }
    }
    void addYears(){
        patienthistory.addListToStack();
    }


}
