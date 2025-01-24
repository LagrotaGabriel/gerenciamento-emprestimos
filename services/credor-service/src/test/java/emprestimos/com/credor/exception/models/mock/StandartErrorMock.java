package emprestimos.com.credor.exception.models.mock;

import emprestimos.com.credor.exception.models.StandartError;

import java.time.LocalDateTime;

public class StandartErrorMock {

    private StandartError standartError;

    private StandartErrorMock() {
    }

    public static StandartErrorMock builder() {

        StandartErrorMock builder = new StandartErrorMock();

        builder.standartError =
                new StandartError(
                        LocalDateTime.of(2021, 10, 1, 10, 0, 0),
                        400,
                        "Bad Request",
                        "/api/v1/credor"
                );

        return builder;
    }

    public StandartError build() {
        return standartError;
    }
}