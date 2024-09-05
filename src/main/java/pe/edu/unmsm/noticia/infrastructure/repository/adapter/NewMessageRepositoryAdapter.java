package pe.edu.unmsm.noticia.infrastructure.repository.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.domain.port.output.NewMessageRepositoryPort;
import pe.edu.unmsm.noticia.infrastructure.repository.entity.NewMessageEntity;
import pe.edu.unmsm.noticia.infrastructure.repository.jpa.NewMessageJpaRepository;
import pe.edu.unmsm.noticia.infrastructure.repository.mapper.NewMessageRepositoryMapper;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class NewMessageRepositoryAdapter implements NewMessageRepositoryPort {
    private final NewMessageJpaRepository newMessageJpaRepository;
    private final NewMessageRepositoryMapper newMessageRepositoryMapper;

    @Override
    public NewMessage save(NewMessage newMessage) {
        NewMessageEntity newMessageEntity = this.newMessageRepositoryMapper.mapToNewMessageEntity(newMessage);
        return this.newMessageRepositoryMapper.mapToNewMessage(this.newMessageJpaRepository.save(newMessageEntity));
    }

    @Override
    public List<NewMessage> findAll() {
        return this.newMessageRepositoryMapper.mapToNewMessageList(this.newMessageJpaRepository.findAll());
    }

    @Override
    public Optional<NewMessage> findById(Long id) {
        return this.newMessageJpaRepository.findById(id)
                .map(this.newMessageRepositoryMapper::mapToNewMessage);
    }

    @Override
    public Optional<NewMessage> update(Long id, NewMessage newMessage) {
        Optional<NewMessage> newMessageFound = this.findById(id);
        if (newMessageFound.isEmpty()) {
            return Optional.empty();
        }
        newMessageFound.get().setContent(newMessage.getContent());
        return Optional.of(this.save(newMessageFound.get()));
    }

    @Override
    public boolean delete(Long id) {
        if (!this.newMessageJpaRepository.existsById(id)) {
            return false;
        }
        this.newMessageJpaRepository.deleteById(id);
        return true;
    }
}
