package emprestimos.com.credor.exception.models.mock;

import emprestimos.com.credor.exception.models.InternalErrorException;

public class InternalErrorExceptionMock {

    private InternalErrorException internalErrorException;

    private InternalErrorExceptionMock() {
    }

    public static InternalErrorExceptionMock builder() {

        InternalErrorExceptionMock builder = new InternalErrorExceptionMock();

        builder.internalErrorException =
                new InternalErrorException(
                        "Internal Server Error"
                );

        return builder;
    }

    public InternalErrorException build() {
        return internalErrorException;
    }
}
