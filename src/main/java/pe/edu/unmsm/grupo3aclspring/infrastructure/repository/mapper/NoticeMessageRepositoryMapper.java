package pe.edu.unmsm.grupo3aclspring.infrastructure.repository.mapper;

import org.mapstruct.Mapper;
import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;
import pe.edu.unmsm.grupo3aclspring.infrastructure.repository.entity.NoticeMessageEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoticeMessageRepositoryMapper {
    NoticeMessageEntity mapToNoticeMessageEntity(NoticeMessage noticeMessage);
    NoticeMessage mapToNoticeMessage(NoticeMessageEntity noticeMessage);
    List<NoticeMessage> mapToNoticeMessageList(List<NoticeMessageEntity> noticeMessageEntityList);
}
