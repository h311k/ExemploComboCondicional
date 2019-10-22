package br.rj.senacexemplocombo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rj.senacexemplocombo.domain.Cidade;
import br.rj.senacexemplocombo.domain.Estado;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

	List<Cidade> findByEstado(Estado estado);
	
}
