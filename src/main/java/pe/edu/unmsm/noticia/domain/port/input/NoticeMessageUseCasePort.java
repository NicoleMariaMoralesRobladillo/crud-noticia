package pe.edu.unmsm.noticia.domain.port.input;

import pe.edu.unmsm.noticia.domain.model.NoticeMessage;

import java.util.List;

public interface NoticeMessageUseCasePort {
    NoticeMessage save(NoticeMessage noticeMessage);
    List<NoticeMessage> findAll();
    NoticeMessage findById(Long id);
    NoticeMessage update(Long id, NoticeMessage noticeMessage);
    void delete(Long id);
}
