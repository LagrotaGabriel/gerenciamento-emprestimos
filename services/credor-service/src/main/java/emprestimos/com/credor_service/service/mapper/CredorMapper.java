package emprestimos.com.credor_service.service.mapper;

import emprestimos.com.credor_service.models.CredorEntity;
import emprestimos.com.credor_service.models.dto.request.CredorRequest;
import emprestimos.com.credor_service.models.dto.response.CredorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredorMapper {

    CredorEntity toEntity(CredorRequest credorRequest);

    CredorResponse toResponse(CredorEntity credorEntity);
}
