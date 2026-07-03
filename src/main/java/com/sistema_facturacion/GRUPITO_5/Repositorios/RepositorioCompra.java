package com.sistema_facturacion.GRUPITO_5.Repositorios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCompra extends JpaRepository<Compra, Long> {
}
