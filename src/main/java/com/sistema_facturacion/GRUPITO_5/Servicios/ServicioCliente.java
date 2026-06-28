package com.sistema_facturacion.GRUPITO_5.Servicios;
// IMPORTAMOS LA CLASE CLIENTE
import com.sistema_facturacion.GRUPITO_5.Entidades.Cliente;
//IMPORTMA LA NOTACION SERVICE
import org.springframework.stereotype.Service;
// importamos el paquete dde util para crear nuestras listas
import java.util.ArrayList;
import java.util.List;
// Usamos el decorador serivce para que podamos convertir nuestra cladse en un serbicio y spring cree el objeto y usarlo
@Service
public class ServicioCliente {
    // NUESTRA BASE DE DATITOS (SIMULADA) POR NUESTRO ARRAY VACIO
    private List<Cliente> lista = new ArrayList<>();
    //Instanciamos nuestra variable contadorId
    private Long contadorId = 1L;
    //METODOS PARA QUE EL CONTROLLER LO USE
    public Cliente crearCliente(Cliente cliente) {
        cliente.setId(contadorId++);
        lista.add(cliente);
        return cliente;
    }
    public List<Cliente> listarClientes() {
        return lista;
    }
    public Cliente buscarCliente(Long id) {
        for (Cliente cliento_idat : lista) {
            if (cliento_idat.getId().equals(id)) {
                return cliento_idat;
            }
        }
        throw new RuntimeException("CLIENTE NO ENCONTRADO CON ID: " + id);
    }
    public Cliente actualizarCliente(Long id, Cliente nuevo) {
        Cliente existente = buscarCliente(id);
        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        existente.setDni(nuevo.getDni());
        return existente;
    }
    public boolean eliminarCliente(Long id) {
        Cliente existente = buscarCliente(id);
        lista.remove(existente);
        return true;
    }
}
