// NUESTRA LOGICA DE NEGOCIO
package com.sistema_facturacion.GRUPITO_5;

import com.sistema_facturacion.GRUPITO_5.entity.Usuario;
import com.sistema_facturacion.GRUPITO_5.repository.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Grupito5Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupito5Application.class, args);
	}
    //el @Bean se ejecuta automáticamente cada vez que levantamos el servidor Recibe dos cosas por inyeccion
	//RepositorioUsuario repo → para buscar y guardar usuarios
	//PasswordEncoder encoder → para encriptar contraseñas

	//usamos bean  para crear objetos donde Spring los administre, como alternativa no estar añadiendo una clase adicional
	@Bean
	// INSERTAMOS USUARIOS POR DEFECTOS AL PRENDER EL SERVIEDOR
	CommandLineRunner init(RepositorioUsuario repo, PasswordEncoder encoder) {
		return args -> {
			//  si admin no exist lo creamos
			if (repo.findByUsername("admin").isEmpty()) {
				Usuario admin = new Usuario();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));  // contraseña encriptada (BCrypt)
				admin.setRol("ADMIN");
				repo.save(admin);
			}
			//  si vendedor no exist lo creamos
			if (repo.findByUsername("vendedor").isEmpty()) {
				Usuario vendedor = new Usuario();
				vendedor.setUsername("vendedor");
				vendedor.setPassword(encoder.encode("vendedor123"));  // contraseña encriptada (BCrypt)
				vendedor.setRol("USER");
				repo.save(vendedor);
			}
		};
	}
}
