
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {

    private static final String EMAIL_HOST = "smtp.gmail.com";
    private static final String EMAIL_PORT = "587";

    public static void sendOTP(String recipientEmail, String otp, String emailSubject) throws MessagingException {
    	String fromEmail = "smtp.noreply.smtp@gmail.com";
        String emailPassword = "qbzj hzqx nigx ggye";
        String emailBody = "Your verification code is: " + otp;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.port", EMAIL_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, null);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        message.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);

        message.setContent(multipart);

        Transport transport = session.getTransport("smtp");
        transport.connect(EMAIL_HOST, fromEmail, emailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}