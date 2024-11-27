package com.ramitax.repository;

import com.ramitax.model.entity.ListaPrecios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPreciosRepository extends JpaRepository<ListaPrecios, Long> {
}
