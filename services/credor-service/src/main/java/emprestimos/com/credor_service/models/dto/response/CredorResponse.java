package emprestimos.com.credor_service.models.dto.response;

import java.util.UUID;

public record CredorResponse(

        UUID id,
        String nome,
        String email,
        String cpf
) {
}
