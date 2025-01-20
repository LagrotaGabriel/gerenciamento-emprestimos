package emprestimos.com.credor_service.repository;

import emprestimos.com.credor_service.models.CredorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredorRepository extends JpaRepository<CredorEntity, UUID> {
}