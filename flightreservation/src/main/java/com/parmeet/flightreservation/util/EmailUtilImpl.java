package com.parmeet.flightreservation.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);
    @Value("${com.parmeet.flightreservation.itinerary.email.subject}")
    private String ITINERARY_SUBJECT;
    @Value("${com.parmeet.flightreservation.itinerary.email.body}")
    private String ITINERARY_BODY;

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendItinerary(String toAddress, String filePath) {
        LOGGER.info("Inside sendItinerary() and sending mail to address: " + toAddress);
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject(ITINERARY_SUBJECT);
            mimeMessageHelper.setText(ITINERARY_BODY);
            mimeMessageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Exception in sendItinerary() " + e);
        }
    }
}
