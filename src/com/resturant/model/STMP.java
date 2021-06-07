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
    public STMP(Customer customer, String orderPrice) {
        this.customer = customer;
        this.orderPrice = orderPrice;
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
                        return new PasswordAuthentication("amtresturant@gmail.com","pqnj hzfl kyns lwfn");
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.customer.getEmail()));
            message.setSubject("Your AMT Resturant Order");
            message.setContent("Hello Mr/s." + customer.getFirstName() +
                    "I hope this mail find you well<br>"
                    + "Your Order Has been submitted Successfully<br>"
                    + "Order is being prepared<br>"
                    + "Your Total Cost is: " + orderPrice + " $"
                    + "<br> Thank you for choosing our service<br>", "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }
}
