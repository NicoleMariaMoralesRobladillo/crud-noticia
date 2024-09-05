package pe.edu.unmsm.noticia.domain.port.input;

import pe.edu.unmsm.noticia.domain.model.NewMessage;

import java.util.List;

public interface NewMessageUseCasePort {
    NewMessage save(NewMessage newMessage);
    List<NewMessage> findAll();
    NewMessage findById(Long id);
    NewMessage update(Long id, NewMessage newMessage);
    void delete(Long id);
}
