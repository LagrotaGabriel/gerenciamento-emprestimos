package emprestimos.com.credor.models.dto.response;

import emprestimos.com.credor.models.dto.response.mock.CredorResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Response: Credor")
class CredorResponseTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CredorResponse credorResponse = CredorResponseMock.builder().build();

        Assertions.assertEquals(
                "CredorResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, nome=Gabriel, email=gabriellagrota@gmail.com, cpf=472.535.279-22]",
                credorResponse.toString()
        );
    }
}
