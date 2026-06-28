package com.sistema_facturacion.GRUPITO_5.Entidades;
//Importamos el paquete LocalDateTime para representar fecha y hora
import java.time.LocalDateTime;
// Definimos una clase llamada Venta
public class Venta{
    // Definimos los atributos de Venta
    // Usamos private para que nuestras variables no seand accedidas directamente desde otra clase.
    private Long id;
    private String numeroVenta;
    private Producto producto;
    private Integer cantidad;
    private Double total;
    private String estado;
    // DEFINIMOS NUESTRO CONSTRUCTOR  VENTA
    public Venta(){
        this.estado = "REGISTRADA"; // YA DEFINIMOS NUESTRO  ESTADO COMO REGISTRADO
    }
    // CREAMOS NUESTROS METODOS
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
