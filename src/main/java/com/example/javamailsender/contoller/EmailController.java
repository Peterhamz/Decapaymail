package com.example.javamailsender.contoller;

import com.example.javamailsender.pojo.MailDto;
import com.example.javamailsender.resource.EmailMessage;
import com.example.javamailsender.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService)
    {
        this.emailSenderService = emailSenderService;
    }


    @PostMapping("/send-email")
    public ResponseEntity sendEmailToUser(@RequestBody MailDto mailDto){
        emailSenderService.sendEmail(mailDto);
        return ResponseEntity.ok("Success");
    }
}
