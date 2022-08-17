package Modul_7.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Car> list = new ArrayList<Car>();
        list.add(new Car("vw", 1998));
        list.add(new Car("re", 2020));
        list.add(new Car("volvo", 1950));
        list.add(new Car("mers", 2002));
        list.add(new Car("lada", 2015));

        Collections.sort(list);

        for (Car car : list) {

            System.out.println(car.getModel() + " | " + car.getYear());
        }
    }
}
