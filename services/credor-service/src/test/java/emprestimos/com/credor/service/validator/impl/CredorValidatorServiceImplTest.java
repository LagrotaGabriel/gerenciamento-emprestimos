package emprestimos.com.credor.service.validator.impl;

import emprestimos.com.credor.repository.CredorRepository;
import emprestimos.com.credor.service.validator.exceptions.CpfDoCredorJaExisteException;
import emprestimos.com.credor.service.validator.exceptions.EmailDoCredorJaExisteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Validator: CredorValidatorServiceImpl")
class CredorValidatorServiceImplTest {

    @InjectMocks
    CredorValidatorServiceImpl credorValidatorServiceImpl;

    @Mock
    CredorRepository credorRepository;

    @Test
    @DisplayName("Deve realizar validações com sucesso quando cpf e email não existem")
    void deveRealizarValidacoesComSucessoQuandoCpfEmailNaoExistem() {

        when(credorRepository.existsByCpf(any())).thenReturn(false);
        when(credorRepository.existsByEmail(any())).thenReturn(false);

        Assertions.assertDoesNotThrow(
                () -> credorValidatorServiceImpl.validaCredorRequest("12345678901", "email@gmail.com")
        );
    }

    @Test
    @DisplayName("Deve retornar erro quando cpf já existe")
    void deveRetornarErroQuandoCpfJaExiste() {

        when(credorRepository.existsByCpf(any())).thenReturn(true);

        Assertions.assertThrows(
                CpfDoCredorJaExisteException.class,
                () -> credorValidatorServiceImpl.validaCredorRequest("12345678901", "email@gmail.com")
        );
    }

    @Test
    @DisplayName("Deve retornar erro quando email já existe")
    void deveRetornarErroQuandoEmailJaExiste() {

        when(credorRepository.existsByCpf(any())).thenReturn(false);
        when(credorRepository.existsByEmail(any())).thenReturn(true);

        Assertions.assertThrows(
                EmailDoCredorJaExisteException.class,
                () -> credorValidatorServiceImpl.validaCredorRequest("12345678901", "email@gmail.com")
        );
    }
}
