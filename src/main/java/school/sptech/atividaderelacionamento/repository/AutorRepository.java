package school.sptech.atividaderelacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.atividaderelacionamento.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
