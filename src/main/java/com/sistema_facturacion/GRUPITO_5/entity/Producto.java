package com.sistema_facturacion.GRUPITO_5.entity;
// IMPORTAMOS EL JPA
import jakarta.persistence.*;
// ENTITY ESTA ANOTACION PARA DECIR QUE NUESTRA CLASE ES UNA TABLA
@Entity
// INDICAMOS QUE EL NOMBRE DE NUESTRA TABLA VA SER COMPRAS
@Table(name = "productos")

public class Producto {
    @Id // ESTA ANOTACION VA DECIR QUE ESTE ATRIBUTO SERA NUESTRA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private Double precio;
    private Integer stock;

    // DEFINIMOS NUESTRO CONSTRUCTOR
    public Producto() {}

    // DEFINIMOS NUESTRO METODOS
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
