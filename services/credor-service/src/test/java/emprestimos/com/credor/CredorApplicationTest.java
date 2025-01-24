package emprestimos.com.credor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class CredorApplicationTest {

    @Test
    void contextLoads() {
        // Deve verificar contexto de inicialização da aplicação
    }

    @Test
    @DisplayName("Deve executar método main com sucesso")
    void deveExecutarMetodoMainComSucesso() {
        assertDoesNotThrow(() -> {
            String[] args = {};
            CredorApplication.main(args);
        });
    }
}
