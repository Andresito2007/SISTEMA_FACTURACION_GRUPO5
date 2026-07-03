package com.sistema_facturacion.GRUPITO_5.service;

import com.sistema_facturacion.GRUPITO_5.entity.Cliente;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCliente {

    @Autowired
    private RepositorioCliente repositorio;

    public Cliente crearCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    public Cliente buscarCliente(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("CLIENTE NO ENCONTRADO CON ID: " + id));
    }

    public Cliente actualizarCliente(Long id, Cliente nuevo) {
        Cliente existente = buscarCliente(id);
        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        existente.setDni(nuevo.getDni());
        return repositorio.save(existente);
    }

    public void eliminarCliente(Long id) {
        Cliente existente = buscarCliente(id);
        repositorio.delete(existente);
    }
}
