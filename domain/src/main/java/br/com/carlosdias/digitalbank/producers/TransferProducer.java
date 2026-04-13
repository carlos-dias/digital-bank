package br.com.carlosdias.digitalbank.producers;

import br.com.carlosdias.digitalbank.producers.events.TransferEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferProducer {

    private final KafkaTemplate<String, TransferEvent> kafkaTemplate;

    public static final String TRANSFER_EVENTS_TOPIC = "transfer-events";

    public void send(TransferEvent event) {
        kafkaTemplate.send(TRANSFER_EVENTS_TOPIC, event.referenceId().toString(), event);
    }
}