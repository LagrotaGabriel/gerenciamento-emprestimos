package emprestimos.com.credor.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CredorRequest(

        @NotEmpty(message = "O nome deve ser informado")
        @Size(max = 60, message = "O nome deve conter no máximo {max} caracteres")
        String nome,

        @NotEmpty(message = "O CPF deve ser informado")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF informado é inválido")
        String cpf,

        @Email(message = "O e-mail informado é inválido")
        @NotEmpty(message = "O e-mail deve ser informado")
        @Size(max = 60, message = "O e-mail deve conter no máximo {max} caracteres")
        String email,

        @NotEmpty(message = "A senha deve ser informada")
        @Size(max = 25, message = "A senha deve conter no máximo {max} caracteres")
        String senha
) {
}
