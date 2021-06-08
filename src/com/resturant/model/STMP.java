package com.resturant.model;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * The type Stmp.
 * @author Adham Adel
 */
public class STMP implements Runnable {
    private Customer customer;
    private String orderPrice;
    private String orderName;
    private String emailMessage;
    public STMP(Customer customer, String orderPrice, String orderName, String emailMessage) {
        this.customer = customer;
        this.orderPrice = orderPrice;
        this.orderName = orderName;
        this.emailMessage = emailMessage;
    }

    @Override
    public void run() {
        sendMessage();
    }

    public void sendMessage() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("amtresturant@gmail.com","xybd qxap qohg zqsg");
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(customer.getEmail()));
            message.setSubject("Your AMT Restaurant Order");
            message.setContent(emailMessage, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }
}
