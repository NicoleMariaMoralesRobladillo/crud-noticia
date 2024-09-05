package pe.edu.unmsm.noticia.application.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.domain.port.input.NewMessageUseCasePort;
import pe.edu.unmsm.noticia.domain.port.output.NewMessageRepositoryPort;
import pe.edu.unmsm.noticia.infrastructure.controller.exception.NewMessageException;
import pe.edu.unmsm.noticia.util.MessageKeyUtil;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class NewMessageUseCase implements NewMessageUseCasePort {
    private final NewMessageRepositoryPort newMessageRepositoryPort;

    @Override
    public NewMessage save(NewMessage newMessage) {
        return this.newMessageRepositoryPort.save(newMessage);
    }

    @Override
    public List<NewMessage> findAll() {
        return this.newMessageRepositoryPort.findAll();
    }

    @Override
    public NewMessage findById(Long id) {
        Optional<NewMessage> newMessage = this.newMessageRepositoryPort.findById(id);
        if (newMessage.isEmpty()) {
            throw new NewMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NEW_MESSAGE_NOT_FOUND);
        }
        return newMessage.get();
    }

    @Override
    public NewMessage update(Long id, NewMessage newMessage) {
        Optional<NewMessage> newMessageFound = this.newMessageRepositoryPort.update(id, newMessage);
        if (newMessageFound.isEmpty()) {
            throw new NewMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NEW_MESSAGE_NOT_FOUND);
        }
        return newMessageFound.get();
    }

    @Override
    public void delete(Long id) {
        if (!this.newMessageRepositoryPort.delete(id)) {
            throw new NewMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NEW_MESSAGE_NOT_FOUND);
        }
    }
}
