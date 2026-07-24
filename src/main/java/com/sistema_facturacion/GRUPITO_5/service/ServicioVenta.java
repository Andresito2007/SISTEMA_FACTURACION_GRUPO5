// NUESTRA LOGICA DE NEGOCIO

package com.sistema_facturacion.GRUPITO_5.service;
import com.sistema_facturacion.GRUPITO_5.entity.Producto;
import com.sistema_facturacion.GRUPITO_5.entity.Venta;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioProducto;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// INDICAMOS QUE ESTA CLASE ES DE TIPO SERVICIO PA PODER CONSUMIRLO
@Service
public class ServicioVenta {
    //SPRING INYECT EL REPO AUTOMATICAMENTE , EL SERVICE DELEGA EL ACCESO A LA BD
    @Autowired
    private RepositorioVenta repositorioVenta;

    @Autowired
    private RepositorioProducto repositorioProducto;

    // METODO 1 : PROCESAR VENTA

    // EL DECORADOR TRANSACCIONAL LE DICE A SPRING BOOT QUE MANEJE ESTE METODO COMOUNA TRANSACCION DE LA BASE DE DATOS
    // SI POR EJEMPLO SI SE GUARDA EL REGISTRO DE LA COMPRA PERO EN EL STOCK FALLO NO SE VA A GUARDAR ND
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
    // METODO 2 : LISTAR VENTA
    public List<Venta> listarVentas() {
        return repositorioVenta.findAll();
    }

    public Venta buscarVenta(Long id) {
        return repositorioVenta.findById(id)
                .orElseThrow(() -> new RuntimeException("VENTA NO ENCONTRADA CON ID: " + id));
    }
    // METODO 3 : ANULAR VENTA
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
    // MEOTODO 4 : ELIMINAR VENTA
    @Transactional
    public void eliminarVenta(Long id) {
        Venta venta = buscarVenta(id);
        Producto producto = venta.getProducto();
        producto.setStock(producto.getStock() + venta.getCantidad());
        repositorioProducto.save(producto);
        repositorioVenta.delete(venta);
    }
}
