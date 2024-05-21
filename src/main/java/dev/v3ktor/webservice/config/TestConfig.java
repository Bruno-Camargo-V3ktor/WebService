package dev.v3ktor.webservice.config;

import dev.v3ktor.webservice.model.entity.User;
import dev.v3ktor.webservice.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration @Profile("test")
public class TestConfig implements CommandLineRunner {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    //MÉTODOS
    @Override
    public void run(String... args) throws Exception
    {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll( Arrays.asList(u1, u2) );
    }
}
