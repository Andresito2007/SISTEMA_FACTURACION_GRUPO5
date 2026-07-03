package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto {

    @Autowired
    private RepositorioProducto repositorio;

    public Producto crearProducto(Producto producto) {
        return repositorio.save(producto);
    }

    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    public Producto buscarProducto(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + id));
    }

    public Producto actualizarProducto(Long id, Producto nuevo) {
        Producto existente = buscarProducto(id);
        existente.setNombre(nuevo.getNombre());
        existente.setPrecio(nuevo.getPrecio());
        existente.setStock(nuevo.getStock());
        return repositorio.save(existente);
    }

    public void eliminarProducto(Long id) {
        Producto existente = buscarProducto(id);
        repositorio.delete(existente);
    }
}
