package emprestimos.com.credor.models.dto.response;

import java.util.UUID;

public record CredorResponse(

        UUID id,
        String nome,
        String email,
        String cpf
) {
}
