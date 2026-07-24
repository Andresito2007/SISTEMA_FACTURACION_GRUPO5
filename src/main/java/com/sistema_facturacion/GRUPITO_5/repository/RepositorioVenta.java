//El repositorio se encarga de traducir nuestras llamadas java a consultas sql de MySQL automaticamente
package com.sistema_facturacion.GRUPITO_5.repository;
// CREAMOS NUESTRO REPO QUE VA A CONSUMIR
// NUESTRA ENTIDAD CON EXTENDS Y RECIBIRA LA ENTIDAD Y LA CLAVE PRIMARIA CON QUE TRABJA
import com.sistema_facturacion.GRUPITO_5.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVenta extends JpaRepository<Venta, Long> {
}
