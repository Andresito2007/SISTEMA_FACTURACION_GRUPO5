package com.sistema_facturacion.GRUPITO_5.Servicios;

import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Entidades.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// importamos el paquete dde util para crear nuestras listas
import java.util.ArrayList;
import java.util.List;
@Service
public class ServicioVenta {
    private List<Venta> lista = new ArrayList<>();
    //Instanciamos nuestra variable contadorId y contadorNumero
    private Long contadorId = 1L;
    private Long contadorNumero = 1L;
    // Necesitamos instanciar ProductoService para buscar y descontar stock
    //Las clases que están en la misma carpeta no necesitamos importarlas y lu samo porque esta  depende de otra para funcionar.
    @Autowired
    private ServicioProducto productoService;
    public Venta procesarVenta(Venta venta) {
        Producto producto = productoService.buscarProducto(venta.getProducto().getId());
        //manejo de excepciones
        if (producto.getStock() < venta.getCantidad()) {
            throw new RuntimeException("STOCK INSUFICIENTE, DISPONIBLE: " + producto.getStock());
        }
        double total = producto.getPrecio() * venta.getCantidad();
        venta.setTotal(total);
        producto.setStock(producto.getStock() - venta.getCantidad());
        venta.setId(contadorId++);
        venta.setNumeroVenta(String.format("IDAT-%SISTEMA_FACTURACION5", contadorNumero++));
        venta.setProducto(producto);
        venta.setEstado("REGISTRADA");
        lista.add(venta);
        return venta;
    }
    public List<Venta> listarVentas() {
        return lista;
    }
    public Venta buscarVenta(Long id) {
        for (Venta venta : lista) {
            if (venta.getId().equals(id)) {
                return venta;
            }
        }
        // manejo de excepsiones
        throw new RuntimeException("VENTA NO ENCONTRADA CON ID: " + id);
    }
    public Venta anularVenta(Long id) {
        Venta venta = buscarVenta(id);
        if ("ANULADA".equals(venta.getEstado())) {
            throw new RuntimeException("LA VENTA YA ESTA ANULADA");
        }
        Producto producto = venta.getProducto();
        producto.setStock(producto.getStock() + venta.getCantidad());
        venta.setEstado("ANULADA");
        return venta;
    }
    public boolean eliminarVenta(Long id) {
        Venta venta = buscarVenta(id);
        Producto producto = venta.getProducto();
        producto.setStock(producto.getStock() + venta.getCantidad());
        lista.remove(venta);
        return true;
    }
}
