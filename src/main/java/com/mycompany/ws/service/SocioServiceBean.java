package com.mycompany.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ws.model.Socio;
import com.mycompany.ws.repository.SocioRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SocioServiceBean implements SocioService {

	@Autowired
	private SocioRepository socioRepository;

	@Override
	public Collection<Socio> findAll() {
		Collection<Socio> socios = socioRepository.findAll();
		return socios;
	}

	@Override
	@Cacheable(value = "socios", key = "#idSocio")
	public Socio findOne(Long idSocio) {
		Socio socio = socioRepository.findOne(idSocio);
		return socio;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CachePut(value = "socios", key = "#result.idSocio")
	public Socio create(Socio socio) {

		// Previene que la entidad no exista con anticipacion en el repository
		if (socio.getIdSocio() != null) {
			// No puede crear socio con este idSocio
			return null;
		}

		Socio savedSocio = socioRepository.save(socio);
		return savedSocio;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Socio update(Socio socio) {

		// Previene que la entidad exista con anticipacion en el repository
		Socio socioToUpdate = findOne(socio.getIdSocio());
		if (socioToUpdate == null) {
			return null;
		}

		socioToUpdate.setNombresSocio(socio.getNombresSocio());
		socioToUpdate.setApellidosSocio(socio.getApellidosSocio());
		socioToUpdate.setDNISocio(socio.getDNISocio());
		socioToUpdate.setFechaNacimientoSocio(socio.getFechaNacimientoSocio());
		socioToUpdate.setTelefonoSocio(socio.getTelefonoSocio());
		socioToUpdate.setURLImagenPerfilSocio(socio.getURLImagenPerfilSocio());
		socioToUpdate.setURLImagenHuellaDactilarSocio(socio.getURLImagenHuellaDactilarSocio());
		socioToUpdate.setURLImagenFirmaSocio(socio.getURLImagenFirmaSocio());

		Socio updatedSocio = socioRepository.save(socioToUpdate);
		return updatedSocio;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CacheEvict(value = "socios", key = "#idSocio")
	public void delete(Long idSocio) {
		socioRepository.delete(idSocio);
	}

	@Override
	@CacheEvict(value = "socios", allEntries = true)
	public void evictCache() {
		

	}

}
