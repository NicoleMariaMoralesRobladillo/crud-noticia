package pe.edu.unmsm.grupo3aclspring.infrastructure.repository.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;
import pe.edu.unmsm.grupo3aclspring.domain.port.output.NoticeMessageRepositoryPort;
import pe.edu.unmsm.grupo3aclspring.infrastructure.repository.entity.NoticeMessageEntity;
import pe.edu.unmsm.grupo3aclspring.infrastructure.repository.jpa.NoticeMessageJpaRepository;
import pe.edu.unmsm.grupo3aclspring.infrastructure.repository.mapper.NoticeMessageRepositoryMapper;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class NoticeMessageRepositoryAdapter implements NoticeMessageRepositoryPort {
    private final NoticeMessageJpaRepository noticeMessageJpaRepository;
    private final NoticeMessageRepositoryMapper noticeMessageRepositoryMapper;

    @Override
    public NoticeMessage save(NoticeMessage noticeMessage) {
        NoticeMessageEntity noticeMessageEntity = this.noticeMessageRepositoryMapper.mapToNoticeMessageEntity(noticeMessage);
        return this.noticeMessageRepositoryMapper.mapToNoticeMessage(this.noticeMessageJpaRepository.save(noticeMessageEntity));
    }

    @Override
    public List<NoticeMessage> findAll() {
        return this.noticeMessageRepositoryMapper.mapToNoticeMessageList(this.noticeMessageJpaRepository.findAll());
    }

    @Override
    public Optional<NoticeMessage> findById(Long id) {
        return this.noticeMessageJpaRepository.findById(id)
                .map(this.noticeMessageRepositoryMapper::mapToNoticeMessage);
    }

    @Override
    public Optional<NoticeMessage> update(Long id, NoticeMessage noticeMessage) {
        Optional<NoticeMessage> noticeMessageFound = this.findById(id);
        if (noticeMessageFound.isEmpty()) {
            return Optional.empty();
        }
        noticeMessageFound.get().setContent(noticeMessage.getContent());
        return Optional.of(this.save(noticeMessageFound.get()));
    }

    @Override
    public boolean delete(Long id) {
        if (!this.noticeMessageJpaRepository.existsById(id)) {
            return false;
        }
        this.noticeMessageJpaRepository.deleteById(id);
        return true;
    }
}
