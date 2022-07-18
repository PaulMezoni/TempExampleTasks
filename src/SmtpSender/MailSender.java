package SmtpSender;

/**
 * This class should send emails to our customers.
 * It's a part of our microservice that runs all the time.
 * <p>
 * PLEASE, DO CODE REVIEW.
 */
public class MailSender {
    private static SmtpSender smtpSender;
    private String mail;

    public void send(String[] lines) throws Exception {
        System.out.println("Preparing to send the mail"); // StringBuilder
        smtpSender = new SmtpSender();
        try {
            if (lines != null) {
                System.out.println("Trying to send " + lines.length + " lines of mail");
                mail = prepare(lines);
                smtpSender.send(mail); // IOException
                System.out.println("The mail has been sent");
            } else {
                System.out.println(" no message ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            smtpSender.close();
        }
    }

    private String prepare(final String[] lines) {
        StringBuilder result = new StringBuilder(); // StringBuilder vs StringBuffer
        for (String line : lines) {
            result.append(line).append('\n');
        }
        return result.toString();
    }
}