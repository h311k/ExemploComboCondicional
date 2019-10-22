package br.rj.senacexemplocombo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.rj.senacexemplocombo.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoService service;
	
	private ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/lista")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listAll() throws JsonProcessingException {
		return Response.status(Status.OK).entity(mapper.writeValueAsString(service.listAll())).build();
	}
	
}
