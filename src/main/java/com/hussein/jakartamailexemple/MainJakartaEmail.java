package com.hussein.jakartamailexemple;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MainJakartaEmail {
    public static void main(String[] args) {
        String to = "ousseynouthiaw96@gmail.com";
//        String from = "yuzinpream51@gmail.com";
        final String username = "yuzinpream51@gmail.com";
        final String password = "{password_to_replace}";
        String host = "smtp.gmail.com";
        Integer portSmtp = 587;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
        props.put("mail.smtp.host", host); // SMTP host
        props.put("mail.smtp.port", portSmtp); // TLS Port

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(props, authenticator);

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(to)
            );

            message.setSubject("Test Jakarta Mail");

            message.setText("Hello, World!");

            Transport.send(message);

            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
