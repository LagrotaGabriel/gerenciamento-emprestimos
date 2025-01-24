package emprestimos.com.credor.exception.models;

import emprestimos.com.credor.exception.models.mock.StandartErrorMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exception: StandartError")
class StandartErrorTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        StandartError standartError = StandartErrorMock.builder().build();

        Assertions.assertEquals(
                "StandartError(localDateTime=2021-10-01T10:00, status=400, error=Bad Request, path=/api/v1/credor)",
                standartError.toString()
        );
    }

    @Test
    @DisplayName("Deve testar builder")
    void deveTestarBuilder() {

        StandartError standartError =
                StandartError.builder()
                        .localDateTime(LocalDateTime.of(2021, 10, 1, 10, 0, 0))
                        .status(400)
                        .error("Bad Request")
                        .path("/api/v1/credor")
                        .build();

        Assertions.assertEquals(
                "StandartError(localDateTime=2021-10-01T10:00, status=400, error=Bad Request, path=/api/v1/credor)",
                standartError.toString()
        );
    }
}
