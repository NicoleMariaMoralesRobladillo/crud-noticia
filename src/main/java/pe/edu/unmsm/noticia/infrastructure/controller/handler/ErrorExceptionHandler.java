package pe.edu.unmsm.noticia.infrastructure.controller.handler;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.edu.unmsm.noticia.infrastructure.controller.dto.ErrorResponse;
import pe.edu.unmsm.noticia.infrastructure.controller.exception.NewMessageException;
import pe.edu.unmsm.noticia.util.MessageKeyUtil;

@RestControllerAdvice
@AllArgsConstructor
public class ErrorExceptionHandler {
    @ExceptionHandler(NewMessageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ErrorResponse handleNewMessageException(NewMessageException exception) {
        return ErrorResponse.builder()
                .title(MessageKeyUtil.NOT_FOUND_TITLE)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class,
            ConstraintViolationException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorResponse handleBadRequestException(Exception exception) {
        return ErrorResponse.builder()
                .title(MessageKeyUtil.BAD_REQUEST_TITLE)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ErrorResponse handleInternalServerError(Exception exception) {
        return ErrorResponse.builder()
                .title(MessageKeyUtil.INTERNAL_SERVER_ERROR_TITLE)
                .message(exception.getMessage())
                .build();
    }
}
