package br.com.java.api.service;

import br.com.java.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
