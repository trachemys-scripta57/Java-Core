package Modul_6;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        ////////// Java 5 ///////////
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog"); //1
        animals.add("frog");

        String animal = (String) animals.get(1);// String != Object. Downcast

        ///////// Generics /////////
        List<String> animals2 = new ArrayList<String>();
        animals.add("cat");
        animals.add("dog"); //1
        animals.add("frog");

        String animal2 = animals2.get(1);

        //////// Java 7 //////////
        List<String> animals3 = new ArrayList<>(); //можно не указывать тип повторно

    }
}
