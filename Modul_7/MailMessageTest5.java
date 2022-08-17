package Modul_7;

import java.util.*;
import java.util.function.Consumer;

public class MailMessageTest5 {
    private abstract static class Sendable<T> {
        private final String from;
        private final String to;
        private final T content;

        public Sendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }


    public static class MailMessage extends Sendable<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }


    public static class Salary extends Sendable<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }


    private static class MailService<T> implements Consumer<Sendable<T>> {
        private final Map<String, List<T>> mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Sendable<T> sendable) {
            mailBox.merge(sendable.getTo(), new ArrayList<>(Arrays.asList(sendable.getContent())), (l, e) -> {
                l.addAll(e);
                return l;
            });
        }
    }
}
