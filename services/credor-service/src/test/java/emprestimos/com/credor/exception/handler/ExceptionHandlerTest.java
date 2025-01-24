package emprestimos.com.credor.exception.handler;

import emprestimos.com.credor.exception.models.StandartError;
import emprestimos.com.credor.service.validator.exceptions.CpfDoCredorJaExisteException;
import emprestimos.com.credor.service.validator.exceptions.EmailDoCredorJaExisteException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExceptionHandlerTest {


    private ExceptionHandler exceptionHandler;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private WebRequest webRequest;

    @Mock
    private ConstraintViolation<Object> constraintViolation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        exceptionHandler = new ExceptionHandler();
    }

    @Test
    void testCpfDoCredorJaExisteExceptionHandler() {
        // Arrange
        String expectedMessage = "CPF já cadastrado.";
        String expectedPath = "/api/credor";
        when(httpServletRequest.getRequestURI()).thenReturn(expectedPath);

        CpfDoCredorJaExisteException exception = new CpfDoCredorJaExisteException(expectedMessage);

        // Act
        ResponseEntity<StandartError> response = exceptionHandler.cpfDoCredorJaExisteExceptionHandler(httpServletRequest, exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        StandartError error = response.getBody();
        assertEquals(expectedMessage, error.getError());
        assertEquals(400, error.getStatus());
        assertEquals(expectedPath, error.getPath());
    }

    @Test
    void testEmailDoCredorJaExisteExceptionHandler() {
        // Arrange
        String expectedMessage = "E-mail já cadastrado.";
        String expectedPath = "/api/credor";
        when(httpServletRequest.getRequestURI()).thenReturn(expectedPath);

        EmailDoCredorJaExisteException exception = new EmailDoCredorJaExisteException(expectedMessage);

        // Act
        ResponseEntity<StandartError> response = exceptionHandler.emailDoCredorJaExisteExceptionHandler(httpServletRequest, exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        StandartError error = response.getBody();
        assertEquals(expectedMessage, error.getError());
        assertEquals(400, error.getStatus());
        assertEquals(expectedPath, error.getPath());
    }

    @Test
    void testHandleConstraintViolationException() {
        // Arrange
        String fieldName = "campoTeste";
        String errorMessage = "Valor inválido.";

        Path mockPath = mock(Path.class); // Mock para o Path
        when(mockPath.toString()).thenReturn(fieldName);
        when(constraintViolation.getPropertyPath()).thenReturn(mockPath); // Configuração do mock
        when(constraintViolation.getMessage()).thenReturn(errorMessage);

        ConstraintViolationException exception = new ConstraintViolationException(
                new HashSet<>(Collections.singletonList(constraintViolation))
        );

        // Act
        ResponseEntity<Object> response = exceptionHandler.handleConstraintViolationException(exception, webRequest);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        @SuppressWarnings("unchecked")
        Map<String, String> errors = (Map<String, String>) response.getBody();
        assertEquals(1, errors.size());
        assertEquals(errorMessage, errors.get(fieldName));
    }
}
