package pe.edu.unmsm.grupo3aclspring.infrastructure.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class NoticeMessageException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String title;
    private final String message;
}
