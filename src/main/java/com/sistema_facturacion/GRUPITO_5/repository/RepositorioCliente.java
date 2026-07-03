package com.sistema_facturacion.GRUPITO_5.repository;

import com.sistema_facturacion.GRUPITO_5.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
}
