package xyz.mac.clase4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Clase4Application {

    public static void main(String[] args) {
        SpringApplication.run(Clase4Application.class, args);
    }

}

@Component
class AppStartupRunner implements ApplicationRunner {

    @Autowired
    KafkaProducer kafkaProducer;

    FakerProducer fakerProducer = new FakerProducer();

    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 200; i++) {
            kafkaProducer.send(fakerProducer.getNewUser());
        }
    }

}