package com.sistema_facturacion.GRUPITO_5.Entidades;
//CREAMOS NUESTRA CLASE COMPRA
public class Compra {
    // Definimos los atributos del Compra
    // Usamos private para que nuestras variables no seand accedidas directamente desde otra clase.
    private Long id;
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private String estado;
    // DEFINIMOS NUESTRO CONSTRUCTOR LLAMADO COMPRA
    public Compra() {
        this.estado = "REGISTRADA";// YA DEFINIMOS NUESTRO  ESTADO COMO REGISTRADO
    }
    // CREAMOS NUESTROS METODOS
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
