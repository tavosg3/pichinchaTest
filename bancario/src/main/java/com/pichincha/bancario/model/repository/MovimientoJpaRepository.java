package com.pichincha.bancario.model.repository;

import com.pichincha.bancario.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoJpaRepository extends JpaRepository<Movimiento, Long> {
}
