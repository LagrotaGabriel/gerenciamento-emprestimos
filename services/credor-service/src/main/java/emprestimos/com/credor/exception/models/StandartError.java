package emprestimos.com.credor.exception.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class StandartError {
    private LocalDateTime localDateTime;
    private Integer status;
    private String error;
    private String path;
}