package pe.edu.unmsm.noticia.domain.port.output;

import pe.edu.unmsm.noticia.domain.model.NewMessage;

import java.util.List;
import java.util.Optional;

public interface NewMessageRepositoryPort {
    NewMessage save(NewMessage newMessage);
    List<NewMessage> findAll();
    Optional<NewMessage> findById(Long id);
    Optional<NewMessage> update(Long id, NewMessage newMessage);
    boolean delete(Long id);
}
