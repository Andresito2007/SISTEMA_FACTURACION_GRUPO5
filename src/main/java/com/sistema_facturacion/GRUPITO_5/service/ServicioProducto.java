// NUESTRA LOGICA DE NEGOCIO

package com.sistema_facturacion.GRUPITO_5.service;
import com.sistema_facturacion.GRUPITO_5.entity.Producto;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// INDICAMOS QUE ESTA CLASE ES DE TIPO SERVICIO
@Service
public class ServicioProducto {
    // SPRING INYECT EL REPO AUTOMATICAMENTE , EL SERVICE DELEGA EL ACCESO A LA BD 
    @Autowired
    private RepositorioProducto repositorio;

    // 1 METODO: CREAR PRODCUTO
    public Producto crearProducto(Producto producto) {
        return repositorio.save(producto);
    }

    // 2 METODO: LISTAR PRODCUTO
    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    // 3 METODO: BUSCAR PRODCUTO
    public Producto buscarProducto(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + id));
    }

    // 4 METODO: ACTUALIZAR PRODUCTO PRODCUTO
    public Producto actualizarProducto(Long id, Producto nuevo) {
        Producto existente = buscarProducto(id);
        existente.setNombre(nuevo.getNombre());
        existente.setPrecio(nuevo.getPrecio());
        existente.setStock(nuevo.getStock());
        return repositorio.save(existente);
    }

    // 5 METODO: ELIMINAR PRODCUTO
    public void eliminarProducto(Long id) {
        Producto existente = buscarProducto(id);
        repositorio.delete(existente);
    }
}
