package tech.digitalia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String from) {
        try {
            String subject = "Рассылка для DIGITALIA";
            String body = "Прошу уведомить меня при старте сайта, мой емайл: " + from;
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("i.vanovAleksVal@gmail.com");
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            log.warn("send mail {} error: {}", from, e.getMessage());
        }
    }
}
