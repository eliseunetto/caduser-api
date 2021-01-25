package com.eliseu.caduser;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eliseu.caduser.domain.Usuario;
import com.eliseu.caduser.repositories.UsuarioRepository;

@SpringBootApplication
public class CaduserApiApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaduserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Eliseu", "eliseunetto", "123");
		Usuario u2 = new Usuario(null, "Albert Einstein", "albert", "123");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}

}
