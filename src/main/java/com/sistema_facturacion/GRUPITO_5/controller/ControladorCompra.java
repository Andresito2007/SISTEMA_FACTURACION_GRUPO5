package com.sistema_facturacion.GRUPITO_5.controller;

import com.sistema_facturacion.GRUPITO_5.entity.Compra;
import com.sistema_facturacion.GRUPITO_5.service.ServicioCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class ControladorCompra {

    @Autowired
    private ServicioCompra servicioCompra;

    @PostMapping("/registrar")
    public Compra registrarCompra(@RequestBody Compra compra) {
        return servicioCompra.registrarCompra(compra);
    }
    //@RequestParam → captura un parámetro que viene en la URL después de ?
    //defaultValue = "0" eso signifca que si el usuario no pone el parámetro, usa la pagina 0 por defecto
    //int page = lo guarda en esta variable como número entero
    // por ejemplo si: URL: /compra/listar = page = 0 (por defecto)
    // URL: /compra/listar?page=2   = page = 2 (el usuario lo puso)
    // en mi caso se muestran 5 compras cada pagina pa no saturarlo
    @GetMapping("/listar")
    public Page<Compra> listarCompra(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return servicioCompra.listarCompras(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Compra obtenerCompraId(@PathVariable Long id) {
        return servicioCompra.buscarCompra(id);
    }

    @PutMapping("/anular/{id}")
    public Compra anularCompraId(@PathVariable Long id) {
        return servicioCompra.anularCompra(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCompraId(@PathVariable Long id) {
        servicioCompra.eliminarCompra(id);
    }
}
