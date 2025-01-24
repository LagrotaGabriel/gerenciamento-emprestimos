package emprestimos.com.credor.service.core.impl;

import emprestimos.com.credor.exception.models.InternalErrorException;
import emprestimos.com.credor.models.dto.request.mock.CredorRequestMock;
import emprestimos.com.credor.models.dto.response.CredorResponse;
import emprestimos.com.credor.models.dto.response.mock.CredorResponseMock;
import emprestimos.com.credor.models.entity.mock.CredorEntityMock;
import emprestimos.com.credor.repository.CredorRepository;
import emprestimos.com.credor.service.mapper.CredorMapper;
import emprestimos.com.credor.service.validator.CredorValidatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ServiceImpl: Credor")
class CredorServiceImplTest {

    @InjectMocks
    CredorServiceImpl credorServiceImpl;

    @Mock
    CredorValidatorService credorValidatorService;

    @Mock
    CredorMapper credorMapper;

    @Mock
    CredorRepository credorRepository;

    @Test
    @DisplayName("Deve testar criação de novo credor com sucesso na criação")
    void deveTestarCriacaoDeNovoCredorComSucessoNaCriacao() {

        doNothing().when(credorValidatorService).validaCredorRequest(any(), any());

        when(credorMapper.toEntity(any())).thenReturn(CredorEntityMock.builder().build());
        when(credorRepository.save(any())).thenReturn(CredorEntityMock.builder().build());
        when(credorMapper.toResponse(any())).thenReturn(CredorResponseMock.builder().build());

        CredorResponse credorResponse = credorServiceImpl.criaNovo(CredorRequestMock.builder().build());

        Assertions.assertEquals(
                "CredorResponse[id=bcdc5961-b48b-424f-8958-746713fffc92, nome=Gabriel, " +
                        "email=gabriellagrota@gmail.com, cpf=472.535.279-22]",
                credorResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar criação de novo credor com lançamento de DataIntegrityViolationException")
    void deveTestarCriacaoDeNovoCredorComLancamentoDeDataIntegrityViolationException() {

        doNothing().when(credorValidatorService).validaCredorRequest(any(), any());
        when(credorMapper.toEntity(any())).thenReturn(CredorEntityMock.builder().build());

        doThrow(new DataIntegrityViolationException("Erro interno mock"))
                .when(credorRepository)
                .save(any());

        Assertions.assertThrows((InternalErrorException.class), () ->
                credorServiceImpl.criaNovo(
                        CredorRequestMock.builder().build()
                )
        );
    }
}
