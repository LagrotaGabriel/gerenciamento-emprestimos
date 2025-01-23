package emprestimos.com.credor.exception.handler;

import emprestimos.com.credor.exception.models.StandartError;
import emprestimos.com.credor.service.validator.exceptions.CpfDoCredorJaExisteException;
import emprestimos.com.credor.service.validator.exceptions.EmailDoCredorJaExisteException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CpfDoCredorJaExisteException.class)
    public ResponseEntity<StandartError> cpfDoCredorJaExisteExceptionHandler(HttpServletRequest req,
                                                                             CpfDoCredorJaExisteException cpfDoCredorJaExisteException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now())
                .status(400)
                .error(cpfDoCredorJaExisteException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmailDoCredorJaExisteException.class)
    public ResponseEntity<StandartError> emailDoCredorJaExisteExceptionHandler(HttpServletRequest req,
                                                                               EmailDoCredorJaExisteException emailDoCredorJaExisteException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now())
                .status(400)
                .error(emailDoCredorJaExisteException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}