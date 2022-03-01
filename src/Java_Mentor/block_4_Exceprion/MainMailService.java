package Java_Mentor.block_4_Exceprion;

import java.util.logging.Level;
import java.util.logging.Logger;

// 4.3.7 - complete
public class MainMailService {

public static final String AUSTIN_POWERS = "Austin Powers";
public static final String WEAPONS = "weapons";
public static final String BANNED_SUBSTANCE = "banned substance";

public static void main(String[] args) throws Main.StolenPackageException, Main.IllegalPackageException {
    Logger logger = Logger.getLogger(Main.class.getName());
    Inspector inspector = new Inspector();
    Spy spy = new Spy(logger);
    Thief thief = new Thief(10000);
    UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new MailService[]{spy, thief, inspector});
    AbstractSendable[] correspondence = {
            new MailMessage("Oxxxymiron", "Гнойный", " Я здесь чисто по фану, поглумиться над слабым\n" +
                    "Ты же вылез из мамы под мой дисс на Бабана...."),
            new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                    "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
            new MailMessage("Жириновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
            new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
            new MailPackage("берег", "море", new Package("ВВЖ", 32)),
            new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
            new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
            new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones ", 1000)),
            new MailPackage("Китай", "КНДР", new Package("banned substance ", 10000)),
            new MailPackage(AUSTIN_POWERS, "Жопа запрещенная группировка", new Package("tiny bomb", 9000)),
            new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
    };

    for (AbstractSendable p : correspondence) {
        print("До:  ", p);
        Sendable sendable = worker.processMail(p);
        print("После:  ", sendable);
    }
}

public static void print(String prefix, Sendable p) {
    System.out.println(prefix + "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
            + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
            + " Цена=" + ((MailPackage) p).getContent().getPrice()));
}


/*
Интерфейс: сущность, которую можно отправить по почте.
У такой сущности можно получить от кого и кому направляется письмо.
*/
public interface Sendable {
    String getFrom();

    String getTo();
}

/*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
public static abstract class AbstractSendable implements Sendable {

    protected final String from;
    protected final String to;

    public AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSendable that = (AbstractSendable) o;

        if (!from.equals(that.from)) return false;
        return to.equals(that.to);
    }

}

/*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
public static class MailMessage extends AbstractSendable {

    private final String message;

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailMessage that = (MailMessage) o;

        return message != null ? message.equals(that.message) : that.message == null;
    }

}

/*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
public static class MailPackage extends AbstractSendable {
    private final Package content;

    public MailPackage(String from, String to, Package content) {
        super(from, to);
        this.content = content;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailPackage that = (MailPackage) o;
        return content.equals(that.content);
    }
}

/*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
public static class Package {
    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (price != aPackage.price) return false;
        return content.equals(aPackage.content);
    }
}

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
public interface MailService {
    Sendable processMail(Sendable mail);
}

/*
Класс, в котором скрыта логика настоящей почты
*/
public static class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}

/**
 * UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
 * чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
 * набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
 * У UntrustworthyMailWorker должен быть конструктор от массива MailService ( результат вызова processMail первого элемента
 * массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку
 * на внутренний экземпляр RealMailService.
 */

public static class UntrustworthyMailWorker implements MailService {
    private final RealMailService realMailService = new RealMailService();  /* внутренний экземпляр RealMailService*/
    private MailService[] mailservice; //набор третьих лиц

    //   У UntrustworthyMailWorker должен быть конструктор от массива MailService
    public UntrustworthyMailWorker(MailService[] mailservice) {
        this.mailservice = mailservice;
//            this.realMailService = new RealMailService();
    }

    public MailService getRealMailService() {
        return this.realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable m = mail;
        for (MailService mailService : mailservice) {
            m = mailService.processMail(m);
        }
        return realMailService.processMail(m);
    }
}

/**
 * Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
 * экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
 * MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
 * 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
 * Detected target mail correspondence: from {from} to {to} "{message}"
 * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */
public static class Spy implements MailService {
    private final Logger logger;

    public Spy(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {

            MailMessage mailMessage = (MailMessage) mail;
            String from = mailMessage.getFrom();
            String to = mailMessage.getTo();

            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
//                this.LOGGER.log(Level.WARNING, "Detected target mail correspondence: from " + from + " to " + to + " \"" + mailMessage.getMessage() + " \"");
                this.logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()});
            } else {
//                LOGGER.log(Level.INFO, "Usual correspondence: from " + from + " to " + to + "");
                this.logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{mailMessage.getFrom(), mailMessage.getTo()});
            }
        }
        return mail;
    }
}

/**
 * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную int
 * – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод getStolenValue,
 * который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
 * которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */
public static class Thief implements MailService {
    private int minPrice = 0; /* минимальная стоимость посылки, которую он будет воровать.*/
    private int sumAllPackage = 0;

    public int getStolenValue() {
        return this.sumAllPackage;
    }

    public Thief(int min_price) {
        this.minPrice = min_price;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailPackage.class) {
            Package pac = ((MailPackage) mail).getContent();
            if (pac.getPrice() >= minPrice) {
                sumAllPackage += pac.getPrice();
                mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pac.getContent(), 0));
            }
        }
        return mail;
    }
}

/**
 * Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
 * если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
 * "weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из
 * камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
 * объявить самостоятельно в виде непроверяемых исключений.
 */

public static class IllegalPackageException extends RuntimeException {

}

public static class StolenPackageException extends RuntimeException {

}

public static class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof AbstractSendable) {
            Package pac = ((MailPackage) mail).getContent();
            String content = pac.getContent();
            if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            } else if (pac.getContent().indexOf("stones") == 0) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
}
