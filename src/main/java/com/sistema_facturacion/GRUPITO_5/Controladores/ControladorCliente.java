package com.sistema_facturacion.GRUPITO_5.Controladores;
import com.sistema_facturacion.GRUPITO_5.Entidades.Cliente;
import com.sistema_facturacion.GRUPITO_5.Servicios.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// REQUEYSTMAPPING = mapear (vincular) una URL específica a la lógica de tu aplicación. una ruta base
//odas las peticiones web que lleguen a la dirección que contenga /cliente deben ser manejadas por nuestrocontrolador
@RestController
@RequestMapping("/cliente")
public class ControladorCliente {
    @Autowired
    private ServicioCliente servicioCliente;

    @PostMapping("/registrar")
    public Cliente RegistrarCliente(@RequestBody Cliente cliente) {
        return servicioCliente.crearCliente(cliente);
    }

    @GetMapping("/listar")
    public List<Cliente> obtenerClientes() {
        return servicioCliente.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClienteId(@PathVariable Long id) {
        return servicioCliente.buscarCliente(id);
    }

    @PutMapping("/actualizar/{id}")
    public Cliente actualizarClienteId(@PathVariable Long id, @RequestBody Cliente cliente) {
        return servicioCliente.actualizarCliente(id, cliente);
    }
    @DeleteMapping("/eliminar/{id}")
    public boolean eliminarClienteId(@PathVariable Long id) {
        return servicioCliente.eliminarCliente(id);
    }
}
