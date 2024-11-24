package school.sptech.atividaderelacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.entity.Livro;
import school.sptech.atividaderelacionamento.repository.LivroRepository;
import school.sptech.atividaderelacionamento.service.LivroService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.listar();

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build(); // 204 - lista vazia
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaPorId(@PathVariable Integer id) {
        Livro livro = livroService.buscarPorId(id);
        return ResponseEntity.status(200).body(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro novoLivro) {
        Livro livroSalvo = livroService.salvar(novoLivro);

        URI uri = URI.create("/livros/" + livroSalvo.getId());
        return ResponseEntity.created(uri).body(livroSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> criar(
            @PathVariable Integer id,
            @RequestBody Livro livroAtualizacao) {
        Livro livroSalvo = livroService.atualizar(id, livroAtualizacao);
        return ResponseEntity.status(200).body(livroSalvo);
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Livro>> buscaPorTitulo(@RequestParam String tituloInformado) {
        List<Livro> livros = livroService.buscaPorTitulo(tituloInformado);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/data")
    public ResponseEntity<List<Livro>> buscaPorDataApos(@RequestParam LocalDate dataInformada) {
        List<Livro> livros = livroService.buscaPorDataPublicacao(dataInformada);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/data/titulo")
    public ResponseEntity<List<Livro>> buscaPorDataTitulo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim,
            @RequestParam String titulo
    ) {
        List<Livro> livros = livroService.buscaPorTituloDataPublicacaoEntre(dataInicio, dataFim, titulo);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/soma")
    public ResponseEntity<Double> somaPrecos() {
        return ResponseEntity.status(200).body(livroService.somaPrecos());
    }
}
