package com.sistema_facturacion.GRUPITO_5.controller;

import com.sistema_facturacion.GRUPITO_5.entity.Producto;
import com.sistema_facturacion.GRUPITO_5.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;
    //@RequestParam → captura un parámetro que viene en la URL después de ?
    //defaultValue = "0" eso signifca que si el usuario no pone el parámetro, usa la pagina 0 por defecto
    //int page = lo guarda en esta variable como número entero
    // por ejemplo si: URL: /compra/listar = page = 0 (por defecto)
    // URL: /compra/listar?page=2   = page = 2 (el usuario lo puso)
    // en mi caso se muestran 5 productos cada pagina pa no saturarlo
    @GetMapping("/listar")
    public Page<Producto> obtenerProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return servicioProducto.listarProductos(PageRequest.of(page, size));
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
