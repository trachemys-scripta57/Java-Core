package Modul_6;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {

        Collection<?> collection = new ArrayList<Object>();
        Object object = new Object();


//        collection.add(object);//.add(capture<?>)
        collection.contains(object);
//        collection.addAll(Arrays.asList(object));//<? extends capture<?>>
        collection.clear();
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.size();
    }
}
