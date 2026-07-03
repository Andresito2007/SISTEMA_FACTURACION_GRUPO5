package com.sistema_facturacion.GRUPITO_5.Repositorios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
}
