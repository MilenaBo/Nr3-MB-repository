package com.crud.tasks.service;
//32.1,2,3
import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message)  {

        List<String> functionality = new ArrayList<>();
        functionality.add("32.3 str 27 manage tasks");
        functionality.add("32.3 str 27 connection with trello");
        functionality.add("32.3 str 27 sending tasks");

        Context context = new Context();
        context.setVariable("message",message);
        context.setVariable("tasks_url","http://localhost:8888/crud");
        context.setVariable("button","Visit website");
        //  str 26 zmiana na adminconfig  context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button",false);
        context.setVariable("is_friend",true);
        context.setVariable("admin_config",adminConfig);
        context.setVariable("application_functionality",functionality);
        return templateEngine.process("mail/created-trello-card-mail",context);
    }
}
