package Berkay;

import java.util.ArrayList;
import java.util.Scanner;

public class RunnerConsole {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Doctor> doctors=new ArrayList<>();//to save objects at list
        String name;
        String surname;
        String id;

        for (int i=1;i<=10;i++){
            System.out.println("please enter the first name of doctor");
            name= input.nextLine();
            System.out.println("please enter the second name of doctor");
            surname= input.nextLine();
            System.out.println("please enter the id of doctor");
            id=input.nextLine();

            Doctor doctor=new Doctor(name,surname,id);

            doctors.add(doctor);
        }
        for (Doctor doc:doctors) {
            System.out.println(doc);//printing all objects in the list
        }
ConsoleApp app1=new ConsoleApp();
        app1.listTransfer(doctors);
        app1.menu();
    }

}
