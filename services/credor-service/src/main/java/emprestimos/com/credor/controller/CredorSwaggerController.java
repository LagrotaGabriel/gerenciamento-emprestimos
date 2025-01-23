package emprestimos.com.credor.controller;

import emprestimos.com.credor.models.dto.request.CredorRequest;
import emprestimos.com.credor.models.dto.response.CredorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CredorSwaggerController {

    @Tag(name = "Cadastro de novo credor")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a criação de um novo credor", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Credor persistido com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CredorResponse.class))})
    })
    ResponseEntity<CredorResponse> criaNovo(@Valid @RequestBody CredorRequest credorRequest);
}
