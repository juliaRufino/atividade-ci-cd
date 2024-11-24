package school.sptech.atividaderelacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.Autor;
import school.sptech.atividaderelacionamento.repository.AutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Integer id) {
        return autorRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }
}
