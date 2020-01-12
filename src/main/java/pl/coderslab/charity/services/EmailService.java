package pl.coderslab.charity.services;


import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

        void simpleMessageSent (String to, String subject, String text);
}
