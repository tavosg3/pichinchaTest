package com.pichincha.clientes.model.repository;

import com.pichincha.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}
