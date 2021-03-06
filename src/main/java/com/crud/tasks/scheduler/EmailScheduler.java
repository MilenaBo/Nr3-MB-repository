package com.crud.tasks.scheduler;
//23 mod
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private  static  final  String SUBJECT = "Tasks:  Once a day email************";

    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        String toggle;
        long size = taskRepository.count();
        if (size==1) {toggle="task";} else toggle="tasks";
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "currently in database you got:  "+size+ toggle,
                "Cc")
        );

    }

}
