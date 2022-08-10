package Modul_1_3.MailService;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostOffice {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class UntrustworthyMailWorker implements MailService {
        private final RealMailService realMailService = new RealMailService();
        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] services) {
            mailServices = services;
        }

        public MailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (int i = 0; i < mailServices.length; i++) {
                processed = mailServices[i].processMail(processed);
            }
            return realMailService.processMail(processed);
        }
    }

    public static class Spy implements MailService {
        private final Logger LOGGER;

        public Spy(Logger logger) {
            LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailMessage.class) {
                MailMessage mailMessage = (MailMessage) mail;
                String from = mailMessage.getFrom();
                String to = mailMessage.getTo();
                if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
                    LOGGER.warning("Detected target mail correspondence: from " + from + " to " + to + " \"" + mailMessage.getMessage() + "\"");
                } else {
                    LOGGER.info("Usual correspondence: from " + from + " to " + to + "");
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        private int minPrice = 0;
        private int stolenPrice = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue() {
            return stolenPrice;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailPackage.class) {
                Package pac = ((MailPackage) mail).getContent();
                if (pac.getPrice() >= minPrice) {
                    stolenPrice += pac.getPrice();
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pac.getContent(), 0));
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() == MailPackage.class) {
                Package pac = ((MailPackage) mail).getContent();
                String content = pac.getContent();
                if (content.indexOf("stones instead of ") == 0) {
                    throw new StolenPackageException();
                } else if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
            }
            return mail;
        }
    }

    public static class Solution {

        public static final String AUSTIN_POWERS = "Austin Powers";

        public static void main(String[] args) throws UnsupportedEncodingException {

            Logger logger = Logger.getLogger(Solution.class.getName());
            logger.setLevel(Level.INFO);
            Inspector inspector = new Inspector();
            Spy spy = new Spy(logger);
            Thief thief = new Thief(10000);
            MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
            UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);
            Package pack1 = new Package("ВВЖ", 32);
            Package pack2 = new Package("рпакетный двигатель ", 2500000);
            Package pack3 = new Package("stones", 1000);
            Package pack4 = new Package("banned substance", 99);
            Package pack5 = new Package("tiny bomb", 9000);
            AbstractSendable correspondence[] = {
                    new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                            "Ты же вылез из мамы под мой дисс на Бабана...."),
                    new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                            "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                    new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                    new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                    new MailPackage("берег", "море", pack1),
                    new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                    new MailPackage(AUSTIN_POWERS, "NASA", pack2),
                    new MailPackage(AUSTIN_POWERS, "NASA", pack3),
                    new MailPackage("Китай", "КНДР", pack4),
                    new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", pack5),
                    new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
            };
            Arrays.stream(correspondence).forEach(parcell -> {
                try {
                    worker.processMail(parcell);
                } catch (StolenPackageException e) {
                    logger.log(Level.WARNING, "Inspector found stolen package: " + e);
                } catch (IllegalPackageException e) {
                    logger.log(Level.WARNING, "Inspector found illegal package: " + e);
                }
            });

            System.out.println(thief.getStolenValue());
        }

    }
}