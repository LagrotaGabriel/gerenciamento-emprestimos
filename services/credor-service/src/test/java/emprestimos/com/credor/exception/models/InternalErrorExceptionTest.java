package emprestimos.com.credor.exception.models;

import emprestimos.com.credor.exception.models.mock.InternalErrorExceptionMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exception: InternalError")
class InternalErrorExceptionTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        InternalErrorException internalErrorException = InternalErrorExceptionMock.builder().build();

        Assertions.assertEquals(
                "InternalErrorException()",
                internalErrorException.toString()
        );
    }
}
