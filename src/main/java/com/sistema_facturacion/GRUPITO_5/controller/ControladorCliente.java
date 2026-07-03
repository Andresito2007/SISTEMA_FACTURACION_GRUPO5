package com.sistema_facturacion.GRUPITO_5.controller;

import com.sistema_facturacion.GRUPITO_5.entity.Cliente;
import com.sistema_facturacion.GRUPITO_5.service.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ControladorCliente {

    @Autowired
    private ServicioCliente servicioCliente;

    @PostMapping("/registrar")
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
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
    public void eliminarClienteId(@PathVariable Long id) {
        servicioCliente.eliminarCliente(id);
    }
}
