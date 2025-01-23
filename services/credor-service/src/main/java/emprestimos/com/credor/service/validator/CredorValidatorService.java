package emprestimos.com.credor.service.validator;

public interface CredorValidatorService {

    void validaCredorRequest(
            String cpf,
            String email
    );
}
