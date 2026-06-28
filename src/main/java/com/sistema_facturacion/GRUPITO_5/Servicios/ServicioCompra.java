package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Compra;
import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// importamos el paquete dde util para crear nuestras listas
import java.util.ArrayList;
import java.util.List;
@Service
public class ServicioCompra {
    private List<Compra> lista = new ArrayList<>();
    private Long contadorId = 1L;
    // Necesitamos instanciar ProductoService para buscar y descontar stock
    //Las clases que están en la misma carpeta no necesitamos importarlas y lu samo porque esta  depende de otra para funcionar.
    @Autowired
    private ServicioProducto productoService;
    public Compra registrarCompra(Compra compra) {
        Producto producto = productoService.buscarProducto(compra.getProducto().getId());
        double total = compra.getPrecioUnitario() * compra.getCantidad();
        compra.setTotal(total);
        compra.setProducto(producto);
        producto.setStock(producto.getStock() + compra.getCantidad());
        compra.setId(contadorId++);
        lista.add(compra);
        return compra;
    }
    public List<Compra> listarCompras() {
        return lista;
    }
    public Compra buscarCompra(Long id) {
        for (Compra c : lista) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        throw new RuntimeException("COMPRA NO ENCONTRADA CON ID: " + id);
    }
    public Compra anularCompra(Long id) {
        Compra compra = buscarCompra(id);
        if ("ANULADA".equals(compra.getEstado())) {
            throw new RuntimeException("LA COMPRA YA ESTA ANULADA");
        }
        Producto producto = compra.getProducto();
        producto.setStock(producto.getStock() - compra.getCantidad());
        compra.setEstado("ANULADA");
        return compra;
    }
    public boolean eliminarCompra(Long id) {
        Compra compra = buscarCompra(id);
        Producto producto = compra.getProducto();
        producto.setStock(producto.getStock() - compra.getCantidad());
        lista.remove(compra);
        return true;
    }
}
