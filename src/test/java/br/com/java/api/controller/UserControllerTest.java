package br.com.java.api.controller;

import br.com.java.api.domain.User;
import br.com.java.api.domain.dto.UserDTO;
import br.com.java.api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID = 1;
    public static final String NAME = "Paula Tejano";
    public static final String EMAIL = "paulatejano@gmail.com";
    public static final String PASSWORD = "123";
    public static final int INDEX = 0;
    public static final String EMAIL_JA_CADASTRADO = "Email já cadastrado!";
    public static final String OBJECT_NOT_FOUND = "Object Not Found!";

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private ModelMapper mapper;

    private User user;

    private UserDTO userDTO;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}