package com.sistema_facturacion.GRUPITO_5.Controladores;
//IMPORTAMOS LAS ENTIDADES Y NOTACIONES
import com.sistema_facturacion.GRUPITO_5.Entidades.Producto;
import com.sistema_facturacion.GRUPITO_5.Servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// @GETMAPING = EN SPRING BOOT CON ESTA NOTACION PERMITE MAPEAR WEB DIRECTAMENTE
// OSEA ES UNA CLASE QUE ESCUCHA PETICIONAS HTTP Y DECIDIR QUE HACER CON ELLAS Y DEVOLVER UNA RESPUESTA

//PERO CUANDOP USAMOS @CONTROLLER, SPRING BOOT ASUME QUE TAMOS HACIENDO UNA PAGINA WEB.
// SIP MI GETMAPPING DEVUEVLE UNA HOLA MUNDO SPRING BUSCARA EL ARCHIVO QUE ESTE EN MI PROYECTO

// @RESTCONTROLLER= EN SPRING BOOT CON ESTA ANOTACION NOS PERMITE DEVOLVERLO DIRECTAMENTE SIN BUSCAR EL ARCHVI HTML. OSEA
// ENVIARSELO HACI EN "CRUOD" A QUIEN HACE LA PETICION COMO VAMOS A HAER NUESTRAS PETICIONES EN POSTMAN"
// PODEMOS DEVOLVER JSON O HTTP
@RestController
@RequestMapping("/producto")
public class ControladorProducto {
    @Autowired
    private ServicioProducto servicioProducto;
    @GetMapping("/listar")
    public List<Producto> obtenerProductos() {
        return servicioProducto.listarProductos();
    }
    // @RequestBody le dice a Spring que Postman le enviará una peti http tipo JSON con los datos del producto
    @PostMapping("/registrar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        // RQUESTBODY= PARA RECIBIR DATPS EN EL BODY DE A PETI HTTP EN JSON , SPRING LO CONVIERTE A OPBJET
        return servicioProducto.crearProducto(producto);
    }
    @GetMapping("/{id}")
    public Producto obtenerProductoId(@PathVariable Long id) {
        // PATHVARIABLE = PARA CAPTURAR EL VALOR DE LA URL
        return servicioProducto.buscarProducto(id);
    }
    @PutMapping("/actualizar/{id}")
    public Producto actualizarProductoId(@PathVariable Long id, @RequestBody Producto producto) {
        return servicioProducto.actualizarProducto(id, producto);
    }
    @DeleteMapping("/eliminar/{id}")
    public boolean eliminarProductoId(@PathVariable Long id) {
        return servicioProducto.eliminarProducto(id);
    }
}
