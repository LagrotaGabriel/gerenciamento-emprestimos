package emprestimos.com.credor.service.mapper;

import emprestimos.com.credor.models.entity.CredorEntity;
import emprestimos.com.credor.models.dto.request.CredorRequest;
import emprestimos.com.credor.models.dto.response.CredorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredorMapper {

    CredorEntity toEntity(CredorRequest credorRequest);

    CredorResponse toResponse(CredorEntity credorEntity);
}
