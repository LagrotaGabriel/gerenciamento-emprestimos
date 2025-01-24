package emprestimos.com.credor.models.entity;

import emprestimos.com.credor.models.entity.mock.CredorEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Entity: Credor")
class CredorEntityTest {

    @Test
    @DisplayName("Deve testar mock")
    void deveTestarMock() {

        CredorEntity credorEntity = CredorEntityMock.builder().build();

        Assertions.assertEquals(
                "CredorEntity(id=bcdc5961-b48b-424f-8958-746713fffc92, dataHoraCadastro=2025-01-01T00:00, " +
                        "nome=Gabriel, cpf=472.535.279-22, email=gabriellagrota@gmail.com, exibeSaldoDisponivel=false, " +
                        "saldoDisponivel=0, senha=123456)",
                credorEntity.toString()
        );
    }

    @Test
    @DisplayName("Deve testar construtor sem argumentos")
    void deveTestarConstrutorSemArgumentos() {

        CredorEntity credorEntity = new CredorEntity();

        Assertions.assertEquals(
                "CredorEntity(id=null, dataHoraCadastro=null, nome=null, cpf=null, email=null, " +
                        "exibeSaldoDisponivel=null, saldoDisponivel=null, senha=null)",
                credorEntity.toString()
        );
    }
}