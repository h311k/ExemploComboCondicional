package br.rj.senacexemplocombo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.rj.senacexemplocombo.domain.Estado;
import br.rj.senacexemplocombo.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	CidadeService service;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping("/lista")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaCidade(@RequestBody String estado) {
		try {
			return Response.status(Status.OK).entity(service.findByEstado(mapper.readValue(estado, Estado.class))).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

}
