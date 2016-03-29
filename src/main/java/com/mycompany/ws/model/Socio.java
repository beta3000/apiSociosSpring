package com.mycompany.ws.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Socio {

	@Id
	@GeneratedValue
	private Long idSocio;
	private String nombresSocio;
	private String apellidosSocio;
	private int DNISocio;
	private Date fechaNacimientoSocio;
	private String telefonoSocio;
	private String URLImagenPerfilSocio;
	private String URLImagenHuellaDactilarSocio;
	private String URLImagenFirmaSocio;

	public Socio() {

	}

	public Long getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Long idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombresSocio() {
		return nombresSocio;
	}

	public void setNombresSocio(String nombresSocio) {
		this.nombresSocio = nombresSocio;
	}

	public String getApellidosSocio() {
		return apellidosSocio;
	}

	public void setApellidosSocio(String apellidosSocio) {
		this.apellidosSocio = apellidosSocio;
	}

	public int getDNISocio() {
		return DNISocio;
	}

	public void setDNISocio(int dNISocio) {
		DNISocio = dNISocio;
	}

	public Date getFechaNacimientoSocio() {
		return fechaNacimientoSocio;
	}

	public void setFechaNacimientoSocio(Date fechaNacimientoSocio) {
		this.fechaNacimientoSocio = fechaNacimientoSocio;
	}

	public String getTelefonoSocio() {
		return telefonoSocio;
	}

	public void setTelefonoSocio(String telefonoSocio) {
		this.telefonoSocio = telefonoSocio;
	}

	public String getURLImagenPerfilSocio() {
		return URLImagenPerfilSocio;
	}

	public void setURLImagenPerfilSocio(String uRLImagenPerfilSocio) {
		URLImagenPerfilSocio = uRLImagenPerfilSocio;
	}

	public String getURLImagenHuellaDactilarSocio() {
		return URLImagenHuellaDactilarSocio;
	}

	public void setURLImagenHuellaDactilarSocio(String uRLImagenHuellaDactilarSocio) {
		URLImagenHuellaDactilarSocio = uRLImagenHuellaDactilarSocio;
	}

	public String getURLImagenFirmaSocio() {
		return URLImagenFirmaSocio;
	}

	public void setURLImagenFirmaSocio(String uRLImagenFirmaSocio) {
		URLImagenFirmaSocio = uRLImagenFirmaSocio;
	}

}
