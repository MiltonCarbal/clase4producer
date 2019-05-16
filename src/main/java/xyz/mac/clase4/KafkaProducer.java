package xyz.mac.clase4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    FakerProducer fakerProducer;

    private final KafkaTemplate<Object, User> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<Object, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(User message){
        this.kafkaTemplate.send("topicUsuarios", message);
        System.out.println("Sent message [" + message + "]");
    }
}
