// NUESTRA LOGICA DE NEGOCIO
package com.sistema_facturacion.GRUPITO_5.service;
// CONSUMIMOS EL REPOSITORIO Y  DEFINIMOS LOS MEOTODOS QUE VA TENER NUESTRO CONTROLADOE
import com.sistema_facturacion.GRUPITO_5.entity.Compra;
import com.sistema_facturacion.GRUPITO_5.entity.Producto;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioCompra;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// INDICAMOS QUE ESTA CLASE ES DE TIPO SERVICIO
@Service    
public class ServicioCompra {
    //SPRING INYECT EL REPO AUTOMATICAMENTE , EL SERVICE DELEGA EL ACCESO A LA BD
    @Autowired
    private RepositorioCompra repositorioCompra;

    @Autowired
    private RepositorioProducto repositorioProducto;

    // METODO 1 : REGISTRAR COMPRA DE STOCK

    // EL DECORADOR TRANSACCIONAL LE DICE A SPRING BOOT QUE MANEJE ESTE METODO COMOUNA TRANSACCION DE LA BASE DE DATOS
    // SI POR EJEMPLO SI SE GUARDA EL REGISTRO DE LA COMPRA PERO EN EL STOCK FALLO NO SE VA A GUARDAR ND
    @Transactional
    public Compra registrarCompra(Compra compra) {
        Producto producto = repositorioProducto.findById(compra.getProducto().getId()) // BUSCA EL PRODUCTO SI NO HAY...
                .orElseThrow(() -> new RuntimeException("PRODUCTO NO ENCONTRADO , SU ID ES : " + compra.getProducto().getId()));
        double total = compra.getPrecioUnitario() * compra.getCantidad();
        compra.setTotal(total);
        compra.setProducto(producto);
        compra.setEstado("REGISTRADA");
        producto.setStock(producto.getStock() + compra.getCantidad());
        repositorioProducto.save(producto);
        return repositorioCompra.save(compra);
    }
    // METODO 2 : LISTAR COMPRAS

    public List<Compra> listarCompras() {
        return repositorioCompra.findAll();
    }

    public Compra buscarCompra(Long id) {
        return repositorioCompra.findById(id)
                .orElseThrow(() -> new RuntimeException("COMPRA NO ENCONTRADA CON ID: " + id));
    }
    // METODO 3 : ANULAR LA COMPRA , QUE EL PRODUCTO VUELVA A NUESTRO SERVICO ( NO HAY REEMBOLSO JEJEJE)

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
    // METODO 4 : ELIMINAR COMPRA
    @Transactional
    public void eliminarCompra(Long id) {
        Compra compra = buscarCompra(id);
        Producto producto = compra.getProducto();
        producto.setStock(producto.getStock() - compra.getCantidad());
        repositorioProducto.save(producto);
        repositorioCompra.delete(compra);
    }
}
