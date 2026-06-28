package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import org.springframework.stereotype.Service;
// importamos el paquete dde util para crear nuestras listas
import java.util.ArrayList;
import java.util.List;
@Service
public class ServicioProducto {
    private List<Producto> lista = new ArrayList<>();
    private Long contadorId = 1L;
    public Producto crearProducto(Producto producto) {
        producto.setId(contadorId++);
        lista.add(producto);
        return producto;
    }
    public List<Producto> listarProductos() {
        return lista;
    }
    public Producto buscarProducto(Long id) {
        for (Producto p : lista) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + id);
    }
    public Producto actualizarProducto(Long id, Producto nuevo) {
        Producto existente = buscarProducto(id);
        existente.setNombre(nuevo.getNombre());
        existente.setPrecio(nuevo.getPrecio());
        existente.setStock(nuevo.getStock());
        return existente;
    }
    public boolean eliminarProducto(Long id) {
        Producto existente = buscarProducto(id);
        lista.remove(existente);
        return true;
    }
}
