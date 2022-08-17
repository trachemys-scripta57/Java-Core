package Modul_7;

import java.util.*;
import java.util.function.Consumer;

public class MailMessageTest3 {
    interface Sendable<T> {
        String getFrom();

        String getTo();

        T getContent();
    }

    public static class MailMessage implements Sendable<String> {
        String from;
        String to;
        String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getContent() {
            return content;
        }

    }

    public static class Salary implements Sendable<Integer> {
        String from;
        String to;
        Integer content;

        public Salary(String from, String to, Integer content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public Integer getContent() {
            return content;
        }
    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        class MyMap<K, V> extends HashMap<K, V> {
            @Override
            public V get(Object key) {
                V temp = super.get(key);
                try {
                    if (temp == null) {
                        temp = (V) Collections.emptyList();
                    }
                } catch (ClassCastException e) {
                }
                return temp;
            }
        }

        MyMap<String, List<T>> mailBox;

        public MailService() {
            mailBox = new MyMap<>();
        }

        @Override
        public void accept(Sendable<T> t) {

            if (mailBox.containsKey(t.getTo())) {
                List<T> val;
                val = mailBox.get(t.getTo());
                val.add(t.getContent());
                mailBox.put(t.getTo(), val);
            } else {
                List<T> val;
                val = new LinkedList<>();
                val.add(t.getContent());
                mailBox.put(t.getTo(), val);
            }
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }

    public static void main(String[] args) {
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessageTest.MailMessage firstMessage = new MailMessageTest.MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessageTest.MailMessage secondMessage = new MailMessageTest.MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessageTest.MailMessage thirdMessage = new MailMessageTest.MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessageTest.MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        MailMessageTest.MailService<String> mailService = new MailMessageTest.MailService<>();

// Обработка списка писем почтовым сервисом
        messages.forEach(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        MailMessageTest.Salary salary1 = new MailMessageTest.Salary("Facebook", "Mark Zuckerberg", 1);
        MailMessageTest.Salary salary2 = new MailMessageTest.Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        MailMessageTest.Salary salary3 = new MailMessageTest.Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        MailMessageTest.MailService<Integer> salaryService = new MailMessageTest.MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }
}
