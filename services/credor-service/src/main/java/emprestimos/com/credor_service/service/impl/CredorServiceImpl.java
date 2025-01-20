package emprestimos.com.credor_service.service.impl;

import emprestimos.com.credor_service.models.CredorEntity;
import emprestimos.com.credor_service.models.dto.request.CredorRequest;
import emprestimos.com.credor_service.models.dto.response.CredorResponse;
import emprestimos.com.credor_service.repository.CredorRepository;
import emprestimos.com.credor_service.service.CredorService;
import emprestimos.com.credor_service.service.mapper.CredorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CredorServiceImpl
 * Service responsável por implementar a interface CredorService
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 19/01/2025 - 22:49
 */
@Service
@RequiredArgsConstructor
public class CredorServiceImpl implements CredorService {

    private final CredorRepository credorRepository;
    private final CredorMapper credorMapper;

    @Override
    public CredorResponse criaNovo(CredorRequest credorRequest) {

        CredorEntity credorEntityGerado = credorMapper.toEntity(credorRequest);

        credorEntityGerado.setId(UUID.randomUUID());
        credorEntityGerado.setDataHoraCadastro(LocalDateTime.now());
        credorEntityGerado.setExibeSaldoDisponivel(false);
        credorEntityGerado.setSaldoDisponivel(BigDecimal.ZERO);

        CredorEntity credorPersistido = credorRepository.save(credorEntityGerado);

        return credorMapper.toResponse(credorPersistido);
    }
}
