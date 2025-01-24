package emprestimos.com.credor.models.dto.response.mock;

import emprestimos.com.credor.models.dto.response.CredorResponse;

import java.util.UUID;

public class CredorResponseMock {

    private CredorResponse credorResponse;

    private CredorResponseMock() {
    }

    public static CredorResponseMock builder() {

        CredorResponseMock builder = new CredorResponseMock();

        builder.credorResponse =
                new CredorResponse(
                        UUID.fromString("bcdc5961-b48b-424f-8958-746713fffc92"),
                        "Gabriel",
                        "gabriellagrota@gmail.com",
                        "472.535.279-22"
                );

        return builder;
    }

    public CredorResponse build() {
        return credorResponse;
    }
}
