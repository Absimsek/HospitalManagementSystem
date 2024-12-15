package Berkay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleApp {
HashMap<Doctor, ArrayList<Appointment>> doctorChoose=new HashMap<>();
    ArrayList<Doctor> doctors=new ArrayList<>();
    ArrayList<Appointment> appointments=new ArrayList<>();
    Scanner input=new Scanner(System.in);
    
    int doctorChosen=1;//menüde seçilecek olan doktor numarası ile değişecek
public void menu(){//doktor adlarını manuel mi girsek konsoldan mı bilemedim konsoldan girmek amelelik olur sanki sunumda da insanları çok bekletmiş oluruz
    System.out.println("welcome to appointment manager system");
    System.out.println("-------------------------------------");
    System.out.println("please choose which doctor you want to take appointment");
    System.out.println("1- DR.JOHN DOE");
    System.out.println("2- DR.JOHN DOE");
    System.out.println("3- DR.JOHN DOE");
    System.out.println("4- DR.JOHN DOE");
    System.out.println("5- DR.JOHN DOE");
    System.out.println("6- DR.JOHN DOE");
    System.out.println("7- DR.JOHN DOE");
    System.out.println("8- DR.JOHN DOE");
    System.out.println("9- DR.JOHN DOE");
    System.out.println("10- DR.JOHN DOE");
    System.out.println("------------------------------------");
    doctorChosen= input.nextInt();
    input.nextLine();
}
public void mapRunner(){
    doctorChoose.put(doctors.get(doctorChosen-1),appointments);//ilk kısım doctors listinden doktor seçiyor,
    // ikinci kısım ise direkt appointments typelı liste istiyor bunun için listeleri buraya kopyalamalıyız
    //kullanıcıya seçim yaptırırken appointments listi geldiğinde içindeki tüm elemeanları göstermeliyiz yani foreach kullanılacak
    //asıl konu başkasının seçtiği appointmentı listeden çıkartmak.

}
public void listTransfer(ArrayList<Doctor> doctor){
    doctors=doctor;
}

}
