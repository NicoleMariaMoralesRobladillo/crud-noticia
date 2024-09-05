package pe.edu.unmsm.noticia.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.noticia.util.MessageKeyUtil;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewDtoRequest {
    @NotBlank(message = MessageKeyUtil.NEW_MESSAGE_NOT_BLANK)
    private String content;
}
