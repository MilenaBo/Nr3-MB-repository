package com.crud.tasks.domain;
//23.3s44

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    //23.3 zadanie
    private String toCc;

}



