package pe.edu.unmsm.noticia.application.usecase;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.noticia.domain.model.NoticeMessage;
import pe.edu.unmsm.noticia.domain.port.input.NoticeMessageUseCasePort;
import pe.edu.unmsm.noticia.domain.port.output.NoticeMessageRepositoryPort;
import pe.edu.unmsm.noticia.infrastructure.controller.exception.NoticeMessageException;
import pe.edu.unmsm.noticia.util.MessageKeyUtil;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class NoticeMessageUseCase implements NoticeMessageUseCasePort {
    private final NoticeMessageRepositoryPort noticeMessageRepositoryPort;

    @Override
    public NoticeMessage save(NoticeMessage noticeMessage) {
        return this.noticeMessageRepositoryPort.save(noticeMessage);
    }

    @Override
    public List<NoticeMessage> findAll() {
        return this.noticeMessageRepositoryPort.findAll();
    }

    @Override
    public NoticeMessage findById(Long id) {
        Optional<NoticeMessage> noticeMessage = this.noticeMessageRepositoryPort.findById(id);
        if (noticeMessage.isEmpty()) {
            throw new NoticeMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NOTICE_MESSAGE_NOT_FOUND);
        }
        return noticeMessage.get();
    }

    @Override
    public NoticeMessage update(Long id, NoticeMessage noticeMessage) {
        Optional<NoticeMessage> noticeMessageFound = this.noticeMessageRepositoryPort.update(id, noticeMessage);
        if (noticeMessageFound.isEmpty()) {
            throw new NoticeMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NOTICE_MESSAGE_NOT_FOUND);
        }
        return noticeMessageFound.get();
    }

    @Override
    public void delete(Long id) {
        if (!this.noticeMessageRepositoryPort.delete(id)) {
            throw new NoticeMessageException(HttpStatus.NOT_FOUND,
                    MessageKeyUtil.NOT_FOUND_TITLE, MessageKeyUtil.NOTICE_MESSAGE_NOT_FOUND);
        }
    }
}
