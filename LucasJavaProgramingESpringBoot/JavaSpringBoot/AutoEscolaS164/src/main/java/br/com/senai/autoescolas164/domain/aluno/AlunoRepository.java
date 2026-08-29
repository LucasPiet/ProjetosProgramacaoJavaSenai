package br.com.senai.autoescolas164.domain.aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    public static boolean existsByIdAndAtivoFalse(Long id) {
        return false;
    }


    Page<Aluno> findAllByAtivoTrue (Pageable paginacao);
}
