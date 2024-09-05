package pe.edu.unmsm.noticia.infrastructure.controller;

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
import pe.edu.unmsm.noticia.application.service.NewMessageService;
import pe.edu.unmsm.noticia.domain.model.NewMessage;
import pe.edu.unmsm.noticia.infrastructure.controller.dto.NewDtoRequest;
import pe.edu.unmsm.noticia.infrastructure.controller.mapper.NewMessageDtoMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/new-message")
public class NewMessageController {
    private final NewMessageService newMessageService;
    private final NewMessageDtoMapper newMessageDtoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<NewMessage> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.newMessageService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<NewMessage>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.newMessageService.findAll());
    }

    @PostMapping
    public ResponseEntity<NewMessage> save(@Valid @RequestBody NewDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.newMessageService.save(this.newMessageDtoMapper.mapToNewMessage(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewMessage> update(@PathVariable Long id, @Valid @RequestBody NewDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.newMessageService.update(id, this.newMessageDtoMapper.mapToNewMessage(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NewMessage> delete(@PathVariable Long id) {
        this.newMessageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
