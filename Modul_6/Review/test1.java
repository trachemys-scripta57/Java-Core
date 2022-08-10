package Modul_6.Review;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    private Object[] data;
    private int count;

    public test1() {
        this.data = new Object[10];
        this.count = 0;
    }

    public void add(Object o) {
        this.data[count] = o;
        count++;
    }

    public Object[] getData() {
        return data;
    }
    public static void main(String[] args) {

//        test1 list = new test1();
        List<Integer> myList1 = new ArrayList<>();
//        list.add(100);
        myList1.add(100);
//        list.add(200);
        myList1.add(200);
//        list.add("Lolkek");
//        myList1.add("Lolkek"); //ошибка компиляции
//        list.add("Shalala");
//        myList1.add("Shalala"); //ошибка компиляции

        Integer sum1 = myList1.get(0) + myList1.get(1);
        System.out.println(sum1);

//        Integer sum2 = (Integer) list.getData()[2] + (Integer) list.getData()[3];
//        System.out.println(sum2);
    }
}
