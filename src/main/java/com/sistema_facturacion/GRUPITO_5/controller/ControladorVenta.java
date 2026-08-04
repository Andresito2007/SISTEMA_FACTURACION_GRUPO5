package com.sistema_facturacion.GRUPITO_5.controller;

import com.sistema_facturacion.GRUPITO_5.entity.Venta;
import com.sistema_facturacion.GRUPITO_5.service.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class ControladorVenta {

    @Autowired
    private ServicioVenta servicioVenta;

    @PostMapping("/registrar")
    public Venta registrarVenta(@RequestBody Venta venta) {
        return servicioVenta.procesarVenta(venta);
    }
    //@RequestParam → captura un parámetro que viene en la URL después de ?
    //defaultValue = "0" eso signifca que si el usuario no pone el parámetro, usa la pagina 0 por defecto
    //int page = lo guarda en esta variable como número entero
    // por ejemplo si: URL: /compra/listar = page = 0 (por defecto)
    // URL: /compra/listar?page=2   = page = 2 (el usuario lo puso)
    // en mi caso se muestran 5 ventas cada pagina pa no saturarlo
    @GetMapping("/listar")
    public Page<Venta> listarVenta(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return servicioVenta.listarVentas(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaId(@PathVariable Long id) {
        return servicioVenta.buscarVenta(id);
    }

    @PutMapping("/anular/{id}")
    public Venta anularVentaId(@PathVariable Long id) {
        return servicioVenta.anularVenta(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarVentaId(@PathVariable Long id) {
        servicioVenta.eliminarVenta(id);
    }
}
