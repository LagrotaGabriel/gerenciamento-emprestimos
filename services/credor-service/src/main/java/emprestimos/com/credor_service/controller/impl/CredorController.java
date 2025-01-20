package emprestimos.com.credor_service.controller.impl;

import emprestimos.com.credor_service.controller.CredorSwaggerController;
import emprestimos.com.credor_service.models.dto.request.CredorRequest;
import emprestimos.com.credor_service.models.dto.response.CredorResponse;
import emprestimos.com.credor_service.service.CredorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CredorController
 * Controller responsável por implementar os endpoints da interface CredorSwaggerController
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 19/01/2025 - 23:15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credor")
public class CredorController implements CredorSwaggerController {

    private final CredorService credorService;

    @Override
    @PostMapping
    public ResponseEntity<CredorResponse> criaNovo(@Valid @RequestBody CredorRequest credorRequest) {
        log.info("Endpoint responsável pela de criação de novo credor acessado");
        return ResponseEntity.ok().body(credorService.criaNovo(credorRequest));
    }
}
