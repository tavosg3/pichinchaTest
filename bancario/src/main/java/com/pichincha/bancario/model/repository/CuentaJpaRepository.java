package com.pichincha.bancario.model.repository;

import com.pichincha.bancario.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaJpaRepository extends JpaRepository<Cuenta, Long> {
}
