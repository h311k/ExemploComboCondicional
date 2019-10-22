package br.rj.senacexemplocombo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rj.senacexemplocombo.domain.Cidade;
import br.rj.senacexemplocombo.domain.Estado;
import br.rj.senacexemplocombo.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repository;
	
	public List<Cidade> findByEstado(Estado estado) {
		return repository.findByEstado(estado);
	}
}
