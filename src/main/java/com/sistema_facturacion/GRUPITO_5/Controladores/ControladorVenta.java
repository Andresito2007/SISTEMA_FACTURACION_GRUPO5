package com.sistema_facturacion.GRUPITO_5.Controladores;
import com.sistema_facturacion.GRUPITO_5.Entidades.Venta;
import com.sistema_facturacion.GRUPITO_5.Servicios.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class ControladorVenta {
    @Autowired
    private ServicioVenta servicioVenta;

    @PostMapping("/registrar")
    public Venta registrarVenta(@RequestBody Venta venta) {
        return servicioVenta.procesarVenta(venta);
    }

    @GetMapping("/listar")
    public List<Venta> listarVenta() {
        return servicioVenta.listarVentas();
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
    public boolean eliminarVentaId(@PathVariable Long id) {
        return servicioVenta.eliminarVenta(id);
    }
}
