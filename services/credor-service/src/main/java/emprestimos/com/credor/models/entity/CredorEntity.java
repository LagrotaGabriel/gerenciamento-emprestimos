package emprestimos.com.credor.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CredorEntity
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 15/01/2025 - 00:07
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_credor")
public class CredorEntity {

    @Id
    @Column(name = "cod_credor_crd")
    @Comment("Chave primária do credor - UUID")
    private UUID id;

    @Comment("Daata e hora em que o cadastro do credor foi realizado")
    @Column(name = "ldt_datahoracadastro_crd", nullable = false, updatable = false)
    private LocalDateTime dataHoraCadastro;

    @Comment("Nome do credor")
    @Column(name = "str_nome_crd", nullable = false, length = 60)
    private String nome;

    @Comment("Cpf do credor")
    @Column(name = "str_cpf_crd", nullable = false, updatable = false, unique = true, length = 14)
    private String cpf;

    @Comment("E-mail do credor")
    @Column(name = "eml_email_crd", nullable = false, unique = true, length = 60)
    private String email;

    @Comment("Exibe saldo disponível")
    @Column(name = "bol_exibesaldo_crd", nullable = false)
    private Boolean exibeSaldoDisponivel;

    @Comment("Saldo disponível")
    @Column(name = "dbl_saldo_crd", nullable = false, scale = 2)
    private BigDecimal saldoDisponivel;

    @Comment("Senha de acesso ao sistema do credor")
    @Column(name = "str_senha_crd", nullable = false, length = 60)
    private String senha;
}
