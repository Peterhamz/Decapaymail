package com.example.javamailsender.service;

import com.example.javamailsender.pojo.MailDto;
import org.springframework.http.ResponseEntity;

public interface EmailSenderService {
    ResponseEntity<String> sendEmail(MailDto mailDto);
}
