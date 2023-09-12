package br.com.dfense.rhservice.repository;

import br.com.dfense.rhservice.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
