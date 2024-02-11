package pe.edu.unmsm.noticia.infrastructure.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.unmsm.noticia.domain.model.NoticeMessage;
import pe.edu.unmsm.noticia.infrastructure.controller.dto.NoticeMessageDtoRequest;

@Mapper(componentModel = "spring")
public interface NoticeMessageDtoMapper {
    @Mapping(target = "id", ignore = true)
    NoticeMessage mapToNoticeMessage(NoticeMessageDtoRequest noticeMessageDtoRequest);
}
