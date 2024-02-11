package pe.edu.unmsm.grupo3aclspring.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeMessage {
    private Long id;
    private String content;
}
