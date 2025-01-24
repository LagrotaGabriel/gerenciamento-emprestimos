package emprestimos.com.credor.service.validator.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exception: EmailDoCredorJaExiste")
class EmailDoCredorJaExisteExceptionTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        EmailDoCredorJaExisteException emailDoCredorJaExisteException = new EmailDoCredorJaExisteException("Email do credor já existe");

        Assertions.assertEquals(
                "emprestimos.com.credor.service.validator.exceptions.EmailDoCredorJaExisteException: Email do credor já existe",
                emailDoCredorJaExisteException.toString()
        );
    }
}
