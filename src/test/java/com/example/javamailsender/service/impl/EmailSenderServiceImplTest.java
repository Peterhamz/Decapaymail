package com.example.javamailsender.service.impl;

import com.example.javamailsender.pojo.MailDto;
import com.example.javamailsender.service.EmailSenderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailSenderServiceImplTest {


    @MockBean
    EmailSenderService emailSenderService;


    @Test
    void sendEmail() {
        MailDto mailDto = new MailDto("peterhamza6@gmail.com", "this is a testing mail", "testing");
        Mockito.when(emailSenderService.sendEmail(any())).thenReturn(new ResponseEntity<>("Message sent successfully", HttpStatus.OK));

        ResponseEntity<String> responseEntity = emailSenderService.sendEmail(mailDto);

        Assertions.assertThat(responseEntity.getBody()).isEqualTo("Message sent successfully");
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
}