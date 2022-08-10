package Modul_1_3.SerializableTestPerson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

//            Person person1 = (Person)ois.readObject();
//            Person person2 = (Person)ois.readObject();
            /* явно приводим класс Object к нашему классу Person */
            int personCount = ois.readInt();
            Person[] people = new Person[personCount]; // Создаём пустой массив

            for (int i = 0; i < personCount; i++) {
                people[i] = (Person) ois.readObject(); /* заполняем массив данными
                 считанными из файла people.bin */
            }

            System.out.println(Arrays.toString(people)); /* выводим в консоль считанный
             массив из файла people.bin, преобразовав массив в строку */

//            System.out.println(person1);
//            System.out.println(person2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
