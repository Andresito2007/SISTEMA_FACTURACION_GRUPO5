package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Entidades.Venta;
import com.sistema_facturacion.GRUPITO_5.Repositorios.RepositorioProducto;
import com.sistema_facturacion.GRUPITO_5.Repositorios.RepositorioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioVenta {

    @Autowired
    private RepositorioVenta repositorioVenta;

    @Autowired
    private RepositorioProducto repositorioProducto;

    @Transactional
    public Venta procesarVenta(Venta venta) {
        Producto producto = repositorioProducto.findById(venta.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + venta.getProducto().getId()));
        if (producto.getStock() < venta.getCantidad()) {
            throw new RuntimeException("STOCK INSUFICIENTE, DISPONIBLE: " + producto.getStock());
        }
        double total = producto.getPrecio() * venta.getCantidad();
        venta.setTotal(total);
        venta.setProducto(producto);
        venta.setEstado("REGISTRADA");
        producto.setStock(producto.getStock() - venta.getCantidad());
        repositorioProducto.save(producto);
        long numero = repositorioVenta.count() + 1L;
        venta.setNumeroVenta(String.format("IDAT-%SISTEMA_FACTURACION5", numero));
        return repositorioVenta.save(venta);
    }

    public List<Venta> listarVentas() {
        return repositorioVenta.findAll();
    }

    public Venta buscarVenta(Long id) {
        return repositorioVenta.findById(id)
                .orElseThrow(() -> new RuntimeException("VENTA NO ENCONTRADA CON ID: " + id));
    }

    @Transactional
    public Venta anularVenta(Long id) {
        Venta venta = buscarVenta(id);
        if ("ANULADA".equals(venta.getEstado())) {
            throw new RuntimeException("LA VENTA YA ESTA ANULADA");
        }
        Producto producto = venta.getProducto();
        producto.setStock(producto.getStock() + venta.getCantidad());
        repositorioProducto.save(producto);
        venta.setEstado("ANULADA");
        return repositorioVenta.save(venta);
    }

    @Transactional
    public void eliminarVenta(Long id) {
        Venta venta = buscarVenta(id);
        Producto producto = venta.getProducto();
        producto.setStock(producto.getStock() + venta.getCantidad());
        repositorioProducto.save(producto);
        repositorioVenta.delete(venta);
    }
}
