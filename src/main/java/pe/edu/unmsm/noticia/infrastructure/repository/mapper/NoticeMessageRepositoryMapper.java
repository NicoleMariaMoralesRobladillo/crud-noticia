package pe.edu.unmsm.noticia.infrastructure.repository.mapper;

import org.mapstruct.Mapper;
import pe.edu.unmsm.noticia.domain.model.NoticeMessage;
import pe.edu.unmsm.noticia.infrastructure.repository.entity.NoticeMessageEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoticeMessageRepositoryMapper {
    NoticeMessageEntity mapToNoticeMessageEntity(NoticeMessage noticeMessage);
    NoticeMessage mapToNoticeMessage(NoticeMessageEntity noticeMessage);
    List<NoticeMessage> mapToNoticeMessageList(List<NoticeMessageEntity> noticeMessageEntityList);
}
