package emprestimos.com.credor.models.dto.request;

import emprestimos.com.credor.models.dto.request.mock.CredorRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Request: Credor")
class CredorRequestTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CredorRequest credorRequest = CredorRequestMock.builder().build();

        Assertions.assertEquals(
                "CredorRequest[nome=Gabriel, cpf=472.535.279-22, email=gabriellagrota@gmail.com, senha=123456]",
                credorRequest.toString()
        );
    }
}
