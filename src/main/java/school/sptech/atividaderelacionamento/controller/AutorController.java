package school.sptech.atividaderelacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.entity.Autor;
import school.sptech.atividaderelacionamento.service.AutorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor novoAutor) {
        Autor autorSalvo = autorService.salvar(novoAutor);

        URI uri = URI.create("/autores/" + autorSalvo.getId());
        return ResponseEntity.created(uri).body(autorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.listar();

        if (autores.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscaPorId(Integer id) {
        Autor autor = autorService.buscarPorId(id);
        return ResponseEntity.status(200).body(autor);
    }
}
