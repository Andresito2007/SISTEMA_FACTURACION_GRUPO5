package com.sistema_facturacion.GRUPITO_5.Entidades;
//CREAMOS NUESTRA CLASE CLIENTE
public class Cliente{
    // Definimos los atributos del Cliente
    // Usamos private para que nuestras variables no seand accedidas directamente desde otra clase.
    private Long id;
    private String nombre;
    private String email;
    private String dni;
    // DEFINIMOS NUESTRO CONSTRUCTOR LLAMADO CLIENTE
    public Cliente(){}
    // CREAMOS NUESTROS METODOS
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }
}
