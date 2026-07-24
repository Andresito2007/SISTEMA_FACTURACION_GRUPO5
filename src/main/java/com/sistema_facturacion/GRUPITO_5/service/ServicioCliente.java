// NUESTRA LOGICA DE NEGOCIO

package com.sistema_facturacion.GRUPITO_5.service;
import com.sistema_facturacion.GRUPITO_5.entity.Cliente;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// INDICAMOS QUE ESTA CLASE ES DE TIPO SERVICIO PA PODER CONSUMIRLO
@Service
public class ServicioCliente {
    //SPRING INYECT EL REPO AUTOMATICAMENTE , EL SERVICE DELEGA EL ACCESO A LA BD 
    @Autowired
    private RepositorioCliente repositorio;
    
    // METODO 1 : CREAR CLIENTE 

    // 1 RECIBE EL CLIENTE DEL CONTROLLER , LO GUARDA
    public Cliente crearCliente(Cliente cliente) {
        return repositorio.save(cliente); // Y RETORNAR EL CLIENTE YA GUARDADO ( INSERT TO..)
    }

    // METODO 2 : LISTAR CLIENTES

    // LLAMA AL REPO
    public List<Cliente> listarClientes() {
        return repositorio.findAll(); // COMO UN SELECT * FROM clientes y retorna la lista
    }
    // 3 METODO :  BUSCAR CLIENTE POR ID

    // CON FINBYID NOS DEVUELVE SI EXITE O NO EL CLIENTE
    // ORELSETHROW= SI NO EXISTE LANZA LA EXCEPCION MOSTRANDO QUE PASO
    public Cliente buscarCliente(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("CLIENTE NO ENCONTRADO CON ID: " + id));
    }
    
    // 4 METODO : ACTUALIZAR CLIENTE
    public Cliente actualizarCliente(Long id, Cliente nuevo) {
        Cliente existente = buscarCliente(id); // BUSCA EL CLIENTE ACTUAL
        existente.setNombre(nuevo.getNombre()); // ASIGNA LOS NUEVO DATAZOS
        existente.setEmail(nuevo.getEmail());
        existente.setDni(nuevo.getDni());
        return repositorio.save(existente); // GUARDA LOS CAMBIOS Y RETORNA
    }
    
    // 5 METODO : ELIMINAR CLIENTE
    public void eliminarCliente(Long id) {
        Cliente existente = buscarCliente(id); // VERFIFICAMOS SI EXITE EL CLIENTE
        repositorio.delete(existente); // LO ELIMINAMOS
    }
}
