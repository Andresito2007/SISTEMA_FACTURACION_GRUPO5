# CARTA DE PRESENTACION

## INTEGRANTES

- Estefano Ochupe 
- Andres Choqque 
- Rodrigo Tomayquispe
- Sebastian Palacios
- Fabrizio Valdivia



## DESCRIPCIÓN DEL PROYECTO

Desarrollamos una **API REST** para la gestión de clientes, productos, compras y ventas de un sistema de facturación.

La aplicación permite registrar, listar, buscar, actualizar y eliminar información mediante solicitudes HTTP. También utiliza una base de datos MySQL para almacenar los datos del sistema.

## INTEGRANTES

- Estefano Ochupe
- Andres Choqque
- Rodrigo Tomayquispe
- Sebastian Palacios
- Fabrizio Valdivia
- Benjamin

## HERRAMIENTAS UTILIZADAS

Las herramientas principales del proyecto son:


- **Java 17:** lenguaje de programación principal del proyecto.
- **Spring Boot 3.5.15:** framework utilizado para desarrollar la API REST.
- **IntelliJ IDEA:** entorno de desarrollo utilizado para programar el proyecto.
- **MySQL:** sistema de gestión de base de datos.
- **Postman:** herramienta utilizada para probar las solicitudes de la API.
- **Maven:** herramienta encargada de administrar las dependencias y compilar el proyecto.
- **Swagger / OpenAPI:** permite visualizar y probar los endpoints desde el navegador.

## ESTRUCTURA DEL PROYECTO

```text
src/
├── main/
│   ├── java/com/sistema_facturacion/GRUPITO_5/
│   │   ├── controller/
│   │   │   ├── ControladorCliente.java
│   │   │   ├── ControladorProducto.java
│   │   │   ├── ControladorCompra.java
│   │   │   └── ControladorVenta.java
│   │   ├── service/
│   │   │   ├── ServicioCliente.java
│   │   │   ├── ServicioProducto.java
│   │   │   ├── ServicioCompra.java
│   │   │   └── ServicioVenta.java
│   │   ├── repository/
│   │   │   ├── RepositorioCliente.java
│   │   │   ├── RepositorioProducto.java
│   │   │   ├── RepositorioCompra.java
│   │   │   └── RepositorioVenta.java
│   │   ├── entity/
│   │   │   ├── Cliente.java
│   │   │   ├── Producto.java
│   │   │   ├── Compra.java
│   │   │   └── Venta.java
│   │   └── Grupito5Application.java
│   └── resources/
│       ├── application.properties
│       └── banner.txt
└── test/
```

## FUNCIONES PRINCIPALES

### Clientes

- Registrar clientes.
- Listar clientes.
- Buscar un cliente por su ID.
- Actualizar los datos de un cliente.
- Eliminar un cliente.

### Productos

- Registrar productos.
- Listar productos.
- Buscar un producto por su ID.
- Actualizar los datos y el stock de un producto.
- Eliminar un producto.

### Compras

- Registrar compras.
- Listar compras.
- Buscar una compra por su ID.
- Anular una compra.
- Eliminar una compra.

### Ventas

- Registrar ventas.
- Listar ventas.
- Buscar una venta por su ID.
- Anular una venta.
- Eliminar una venta.

## CONCEPTOS

### API

Una API permite la comunicación entre diferentes aplicaciones, sin importar el lenguaje de programación con el que hayan sido desarrolladas.

### REST

REST es un estilo de arquitectura que establece buenas prácticas para crear servicios web mediante solicitudes HTTP.

### API REST

Una API REST permite que un cliente envíe solicitudes al servidor mediante métodos HTTP. El servidor procesa la solicitud y devuelve una respuesta.

Los métodos HTTP principales utilizados son:

- **GET:** consulta información.
- **POST:** registra nueva información.
- **PUT:** actualiza información existente.
- **DELETE:** elimina información.

## DEPENDENCIAS UTILIZADAS

Las dependencias se encuentran declaradas en el archivo `pom.xml`.

### Spring Web

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Se utiliza para crear la API REST, los controladores y los endpoints HTTP mediante anotaciones como `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping` y `@DeleteMapping`.

### Spring Data JPA

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Permite conectar las entidades Java con las tablas de la base de datos y realizar operaciones como registrar, consultar, actualizar y eliminar datos.

### MySQL Connector/J

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

Es el controlador que permite que la aplicación desarrollada en Java se conecte con la base de datos MySQL.

### SpringDoc OpenAPI y Swagger UI

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.16</version>
</dependency>
```

Genera automáticamente la documentación de la API y permite probar los endpoints desde Swagger UI.

### Spring Boot DevTools

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

Facilita el desarrollo reiniciando automáticamente la aplicación cuando se realizan cambios en el código.

### Spring Boot Starter Test

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

Incluye herramientas para crear y ejecutar pruebas del funcionamiento de la aplicación.

## SPRING SECURITY

Spring Security es una herramienta de Spring que permite proteger una aplicación mediante autenticación y autorización.

Puede utilizarse para:

- Solicitar usuario y contraseña.
- Proteger determinados endpoints.
- Asignar roles, como administrador o vendedor.
- Evitar que personas no autorizadas modifiquen o eliminen información.
- Implementar autenticación mediante tokens JWT.

> **Nota:** actualmente, Spring Security no se encuentra agregado en el archivo `pom.xml` de este proyecto. Esta sección representa una mejora futura que puede implementarse para proteger la API.

La dependencia que se podría agregar es la siguiente:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## CONFIGURACIÓN DE LA BASE DE DATOS

Antes de ejecutar el proyecto, se debe crear una base de datos en MySQL:

```sql
CREATE DATABASE SISTEMA_FACURACION;
```

Luego se deben revisar los datos de conexión en:

```text
src/main/resources/application.properties
```

Configuración utilizada actualmente:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/SISTEMA_FACURACION?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
```

Cada integrante debe modificar el usuario y la contraseña de acuerdo con su instalación de MySQL.

## EJECUCIÓN DEL PROYECTO

### En Windows

```bash
mvnw.cmd spring-boot:run
```

### En Linux

Primero se debe otorgar permiso de ejecución al archivo Maven Wrapper:

```bash
chmod +x mvnw
```

Después se ejecuta el proyecto:

```bash
./mvnw spring-boot:run
```

También puede ejecutarse directamente desde IntelliJ IDEA abriendo la clase:

```text
Grupito5Application.java
```

## DOCUMENTACIÓN CON SWAGGER

Cuando la aplicación esté ejecutándose, Swagger UI estará disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```

## ENDPOINTS PRINCIPALES

| Módulo | Método | Endpoint | Función |
|---|---|---|---|
| Cliente | POST | `/cliente/registrar` | Registrar un cliente |
| Cliente | GET | `/cliente/listar` | Listar clientes |
| Cliente | GET | `/cliente/{id}` | Buscar un cliente |
| Cliente | PUT | `/cliente/actualizar/{id}` | Actualizar un cliente |
| Cliente | DELETE | `/cliente/eliminar/{id}` | Eliminar un cliente |
| Producto | POST | `/producto/registrar` | Registrar un producto |
| Producto | GET | `/producto/listar` | Listar productos |
| Producto | GET | `/producto/{id}` | Buscar un producto |
| Producto | PUT | `/producto/actualizar/{id}` | Actualizar un producto |
| Producto | DELETE | `/producto/eliminar/{id}` | Eliminar un producto |
| Compra | POST | `/compra/registrar` | Registrar una compra |
| Compra | GET | `/compra/listar` | Listar compras |
| Compra | GET | `/compra/{id}` | Buscar una compra |
| Compra | PUT | `/compra/anular/{id}` | Anular una compra |
| Compra | DELETE | `/compra/eliminar/{id}` | Eliminar una compra |
| Venta | POST | `/venta/registrar` | Registrar una venta |
| Venta | GET | `/venta/listar` | Listar ventas |
| Venta | GET | `/venta/{id}` | Buscar una venta |
| Venta | PUT | `/venta/anular/{id}` | Anular una venta |
| Venta | DELETE | `/venta/eliminar/{id}` | Eliminar una venta |

## ESTADO DEL PROYECTO

El proyecto cuenta con los módulos principales para administrar clientes, productos, compras y ventas. Como mejoras futuras se puede implementar Spring Security, validación de datos, manejo global de errores y autenticación mediante JWT.
