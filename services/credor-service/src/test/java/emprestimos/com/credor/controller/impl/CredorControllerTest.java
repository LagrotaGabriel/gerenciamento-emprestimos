package emprestimos.com.credor.controller.impl;

import emprestimos.com.credor.models.dto.response.mock.CredorResponseMock;
import emprestimos.com.credor.service.core.CredorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CredorController.class)
@DisplayName("Controller: Credor")
class CredorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CredorService credorService;

    @Test
    @DisplayName("Deve retornar HttpStatus Created ao enviar POST para o endpoint /api/v1/credor")
    void deveRetornarHttpStatusCreatedAoCriarNovoCredor() throws Exception {

        when(credorService.criaNovo(any())).thenReturn(CredorResponseMock.builder().build());

        String jsonRequest = """
                        {
                            "nome": "Gabriel",
                            "cpf": "471.534.278-23",
                            "email": "gabriellagrota@gmail.com",
                            "senha": "123"
                        }
                """;

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/credor")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Gabriel"));

    }
}