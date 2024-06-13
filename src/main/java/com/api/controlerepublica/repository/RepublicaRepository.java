package com.api.controlerepublica.repository;

import models.Republica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepublicaRepository extends JpaRepository<Republica, Long> {

}
