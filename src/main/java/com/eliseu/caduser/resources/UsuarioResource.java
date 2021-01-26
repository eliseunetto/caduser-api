package com.eliseu.caduser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliseu.caduser.domain.Usuario;
import com.eliseu.caduser.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);
		
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.notFound().build();
	}

}
