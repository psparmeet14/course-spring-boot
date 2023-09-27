package com.parmeet.flightreservation.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendItinerary(String toAddress, String filePath) {
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject("Itinerary for your Flight");
            mimeMessageHelper.setText("Please find your Itinerary attached.");
            mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
