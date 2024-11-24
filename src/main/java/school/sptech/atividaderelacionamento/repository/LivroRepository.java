package school.sptech.atividaderelacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.atividaderelacionamento.entity.Livro;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    // Retorna todos os livros que possuem o título informado via RequestParam.
    List<Livro> findByTitulo(String titulo);

    // Retorna todos os livros que possuem a data de publicação informada via RequestParam.
    List<Livro> findByDataPublicacaoAfter(LocalDate data);

    // Retorna todos os livros que possuem a data de publicação entre as datas informadas e que possuem parte do título informado (ignorando case)
    List<Livro> findByDataPublicacaoBetweenAndTituloContainsIgnoreCase(LocalDate dataInicio, LocalDate dataFim, String titulo);

    // Retorna a soma dos preços dos livros.
    @Query("SELECT SUM(l.preco) FROM Livro l")
    Double somaPrecos();
}
