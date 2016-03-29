package com.mycompany.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.ws.model.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long>{

}
