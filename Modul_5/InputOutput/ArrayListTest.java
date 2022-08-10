/* Интересно, но ничего не понятно...
* https://javarush.ru/help/12131
*  */

package Modul_5.InputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            list.add(bfr.readLine());
        }

        ArrayList<String> result = doubleValues(list);

        result.forEach(System.out::println);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int k = 0; k < list.size() * 2; k++) {
            list.add(k, list.get(k));
            k++;
        }
        return list;
    }
}
