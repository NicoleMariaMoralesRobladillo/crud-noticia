package pe.edu.unmsm.grupo3aclspring.infrastructure.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.unmsm.grupo3aclspring.application.service.NoticeMessageService;
import pe.edu.unmsm.grupo3aclspring.domain.model.NoticeMessage;
import pe.edu.unmsm.grupo3aclspring.infrastructure.controller.dto.NoticeMessageDtoRequest;
import pe.edu.unmsm.grupo3aclspring.infrastructure.controller.mapper.NoticeMessageDtoMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/notice-message")
public class NoticeMessageController {
    private final NoticeMessageService noticeMessageService;
    private final NoticeMessageDtoMapper noticeMessageDtoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<NoticeMessage> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.noticeMessageService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<NoticeMessage>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.noticeMessageService.findAll());
    }

    @PostMapping
    public ResponseEntity<NoticeMessage> save(@Valid @RequestBody NoticeMessageDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.noticeMessageService.save(this.noticeMessageDtoMapper.mapToNoticeMessage(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeMessage> update(@PathVariable Long id, @Valid @RequestBody NoticeMessageDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.noticeMessageService.update(id, this.noticeMessageDtoMapper.mapToNoticeMessage(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NoticeMessage> delete(@PathVariable Long id) {
        this.noticeMessageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
