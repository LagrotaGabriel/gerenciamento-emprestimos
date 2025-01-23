package emprestimos.com.credor_service.exception.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandartError {
    private LocalDateTime localDateTime;
    private Integer status;
    private String error;
    private String path;
}