package br.com.carlosdias.digitalbank.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushNotificationService {

    public void send(Long accountId, String message) {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("-------------------\n");
        messageBuilder.append(" PUSH NOTIFICATION \n");
        messageBuilder.append("-------------------\n");
        messageBuilder.append(" Account: ").append(accountId).append("\n");
        messageBuilder.append(" Message: ").append(message).append("\n");
        messageBuilder.append("-------------------");

        log.info(messageBuilder.toString());
    }
}