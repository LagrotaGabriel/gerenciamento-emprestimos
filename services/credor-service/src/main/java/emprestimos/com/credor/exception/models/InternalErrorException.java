package emprestimos.com.credor.exception.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InternalErrorException
 * [ DESCRIÇÃO DA CLASSE AQUI ]
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 23/01/2025 - 14:11
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {

    public InternalErrorException(String message) {
        super(message);
    }
}
