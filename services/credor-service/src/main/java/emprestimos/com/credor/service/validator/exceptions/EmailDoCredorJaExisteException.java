package emprestimos.com.credor.service.validator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EmailDoAssociadoJaExisteException
 * Exception que deverá ser lançada caso o usuário tente cadastrar um associado com um EMAIL que já existe no
 * cadastro de outro associado
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 10:11
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailDoCredorJaExisteException extends RuntimeException {

    public EmailDoCredorJaExisteException(String message) {
        super(message);
    }
}
