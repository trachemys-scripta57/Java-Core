package Modul_1_3.SerializableTestPerson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
//        Person person1 = new Person(1, "Bob");
//        Person person2 = new Person(2, "Mike");
        Person[] people = {new Person(1, "Bob"), new Person(2, "Mike"), new Person(3, "Tom")};
        /* созданные объекты прекратят существование вместе с
        завершением программы */

        /* для увеличения их срока жизни, объекты из оперативной
        памяти необходимо записать на жесткий диск. Для этого и
          создана СЕРИАЛИЗАЦИЯ */
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            /* для записи бинарных данных - расширение *.bin */
            ObjectOutputStream oos = new ObjectOutputStream((fos));
            /* для работы OOS необходим FOS, потому как класс FOS
            * принимает любой поток байтов (объекты, звук, что угодно).
            * Класс OOS предназначен только для записи объектов
            * в файлы - он узко специализирован. */

//            oos.writeObject(person1);
//            oos.writeObject(person2);
            oos.writeInt(people.length);//создаём длину массива

            for (Person person : people) { //записываем в массив объекты
                oos.writeObject(person);
            }

            oos.close(); //обязательно закрываем поток после записи объектов
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
