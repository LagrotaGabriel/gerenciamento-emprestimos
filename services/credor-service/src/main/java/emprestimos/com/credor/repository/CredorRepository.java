package emprestimos.com.credor.repository;

import emprestimos.com.credor.models.CredorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredorRepository extends JpaRepository<CredorEntity, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}