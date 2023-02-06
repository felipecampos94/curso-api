package br.com.java.api.service.impl;

import br.com.java.api.domain.User;
import br.com.java.api.repository.UserRepository;
import br.com.java.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> object = userRepository.findById(id);
        return object.orElse(null);
    }
}
