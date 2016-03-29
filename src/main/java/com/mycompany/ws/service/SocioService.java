package com.mycompany.ws.service;

import java.util.Collection;

import com.mycompany.ws.model.Socio;

public interface SocioService {
	
	Collection<Socio> findAll();
	Socio findOne(Long idSocio);
	Socio create(Socio socio);
	Socio update(Socio socio);
	void delete(Long idSocio);
	void evictCache();

}
