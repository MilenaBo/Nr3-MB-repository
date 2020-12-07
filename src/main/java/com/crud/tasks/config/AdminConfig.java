package com.crud.tasks.config;
//23.4,,32.2
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {

    @Value("${admin.mail}")
    private  String adminMail;
    @Value("${admin.name}")
    private String adminName;
}
