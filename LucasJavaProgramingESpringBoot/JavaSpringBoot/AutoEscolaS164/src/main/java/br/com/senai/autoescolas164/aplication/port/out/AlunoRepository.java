package br.com.senai.autoescolas164.aplication.port.out;
import br.com.senai.autoescolas164.aplication.core.domain.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    public static boolean existsByIdAndAtivoFalse(Long id) {
        return false;
    }


    Page<Aluno> findAllByAtivoTrue (Pageable paginacao);
}
