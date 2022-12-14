package com.example.javamailsender.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailDto {

    private String to;
    private String subject;
    private String message;

}
