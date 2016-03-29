package com.mycompany.ws.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ws.model.Socio;
import com.mycompany.ws.service.SocioService;

@RestController
public class SocioController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SocioService socioService;

	@RequestMapping(value = "/api/socio", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Socio>> getSocios() {
		logger.info("> getSocios");
		Collection<Socio> socios = socioService.findAll();
		logger.info("< getSocios");
		return new ResponseEntity<Collection<Socio>>(socios, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/socio/{idSocio}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Socio> getSocio(@PathVariable("idSocio") Long idSocio){
		logger.info("> getSocio id:{}", idSocio);
		Socio socio = socioService.findOne(idSocio);
		if (socio == null) {
			return new ResponseEntity<Socio>(HttpStatus.NOT_FOUND);
		}
		logger.info("< getSocio id:{}", idSocio);
		return new ResponseEntity<Socio>(socio, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/socio",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Socio> createSocio(@RequestBody Socio socio){
		logger.info("> createSocio");
		Socio savedSocio = socioService.create(socio);
		logger.info("< createSocio");
		return new ResponseEntity<Socio>(savedSocio, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/api/socio/{idSocio}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Socio> updateSocio(@RequestBody Socio socio){
		logger.info("> updatedSocio idSocio:{}", socio.getIdSocio());
		Socio updatedSocio = socioService.update(socio);
		if (updatedSocio == null) {
			return new ResponseEntity<Socio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("< updatedSocio idSocio:{}", socio.getIdSocio());
		return new ResponseEntity<Socio>(updatedSocio, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/socio/{idSocio}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Socio> deleteSocio(@PathVariable("idSocio") Long idSocio, @RequestBody Socio socio){
		logger.info("> deleteSocio idSocio:{}", idSocio);
		socioService.delete(idSocio);
		logger.info("< deleteSocio idSocio:{}", idSocio);
		return new ResponseEntity<Socio>(HttpStatus.NO_CONTENT);
	}
}
