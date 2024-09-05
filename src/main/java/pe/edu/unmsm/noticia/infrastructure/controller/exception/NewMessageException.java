package pe.edu.unmsm.noticia.infrastructure.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class NewMessageException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String title;
    private final String message;
}
