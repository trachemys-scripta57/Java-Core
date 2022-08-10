package Modul_1_3.Logger;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.FINE, "Начиная с аргумента: {0}", Arrays.toString(args));

    try {
        randomlyFailingAlgorithm();
    } catch (IllegalStateException e) {
        LOGGER.log(Level.SEVERE, "Пойманое \"ппп\" исключение: " + e);
        System.exit(2);
        }
    LOGGER.fine("Успешно завершено.");
    }

    private static void randomlyFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Создано случайное число: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Не верная фаза Луны");
        }
    }
}
