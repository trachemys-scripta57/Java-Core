package Modul_6.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtendsSuperTest {
    List list;
    List list1;
    static class C{}
    static class A extends C{}
    static class B extends A{}
    static class D extends B{}

    public static void main(String[] args) {
        ExtendsSuperTest test = new ExtendsSuperTest();

        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();
        List<D> listD = new ArrayList<>();

        test.setList(listA);
        test.setList(listB);
        test.setList(listD);
//        test.setList((List<? extends A>) listC);

        test.setList1(listA);
        test.setList1(Collections.singletonList(listB));
        test.setList1(Collections.singletonList(listD));
        test.setList1(listC);
    }


    void setList(List<? extends A> spisok){
        this.list = spisok;
    }
    void setList1(List<? super A> spisok){
        this.list1 = spisok;
    }
}
