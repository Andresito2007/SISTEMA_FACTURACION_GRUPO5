// CASO DIFERENTE EN ESTE SERVICIPO

// CON ESTE SERVICIO PODEMOS AYIDAR A SPRING SECURYTI A AUNTENTICAR USUARIOS
package com.sistema_facturacion.GRUPITO_5.service;
import com.sistema_facturacion.GRUPITO_5.entity.Usuario;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

// INDICAMOS QUE ESTA CLASE ES DE TIPO SERVICIO PA PODER CONSUMIRLO
@Service
// ESE USERDETAILSSERVICE ES UNA INTERFAZ DE SPRING SECURITY QUE AL USARLA LE DECIMOS A SPRING
// QUE CUANDO ALGUIEN INTENTE LOGEARSE VEN PRIMERO ACA Y VERIFICAMOS SI EL USUARIO EXITES Y SI SON CREDENCIALES CORRECTAS
public class ServicioUsuario implements  UserDetailsService{
    //SPRING INYECT EL REPO AUTOMATICAMENTE , EL SERVICE DELEGA EL ACCESO A LA BD
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    //SPRING SECURITY LLAMA AL METODO POR DEFECTO CUANDO SE LOGUEAN
    // UserDetails un objeto que Spring entiende con los datos del usuario
    // UsernameNotFoundException si no exist el usario
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "USUARIO NO ENCONTRADO : " + username));
        // CONTRUIMOS EL OBJETO ( SERIA NUESTRO USUARIO O USUARIO"
        return User.builder()
                .username(usuario.getUsername()) // NOMBRE DEL USUARIO
                .password(usuario.getPassword())  // CONTRASEÑA DEL USUARIO
                .roles(usuario.getRol())   // ROL QUE ES : "ADMIN" o "USER"
                .build(); // CONTRUYE ESTE OBJETO TRASFORMANDO NUESTRA ENTIDAD AL FORMATO SPRING
    }

}
