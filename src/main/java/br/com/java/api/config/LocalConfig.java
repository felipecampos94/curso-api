package br.com.java.api.config;

import br.com.java.api.domain.User;
import br.com.java.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
@RequiredArgsConstructor
public class LocalConfig {

    private final UserRepository userRepository;

    public void startDB() {
        User u1 = new User(null, "Teste", "teste@mail.com", "123");
        User u2 = new User(null, "Teste2", "teste2@mail.com", "123");
        userRepository.saveAll(List.of(u1, u2));
    }
}
