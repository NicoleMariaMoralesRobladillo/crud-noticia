package pe.edu.unmsm.grupo3aclspring.infrastructure.repository.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import pe.edu.unmsm.grupo3aclspring.infrastructure.repository.entity.NoticeMessageEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoticeMessageJpaRepositoryTest {
    NoticeMessageJpaRepository repo;

    @Test
    @WithMockUser(username = "manager")
    public void
    givenUserManager_whenFindAllMessage_thenReturnFirstMessage(){
        List<NoticeMessageEntity> details = this.repo.findAll();

        assertNotNull(details);
        assertEquals(1, details.size());
        assertEquals(1,details.get(0).getId());
    }
}