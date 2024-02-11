package pe.edu.unmsm.grupo3aclspring.domain.port.input;

import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;

import java.util.List;

public interface NoticeMessageUseCasePort {
    NoticeMessage save(NoticeMessage noticeMessage);
    List<NoticeMessage> findAll();
    NoticeMessage findById(Long id);
    NoticeMessage update(Long id, NoticeMessage noticeMessage);
    void delete(Long id);
}
