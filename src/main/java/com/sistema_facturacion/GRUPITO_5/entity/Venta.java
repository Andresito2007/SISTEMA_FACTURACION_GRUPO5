package com.sistema_facturacion.GRUPITO_5.entity;
// IMPORTAMOS EL JPA
import jakarta.persistence.*;
// ENTITY ESTA ANOTACION PARA DECIR QUE NUESTRA CLASE ES UNA TABLA
@Entity
// INDICAMOS QUE EL NOMBRE DE NUESTRA TABLA VA SER CLIENTES
@Table(name = "ventas")

public class Venta {
    @Id // ESTA ANOTACION VA DECIR QUE ESTE ATRIBUTO SERA NUESTRA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroVenta;
    //con ManyToone definimos la lógica de la relación.
    // lo leemos de izquierda a derecha por muchos objetos de nuestra clase se asocian a Un solo
    @ManyToOne
    //esta notacion se encarga de los detalles físicos en nuestra base de datos (la Llave Foranea).
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    private Integer cantidad;
    private Double total;
    @Column(nullable = false)
    private String estado = "REGISTRADA";

    // DEFINIMOS NUESTRO CONSTRUCTOR
    public Venta() {}

    // DEFINIMOS NUESTRO METODOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroVenta() { return numeroVenta; }
    public void setNumeroVenta(String numeroVenta) { this.numeroVenta = numeroVenta; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
