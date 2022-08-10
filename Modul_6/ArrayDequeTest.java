/* Напишите программу, которая прочитает из System.in последовательность
целых чисел, разделенных пробелами, затем удалит из них все числа,
стоящие на четных позициях, и затем выведет получившуюся последовательность
в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются
с нуля.

Все import объявлены за вас.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль */

package Modul_6;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ArrayDequeTest {
    public static void main(String[] args) {
        /// блок для тестов в IDEA ///
        ByteArrayInputStream bAiS = new ByteArrayInputStream("1 2 3 4 5 6 7 8 9 10".getBytes());
        System.setIn(bAiS);
        /// блок для валидатора ///
        ArrayDeque<Integer> numbs = new ArrayDeque<>();
        Scanner reader = new Scanner(System.in);
        String[] strArr = reader.nextLine().split(" ");
        int[] numArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
            if ((i % 2) != 0) {
                numbs.addFirst(numArr[i]);
            }
        }
        for (Integer z : numbs) {
            System.out.print(z + " ");
        }
    }
}
