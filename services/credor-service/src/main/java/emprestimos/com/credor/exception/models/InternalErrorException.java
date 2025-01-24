package emprestimos.com.credor.exception.models;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ToString
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {

    public InternalErrorException(String message) {
        super(message);
    }
}
