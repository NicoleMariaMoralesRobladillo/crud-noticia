package pe.edu.unmsm.grupo3aclspring.infrastructure.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;
import pe.edu.unmsm.grupo3aclspring.infrastructure.controller.dto.NoticeMessageDtoRequest;

@Mapper(componentModel = "spring")
public interface NoticeMessageDtoMapper {
    @Mapping(target = "id", ignore = true)
    NoticeMessage mapToNoticeMessage(NoticeMessageDtoRequest noticeMessageDtoRequest);
}
