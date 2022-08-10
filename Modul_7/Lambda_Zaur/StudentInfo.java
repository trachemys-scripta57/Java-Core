package Modul_7.Lambda_Zaur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class StudentInfo {
    void testStudents(ArrayList<Student> a1, StudentChecks sc) {
        for (Student s : a1) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }

//    void printStudentOverGrade(ArrayList<Student> a1, double grade) {
//        for (Student s : a1) {
//            if (s.avgGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void studentUnderAge(ArrayList<Student> a1, int age) {
//        for (Student s : a1) {
//            if (s.age > age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentMixCondition(ArrayList<Student> a1, int age, double grade, char sex) {
//        for (Student s : a1) {
//            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }
}

class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return st1.course - st2.course;
//            }
//        });
        Collections.sort(students,(stud1, stud2) -> stud1.course - stud2.course);
        System.out.println(students);

//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("------------------");

        /* Второй вариант. Создаём анонимный класс для использования интерфейса */
//        info.testStudents(students, new StudenChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age < 30;
//            }
//        });
        /* Третий вариант. ЛЯМБДА-выражение */
//        System.out.println("------------------");
//        info.testStudents(students, (Student s) -> {
//            return s.age < 30;
//        });
//        System.out.println("------------------");
//        info.testStudents(students, (Student s) -> {
//            return s.avgGrade > 8;
//        });
        /* укороченная форма записи этоё лямбды */
//        info.testStudents(students, p -> p.avgGrade > 8);
////////////////////////////////////////////////
//        StudentChecks sc = (Student p) -> {return p.avgGrade > 8;};
//        info.testStudents(students, sc);
/* присвоили лямбда выражению переменную типа StudentChecks */

//        System.out.println("------------------");
//        info.testStudents(students, (Student s) -> {
//            return s.age > 20 && s.avgGrade < 9.3 && s.sex == 'f';
//        });

//        info.printStudentOverGrade(students, 8);
//        System.out.println("------------------");
//        info.studentUnderAge(students, 30);
//        System.out.println("------------------");
//        info.printStudentMixCondition(students, 20, 9.5, 'f');
    }
}

interface StudentChecks { /* мы создали функциональный интерфейс с одним
единственным абстрактным методом */
    boolean check(Student s);
}

/* Первый вариант. Плохое решение - создание отдельного класса для того
что бы воспользоваться интрефейсом, возможно только один раз... */
class CheckOverGrade implements StudentChecks {
    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}
