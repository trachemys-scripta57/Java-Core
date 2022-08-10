/* https://www.examclouds.com/ru/java/java-core-russian/unaryoperator-interface-russian */

package Modul_7;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    public static void main(String[] args) {
        UnaryOperator<String> uo = s -> s.toUpperCase();
        System.out.print(uo.apply("Java 8"));
    }
}




