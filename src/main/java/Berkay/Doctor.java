package Berkay;

public class Doctor {
    private String firstName;
    private String secondName;
    private String DID;//doctor id

    public Doctor(String name,String surname, String id){
        firstName=name;
        secondName=surname;
        DID=id;
    }

    @Override
    public String toString() {
        return "Doctor ID :"+ DID+" name : "+ firstName+" "+secondName;
    }
}
