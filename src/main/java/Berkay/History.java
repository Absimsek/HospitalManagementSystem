package Berkay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class History {
    List<String> year2024= new ArrayList<>();
    List<String> year2022= new ArrayList<>();
    List<String> year2020= new ArrayList<>();
    List<String> year2018= new ArrayList<>();
    List<String> year2016= new ArrayList<>();
    Stack<List <String> > hist= new Stack<>();
    void addListToStack(){
        hist.add(year2016);
        hist.add(year2018);
        hist.add(year2020);
        hist.add(year2022);
        hist.add(year2024);
    }
    void addToList(){

    }
}
