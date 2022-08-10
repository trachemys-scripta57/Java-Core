package Modul_7;

import java.util.*;
import java.util.function.Consumer;

public class MailMessageTest2 {


    public interface IMessage<T> {

        String getFrom();

        String getTo();

        T getContent();

    }

    public static class MailMessage implements IMessage<String> {

        private final String from;

        private final String to;

        private final String content;

        public MailMessage(String from, String to, String content) {

            this.from = from;

            this.to = to;

            this.content = content;

        }

        public final String getFrom() {

            return from;

        }

        public final String getTo() {

            return to;

        }

        public final String getContent() {

            return content;

        }

    }

    public static class Salary implements IMessage<Integer> {

        private final String from;

        private final String to;

        private final Integer content;

        public Salary(String from, String to, Integer content) {

            this.from = from;

            this.to = to;

            this.content = content;

        }

        public final String getFrom() {

            return from;

        }

        public final String getTo() {

            return to;

        }

        public final Integer getContent() {

            return content;

        }

    }

    public static class MailService<T> implements Consumer<IMessage<T>> {

        private static class MyHashMap<K, V> extends HashMap<K, V> {

            @Override

            public V get(Object key) {

                V temp = super.get(key);

                try {

                    if (temp == null) temp = (V) Collections.emptyList();

                } catch (ClassCastException e) {
                }

                return temp;

            }

        }

        private final Map<String, List<T>> mailBox;

        public MailService() {

            mailBox = new MyHashMap<>();

        }

        @Override

        public void accept(IMessage<T> t) {

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
}