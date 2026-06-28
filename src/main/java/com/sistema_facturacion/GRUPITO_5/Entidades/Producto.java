package com.sistema_facturacion.GRUPITO_5.Entidades;
//CREAMOS NUESTRA CLASE PRODUCTO
public class Producto{
    // Definimos los atributos del producto
    // Usamos private para que nuestras variables no seand accedidas directamente desde otra clase.
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    // DEFINIMOS NUESTRO CONSTRUCTOR LLAMADO PRODUCTO
    public Producto(){}
    // CREAMOS NUESTROS METODOS
    public Long getId(){return id;}

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio) { this.precio = precio;}

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }
}
