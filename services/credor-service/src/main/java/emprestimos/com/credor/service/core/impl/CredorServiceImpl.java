package emprestimos.com.credor.service.core.impl;

import emprestimos.com.credor.exception.models.InternalErrorException;
import emprestimos.com.credor.models.entity.CredorEntity;
import emprestimos.com.credor.models.dto.request.CredorRequest;
import emprestimos.com.credor.models.dto.response.CredorResponse;
import emprestimos.com.credor.repository.CredorRepository;
import emprestimos.com.credor.service.core.CredorService;
import emprestimos.com.credor.service.mapper.CredorMapper;
import emprestimos.com.credor.service.validator.CredorValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CredorServiceImpl
 * Service responsável por implementar a interface CredorService
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 19/01/2025 - 22:49
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CredorServiceImpl implements CredorService {

    private final CredorRepository repository;
    private final CredorValidatorService validatorService;
    private final CredorMapper mapper;

    @Override
    @Transactional
    public CredorResponse criaNovo(CredorRequest credorRequest) {

        validatorService.validaCredorRequest(credorRequest.cpf(), credorRequest.email());

        try {
            CredorEntity credorEntityGerado = mapper.toEntity(credorRequest);

            credorEntityGerado.setId(UUID.randomUUID());
            credorEntityGerado.setDataHoraCadastro(LocalDateTime.now());
            credorEntityGerado.setExibeSaldoDisponivel(false);
            credorEntityGerado.setSaldoDisponivel(BigDecimal.ZERO);

            CredorEntity credorPersistido = repository.save(credorEntityGerado);

            return mapper.toResponse(credorPersistido);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            log.error("Ocorreu um erro de integridade de dados ao criar um novo credor: {}", dataIntegrityViolationException.getMessage());
            throw new InternalErrorException("Ocorreu um erro inesperado ao tentar criar um novo credor: " + dataIntegrityViolationException.getMessage());
        }
    }
}
