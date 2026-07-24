package com.sistema_facturacion.GRUPITO_5.entity;
// IMPORTAMOS EL JPA (PERSISTENCIA DE JAVA DE DATOS)
import jakarta.persistence.*;
// ENTITY ESTA ANOTACION PARA DECIR QUE NUESTRA CLASE ES UNA TABLA
@Entity
// INDICAMOS QUE EL NOMBRE DE NUESTRA TABLA VA SER CLIENTES
@Table(name = "clientes")

public class Cliente {
    @Id // ESTA ANOTACION VA DECIR QUE ESTE ATRIBUTO SERA NUESTRA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // INCREMENTARA EL ID CADA VEZ QUE SE CREE UN USARIO DE UNO EN UNO
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String dni;

    // DEFINIMOS NUESTRO CONSTRUCTOR
    public Cliente() {}

    // DEFINIMOS NUESTRO METODOS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
