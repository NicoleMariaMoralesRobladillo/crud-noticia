package pe.edu.unmsm.noticia.infrastructure.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private String title;
    private String message;
}
