package com.sistema_facturacion.GRUPITO_5.Controladores;

import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping("/listar")
    public List<Producto> obtenerProductos() {
        return servicioProducto.listarProductos();
    }

    @PostMapping("/registrar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return servicioProducto.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoId(@PathVariable Long id) {
        return servicioProducto.buscarProducto(id);
    }

    @PutMapping("/actualizar/{id}")
    public Producto actualizarProductoId(@PathVariable Long id, @RequestBody Producto producto) {
        return servicioProducto.actualizarProducto(id, producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProductoId(@PathVariable Long id) {
        servicioProducto.eliminarProducto(id);
    }
}
