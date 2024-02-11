package pe.edu.unmsm.grupo3aclspring.domain.port.output;

import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;

import java.util.List;
import java.util.Optional;

public interface NoticeMessageRepositoryPort {
    NoticeMessage save(NoticeMessage noticeMessage);
    List<NoticeMessage> findAll();
    Optional<NoticeMessage> findById(Long id);
    Optional<NoticeMessage> update(Long id, NoticeMessage noticeMessage);
    boolean delete(Long id);
}
