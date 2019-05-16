package xyz.mac.clase4;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FakerProducer {

    private Faker faker = new Faker();


    public User getNewUser() {
        return new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().country(),
                UUID.randomUUID().toString());
    }

}
