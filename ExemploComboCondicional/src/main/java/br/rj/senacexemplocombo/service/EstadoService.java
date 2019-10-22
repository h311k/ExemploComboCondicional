package br.rj.senacexemplocombo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rj.senacexemplocombo.domain.Estado;
import br.rj.senacexemplocombo.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	
	public List<Estado> listAll() {
		return repository.findAll();
	}

}
