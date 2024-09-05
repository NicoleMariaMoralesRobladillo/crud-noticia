package pe.edu.unmsm.noticia.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.noticia.infrastructure.repository.entity.NewMessageEntity;

@Repository
public interface NewMessageJpaRepository extends JpaRepository<NewMessageEntity, Long> {
}
