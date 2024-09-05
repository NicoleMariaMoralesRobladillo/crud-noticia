package pe.edu.unmsm.noticia.infrastructure.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.infrastructure.controller.dto.NewDtoRequest;

@Mapper(componentModel = "spring")
public interface NewMessageDtoMapper {
    @Mapping(target = "id", ignore = true)
    NewMessage mapToNewMessage(NewDtoRequest newDtoRequest);
}
