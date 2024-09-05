package pe.edu.unmsm.noticia.infrastructure.repository.mapper;

import org.mapstruct.Mapper;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.infrastructure.repository.entity.NewMessageEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewMessageRepositoryMapper {
    NewMessageEntity mapToNewMessageEntity(NewMessage newMessage);
    NewMessage mapToNewMessage(NewMessageEntity newMessage);
    List<NewMessage> mapToNewMessageList(List<NewMessageEntity> newMessageEntityList);
}
