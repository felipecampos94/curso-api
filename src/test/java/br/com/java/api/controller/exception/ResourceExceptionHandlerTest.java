package br.com.java.api.controller.exception;

import br.com.java.api.service.exception.DataIntegrityViolationdException;
import br.com.java.api.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
class ResourceExceptionHandlerTest {

    public static final String OBJECT_NOT_FOUND = "Object Not Found!";
    public static final String EMAIL_JÁ_CADASTRADO = "Email já cadastrado";
    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.objectNotFound(
                new ObjectNotFoundException(OBJECT_NOT_FOUND),
                new MockHttpServletRequest()
        );

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(OBJECT_NOT_FOUND, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
    }

    @Test
    void dataIntegrityViolation() {
        ResponseEntity<StandardError> response = exceptionHandler.dataIntegrityViolation(
                new DataIntegrityViolationdException(EMAIL_JÁ_CADASTRADO),
                new MockHttpServletRequest()
        );

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(EMAIL_JÁ_CADASTRADO, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
    }
}