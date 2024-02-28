package com.core.transaction.bo;

import com.core.transaction.dto.RequestKafkaDTO;

public interface CustomerNotificationBO {

    void sendMail(RequestKafkaDTO requestKafkaDTO);
}
