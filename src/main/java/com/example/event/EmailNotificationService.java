//package com.example.event;
//
//import java.net.Authenticator;
//import java.util.Properties;
//
//import jakarta.websocket.Session;
//
//public class EmailNotificationService {
//
//    public static void sendNotification(String recipientEmail, String subject, String body) throws Exception {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        String senderEmail = "your-email@gmail.com";
//        String senderPassword = "your-password";
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, senderPassword);
//            }
//        });
//
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(senderEmail));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//        message.setSubject(subject);
//        message.setText(body);
//
//        Transport.send(message);
//    }
//}
