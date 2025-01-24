package emprestimos.com.credor.models.dto.request.mock;

import emprestimos.com.credor.models.dto.request.CredorRequest;

public class CredorRequestMock {

    private CredorRequest credorRequest;

    private CredorRequestMock() {
    }

    public static CredorRequestMock builder() {

        CredorRequestMock builder = new CredorRequestMock();

        builder.credorRequest =
                new CredorRequest(
                        "Gabriel",
                        "472.535.279-22",
                        "gabriellagrota@gmail.com",
                        "123456"
                );

        return builder;
    }

    public CredorRequest build() {
        return credorRequest;
    }
}
