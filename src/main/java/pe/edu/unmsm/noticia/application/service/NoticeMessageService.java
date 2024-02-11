package pe.edu.unmsm.noticia.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.noticia.application.usecase.NoticeMessageUseCase;
import pe.edu.unmsm.noticia.domain.model.NoticeMessage;
import pe.edu.unmsm.noticia.domain.port.input.NoticeMessageUseCasePort;

import java.util.List;

@Service
@AllArgsConstructor
public class NoticeMessageService implements NoticeMessageUseCasePort {
    private final NoticeMessageUseCase noticeMessageUseCase;

    @Override
    public NoticeMessage save(NoticeMessage noticeMessage) {
        return this.noticeMessageUseCase.save(noticeMessage);
    }

    @Override
    public List<NoticeMessage> findAll() {
        return this.noticeMessageUseCase.findAll();
    }

    @Override
    public NoticeMessage findById(Long id) {
        return this.noticeMessageUseCase.findById(id);
    }

    @Override
    public NoticeMessage update(Long id, NoticeMessage noticeMessage) {
        return this.noticeMessageUseCase.update(id, noticeMessage);
    }

    @Override
    public void delete(Long id) {
        this.noticeMessageUseCase.delete(id);
    }
}
