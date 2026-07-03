package com.sistema_facturacion.GRUPITO_5.controller;

import com.sistema_facturacion.GRUPITO_5.entity.Compra;
import com.sistema_facturacion.GRUPITO_5.service.ServicioCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class ControladorCompra {

    @Autowired
    private ServicioCompra servicioCompra;

    @PostMapping("/registrar")
    public Compra registrarCompra(@RequestBody Compra compra) {
        return servicioCompra.registrarCompra(compra);
    }

    @GetMapping("/listar")
    public List<Compra> listarCompra() {
        return servicioCompra.listarCompras();
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
