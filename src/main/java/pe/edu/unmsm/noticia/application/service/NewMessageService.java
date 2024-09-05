package pe.edu.unmsm.noticia.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.noticia.application.usecase.NewMessageUseCase;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.domain.port.input.NewMessageUseCasePort;

import java.util.List;

@Service
@AllArgsConstructor
public class NewMessageService implements NewMessageUseCasePort {
    private final NewMessageUseCase newMessageUseCase;

    @Override
    public NewMessage save(NewMessage newMessage) {
        return this.newMessageUseCase.save(newMessage);
    }

    @Override
    public List<NewMessage> findAll() {
        return this.newMessageUseCase.findAll();
    }

    @Override
    public NewMessage findById(Long id) {
        return this.newMessageUseCase.findById(id);
    }

    @Override
    public NewMessage update(Long id, NewMessage newMessage) {
        return this.newMessageUseCase.update(id, newMessage);
    }

    @Override
    public void delete(Long id) {
        this.newMessageUseCase.delete(id);
    }
}
