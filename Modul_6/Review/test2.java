package Modul_6.Review;

import java.util.Collection;

public class test2<T> {
//    public static <T> test2<T> create(Object o1, Object o2) {
//
//        test2<T> z;
//        return z;
public static <T> T get(Collection<T> m){
    return m.iterator().next();};
    }

