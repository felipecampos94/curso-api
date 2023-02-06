package br.com.java.api.service;

import br.com.java.api.domain.User;
import br.com.java.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO objectDTO);

    User update(UserDTO objectDTO);

    void delete(Integer id);
}
