package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Compra;
import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Repositorios.RepositorioCompra;
import com.sistema_facturacion.GRUPITO_5.Repositorios.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioCompra {

    @Autowired
    private RepositorioCompra repositorioCompra;

    @Autowired
    private RepositorioProducto repositorioProducto;

    @Transactional
    public Compra registrarCompra(Compra compra) {
        Producto producto = repositorioProducto.findById(compra.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + compra.getProducto().getId()));
        double total = compra.getPrecioUnitario() * compra.getCantidad();
        compra.setTotal(total);
        compra.setProducto(producto);
        compra.setEstado("REGISTRADA");
        producto.setStock(producto.getStock() + compra.getCantidad());
        repositorioProducto.save(producto);
        return repositorioCompra.save(compra);
    }

    public List<Compra> listarCompras() {
        return repositorioCompra.findAll();
    }

    public Compra buscarCompra(Long id) {
        return repositorioCompra.findById(id)
                .orElseThrow(() -> new RuntimeException("COMPRA NO ENCONTRADA CON ID: " + id));
    }

    @Transactional
    public Compra anularCompra(Long id) {
        Compra compra = buscarCompra(id);
        if ("ANULADA".equals(compra.getEstado())) {
            throw new RuntimeException("LA COMPRA YA ESTA ANULADA");
        }
        Producto producto = compra.getProducto();
        producto.setStock(producto.getStock() - compra.getCantidad());
        repositorioProducto.save(producto);
        compra.setEstado("ANULADA");
        return repositorioCompra.save(compra);
    }

    @Transactional
    public void eliminarCompra(Long id) {
        Compra compra = buscarCompra(id);
        Producto producto = compra.getProducto();
        producto.setStock(producto.getStock() - compra.getCantidad());
        repositorioProducto.save(producto);
        repositorioCompra.delete(compra);
    }
}
