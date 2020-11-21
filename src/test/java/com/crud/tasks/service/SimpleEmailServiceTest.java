package com.crud.tasks.service;
//23.3 oraz zadanie23.3
import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// @RunWith(...)niekompatybilne zmieniono 23.3s48
@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;
    @Mock
    private JavaMailSender javaMailSender;
    @Test
    public  void shouldSendEmail() {

        //given
       Mail mail = new Mail("test@test.com", "Test", "Test message.........","mbobran@seth.pl");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        //when
        simpleEmailService.send(mail);

        //then
        // pożądana liczba wywołań metody mocka.
        // W naszym wypadku takie wywołanie ma nastąpić tylko raz z danym parametrem.

        verify(javaMailSender, times(1)).send(mailMessage);
    }
}