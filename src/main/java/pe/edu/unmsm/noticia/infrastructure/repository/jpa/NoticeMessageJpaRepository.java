package pe.edu.unmsm.noticia.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.noticia.infrastructure.repository.entity.NoticeMessageEntity;

@Repository
public interface NoticeMessageJpaRepository extends JpaRepository<NoticeMessageEntity, Long> {
}
