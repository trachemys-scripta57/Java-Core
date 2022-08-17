package Modul_7.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main  {
    public static void main(String[] args) {

        List<Car> list = new ArrayList<Car>();
        list.add(new Car("VW", 1990));
        list.add(new Car("Reno", 2020));
        list.add(new Car("Volvo", 1950));
        list.add(new Car("Mers", 2002));
        list.add(new Car("Lada", 2015));

        Collections.sort(list, new SortByModel()); //сортировка по году

        for (Car car : list) {
            System.out.println(car.getModel() + " | " + car.getYear());
        }
    }
}
