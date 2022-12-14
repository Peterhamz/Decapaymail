package com.example.javamailsender.service.impl;

import com.example.javamailsender.pojo.MailDto;
import com.example.javamailsender.service.EmailSenderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailSenderServiceImpl implements EmailSenderService {


    private final JavaMailSender mailSender;

    @Override
    public ResponseEntity<String> sendEmail(MailDto mailDto) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("decapay1@gmail.com");
        simpleMailMessage.setTo(mailDto.getTo());
        simpleMailMessage.setSubject(mailDto.getSubject());
        simpleMailMessage.setText(mailDto.getMessage());

        mailSender.send(simpleMailMessage);

        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);

    }
}
