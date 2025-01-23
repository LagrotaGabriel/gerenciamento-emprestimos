package emprestimos.com.credor.service.validator.impl;

import emprestimos.com.credor.repository.CredorRepository;
import emprestimos.com.credor.service.validator.CredorValidatorService;
import emprestimos.com.credor.service.validator.exceptions.CpfDoCredorJaExisteException;
import emprestimos.com.credor.service.validator.exceptions.EmailDoCredorJaExisteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CredorValidatorServiceImpl
 * Classe responsável por realizar as validações referentes à criação de um novo credor
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 23/01/2025 - 12:16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CredorValidatorServiceImpl implements CredorValidatorService {

    private final CredorRepository credorRepository;

    @Override
    public void validaCredorRequest(String cpf,
                                    String email) {

        if (credorRepository.existsByCpf(cpf)) {
            log.warn("Já existe um credor cadastrado com o CPF informado: {}", cpf);
            throw new CpfDoCredorJaExisteException("Já existe um credor cadastrado com o CPF informado");
        }

        if (credorRepository.existsByEmail(email)) {
            log.warn("Já existe um credor cadastrado com o EMAIL informado: {}", email);
            throw new EmailDoCredorJaExisteException("Já existe um credor cadastrado com o EMAIL informado");
        }
    }
}
