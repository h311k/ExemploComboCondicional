package br.rj.senacexemplocombo.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.rj.senacexemplocombo.domain.Cidade;
import br.rj.senacexemplocombo.domain.Estado;
import br.rj.senacexemplocombo.repository.CidadeRepository;
import br.rj.senacexemplocombo.repository.EstadoRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<Estado> estados = new ArrayList<>();
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		estados.add(estado);
		estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		estados.add(estado);
		estado = new Estado();
		estado.setNome("Minas Gerais");
		estado.setSigla("MG");
		estados.add(estado);
		estado = new Estado();
		estado.setNome("Espírito Santo");
		estado.setSigla("ES");
		estados.add(estado);
		estadoRepository.saveAll(estados);
		
		List<Cidade> cidades = new ArrayList<>();
		Cidade cidade = new Cidade();
		cidade.setEstado(estados.get(0));
		cidade.setNome("Rio de Janeiro");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(0));
		cidade.setNome("Niterói");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(0));
		cidade.setNome("Belford Roxo");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(1));
		cidade.setNome("São Paulo");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(1));
		cidade.setNome("Santos");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(1));
		cidade.setNome("Cubatão");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(2));
		cidade.setNome("Belo Horizonte");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(2));
		cidade.setNome("Juíz de Fora");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(2));
		cidade.setNome("Ipatinga");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(3));
		cidade.setNome("Vitória");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(3));
		cidade.setNome("Vila Velha");
		cidades.add(cidade);
		cidade = new Cidade();
		cidade.setEstado(estados.get(3));
		cidade.setNome("Guaraparí");
		cidades.add(cidade);
		cidadeRepository.saveAll(cidades);
	}

}
