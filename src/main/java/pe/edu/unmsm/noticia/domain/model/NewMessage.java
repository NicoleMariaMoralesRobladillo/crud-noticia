package pe.edu.unmsm.noticia.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewMessage {
    private Long id;
    private String content;
}
