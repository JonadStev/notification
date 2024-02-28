package com.core.transaction.service;

import com.core.transaction.bo.CustomerNotificationBO;
import com.core.transaction.dto.RequestKafkaDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    BeanFactory factory;
    CustomerNotificationBO customerNotificationBO;

    @KafkaListener(topics = "${ms.notification.topic}", groupId = "develop")
    public void consumeMessage(RequestKafkaDTO requestKafkaDTO) {
        System.out.println("Received message: " + requestKafkaDTO.getMensaje());
        customerNotificationBO = factory.getBean(requestKafkaDTO.getOpcion(),CustomerNotificationBO.class);
        customerNotificationBO.sendMail(requestKafkaDTO);
    }
}
