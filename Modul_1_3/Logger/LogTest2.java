/* https://habr.com/ru/post/247647/
* Java.util.logging*/
package Modul_1_3.Logger;

import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class LogTest2 {
    Logger log = Logger.getLogger(LogTest2.class.getName());
    // Строковое сообщение
    String stringMessage = "Сообщение";
    // Строковое сообщение с параметрами
    String stringMessageFormat ="Сообщение {0}";
    // Исключение
    Throwable throwable = new Throwable();
    // ResourceBundle хранящий сообщения
    ResourceBundle resourceBundle = ResourceBundle.getBundle("logging.jul.bundle");
    // Поставщик сообщений
    Supplier<String> stringMessageSupplier = ()->"Сообщение";
}
