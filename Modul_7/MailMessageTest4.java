package Modul_7;

import java.util.*;
import java.util.function.Consumer;

public class MailMessageTest4 {
    /***
     * HashMap с запретом выдачи null при отсутствующем ключе
     * @param <T>
     */
    private static class MailBox<T> extends HashMap<String, List<T>> {
        @Override
        public List<T> get(Object key) {
            return (this.containsKey(key)) ?
                    super.get(key)
                    : new ArrayList<>();
        }
    }

    /***
     * Почтовый сервис
     * @param <T> - определяет тип контента (текст письма или величина зарплаты)
     */
    private static class MailService<T> implements Consumer<Pack> {
        private final MailBox<T> mailBox;

        public MailService() {
            mailBox = new MailBox<>();
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Pack o) {
            String key = o.getTo();
            List<T> list = new ArrayList<>();
            if (mailBox.containsKey(key)) {
                list = mailBox.get(key);
            }
            list.add(o.getValue());
            mailBox.put(key, list);
        }
    }

    /***
     * Основа передаваемых через почтовый сервис упаковок данных
     */
    private static abstract class Pack {
        protected String from, to;

        @Override
        public abstract String toString();

        public abstract HashMap<String, Object> getMap();

        public abstract <T> T getValue();


        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }

    /***
     * Почтовое сообщение
     */
    private static class MailMessage extends Pack {
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from != null ? from : "";
            this.to = to != null ? to : "";
            this.content = content != null ? content : "";
        }

        @Override
        public String toString() {
            return "MailMessage{" +
                    "from='" + from + "'" +
                    ", to='" + to + "'" +
                    ", content='" + content + "'" +
                    '}';
        }

        @Override
        public HashMap<String, Object> getMap() {
            HashMap<String, Object> map = new HashMap<>();
            map.put("from", from);
            map.put("to", to);
            map.put("content", content);
            return map;
        }

        @Override
        public <T> T getValue() {
            return (T) content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    /***
     * Зарплата
     */
    private static class Salary extends Pack {
        private Integer salary;

        public Salary(String from, String to, int salary) {
            this.from = from != null ? from : "";
            this.to = to != null ? to : "";
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Salary{" +
                    "from='" + from + "'" +
                    ", to='" + to + "'" +
                    ", salary='" + salary + "'" +
                    '}';
        }

        @Override
        public HashMap<String, Object> getMap() {
            HashMap<String, Object> map = new HashMap<>();
            map.put("from", from);
            map.put("to", to);
            map.put("salary", salary);
            return map;
        }


        @Override
        public <T> T getValue() {
            return (T) salary;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
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
