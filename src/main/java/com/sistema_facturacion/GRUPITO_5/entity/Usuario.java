// CREAMOS NUESTRA ENTIDAD USUARIO PARA PODER VALIDAR SI ES UN USUARIO O ADMINISTRADOR (CLIENTE)
package com.sistema_facturacion.GRUPITO_5.entity;
// IMPORTAMOS EL JPA
import jakarta.persistence.*;
// ENTITY ESTA ANOTACION PARA DECIR QUE NUESTRA CLASE ES UNA TABLA
@Entity
// INDICAMOS QUE EL NOMBRE DE NUESTRA TABLA VA SER USUARIOS
@Table(name="usuarios")

public class Usuario {
    @Id  // ESTA ANOTACION VA DECIR QUE ESTE ATRIBUTO SERA NUESTRA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // INCREMENTARA EL ID CADA VEZ QUE SE CREE UN USARIO DE UNO EN UNO
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String rol;  // "ADMIN" o "USER"

    // DEFINIMOS NUESTRO CONSTRUCTOR
    public Usuario() {}

    // DEFINIMOS NUESTRO METODOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }


}
