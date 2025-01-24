package emprestimos.com.credor.models.entity.mock;

import emprestimos.com.credor.models.entity.CredorEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CredorEntityMock {

    private CredorEntity credorEntity;

    private CredorEntityMock() {
    }

    public static CredorEntityMock builder() {

        CredorEntityMock builder = new CredorEntityMock();

        builder.credorEntity =
                new CredorEntity(
                        UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"),
                        LocalDateTime.of(2025, 1, 1, 0, 0, 0),
                        "Gabriel",
                        "472.535.279-22",
                        "gabriellagrota@gmail.com",
                        false,
                        BigDecimal.ZERO,
                        "123456"
                );

        return builder;
    }

    public CredorEntity build() {
        return credorEntity;
    }
}
