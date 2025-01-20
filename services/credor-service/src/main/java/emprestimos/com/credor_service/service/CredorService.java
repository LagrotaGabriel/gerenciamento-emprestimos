package emprestimos.com.credor_service.service;

import emprestimos.com.credor_service.models.dto.request.CredorRequest;
import emprestimos.com.credor_service.models.dto.response.CredorResponse;

public interface CredorService {

    CredorResponse criaNovo(
            CredorRequest credorRequest
    );
}
