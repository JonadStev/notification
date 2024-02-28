package com.core.transaction.bo.impl;

import com.core.transaction.bo.CustomerNotificationBO;
import com.core.transaction.dto.RequestKafkaDTO;
import com.core.transaction.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("CustomerNotificationGmailBO")
public class CustomerNotificationGmailBO implements CustomerNotificationBO {

    @Autowired
    EmailService emailService;

    @Value("${ms.notification.subject}")
    private String subject;
    @Override
    public void sendMail(RequestKafkaDTO requestKafkaDTO) {
        emailService.sendEmail(requestKafkaDTO.getEmail(), this.subject, requestKafkaDTO.getMensaje());
        System.out.println("MENSAJE ENVIADO .... "+requestKafkaDTO.getMensaje());
    }
}
