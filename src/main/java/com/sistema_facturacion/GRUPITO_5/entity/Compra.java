package com.sistema_facturacion.GRUPITO_5.entity;
// IMPORTAMOS EL JPA
import jakarta.persistence.*;
// ENTITY ESTA ANOTACION PARA DECIR QUE NUESTRA CLASE ES UNA TABLA
@Entity
// INDICAMOS QUE EL NOMBRE DE NUESTRA TABLA VA SER COMPRAS
@Table(name = "compras")

public class Compra {
    @Id // ESTA ANOTACION VA DECIR QUE ESTE ATRIBUTO SERA NUESTRA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // INCREMENTARA EL ID CADA VEZ QUE SE CREE UN USARIO DE UNO EN UNO
    private Long id;
    //CON ESTA NOTACION DEFINIMOS LA RELACION ENTRE TABLAS DE LA BD.
    @ManyToOne
    //CADA COMPRA TIENE UN SOLO PRODUCTO ASOCIADO
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    @Column(nullable = false)
    private String estado = "REGISTRADA";

    // DEFINIMOS NUESTRO CONSTRUCTOR
    public Compra() {}

    // DEFINIMOS NUESTRO METODOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
