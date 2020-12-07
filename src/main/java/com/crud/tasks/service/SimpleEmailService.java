package com.crud.tasks.service;
//23,,32
import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private  MailCreatorService mailCreatorService;
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) {
    LOGGER.info("Starting email preparation .........................");
    try {
        javaMailSender.send(createMailMessage(mail));
        LOGGER.info(" email has been sent .........................");
    }  catch ( MailException e) {
        LOGGER.error("Failed to process email sending .........................",e.getMessage(),e);
    }
    }
    //23 zmiana 32.2 s19 setText
    private SimpleMailMessage createMailMessage(final Mail mail)    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()));
        if (mail.getToCc()!=null) {
            mailMessage.setCc(mail.getToCc());
        }
        return mailMessage;
    }
 //32.2s18 nalezy zastapić createMailMessage

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()),true);
        };
    }


}
