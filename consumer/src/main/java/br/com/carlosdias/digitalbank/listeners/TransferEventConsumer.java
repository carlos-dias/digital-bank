package br.com.carlosdias.digitalbank.listeners;

import br.com.carlosdias.digitalbank.producers.events.TransferEvent;
import br.com.carlosdias.digitalbank.services.PushNotificationService;
import br.com.carlosdias.digitalbank.utils.DecimalUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static br.com.carlosdias.digitalbank.producers.TransferProducer.TRANSFER_EVENTS_TOPIC;

@Component
@AllArgsConstructor
@Slf4j
public class TransferEventConsumer {
    private final PushNotificationService pushNotificationService;

    @KafkaListener(topics = TRANSFER_EVENTS_TOPIC, groupId = "digital-bank")
    public void consume(TransferEvent event) {
        String message = "Transfer of " + DecimalUtils.toDecimal(event.amount()) + " completed";

        pushNotificationService.send(event.fromAccountId(), "Debit: " + message);
        pushNotificationService.send(event.toAccountId(), "Credit: " + message);
    }
}
