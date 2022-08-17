
/* Замечания ментора "убрать массивы, используй методы сканнера" */

package Modul_6;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayDequeTest2 {
    public static void main(String[] args) {
        /// блок для тестов в IDEA ///
        ByteArrayInputStream bAiS = new ByteArrayInputStream("1 2 3 4 5 6 7 8 9 10".getBytes());
        System.setIn(bAiS);
        /// блок для валидатора ///
        ArrayDeque<Integer> numbs = new ArrayDeque<>();
        Scanner reader = new Scanner(System.in);
        int i = 0;

        while (reader.hasNextInt()) {
            if (i % 2 == 0) {
                reader.next();
            } else {
                numbs.add(reader.nextInt());
            }
            i++;
        }
        reader.close();

        for (Iterator<Integer> itr = numbs.descendingIterator(); itr.hasNext(); ) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }
}

