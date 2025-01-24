package emprestimos.com.credor.service.validator.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exception: CpfDoCredorJaExiste")
class CpfDoCredorJaExisteExceptionTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CpfDoCredorJaExisteException cpfDoCredorJaExisteException = new CpfDoCredorJaExisteException("Cpf do credor já existe");

        Assertions.assertEquals(
                "emprestimos.com.credor.service.validator.exceptions.CpfDoCredorJaExisteException: Cpf do credor já existe",
                cpfDoCredorJaExisteException.toString()
        );
    }
}
