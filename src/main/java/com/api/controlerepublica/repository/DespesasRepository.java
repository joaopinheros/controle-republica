package com.api.controlerepublica.repository;

import models.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository<Despesas, Long> {
}
