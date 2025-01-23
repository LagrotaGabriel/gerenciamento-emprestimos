package emprestimos.com.credor.service;

import emprestimos.com.credor.models.dto.request.CredorRequest;
import emprestimos.com.credor.models.dto.response.CredorResponse;

public interface CredorService {

    CredorResponse criaNovo(
            CredorRequest credorRequest
    );
}
