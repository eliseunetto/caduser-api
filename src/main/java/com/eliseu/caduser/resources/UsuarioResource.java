package com.eliseu.caduser.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eliseu.caduser.domain.Usuario;
import com.eliseu.caduser.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = usuarioService.findAll();

		return ResponseEntity.ok().body(usuarios);
	}

	@GetMapping(value = "/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);

		return ResponseEntity.ok().body(usuario);
	}

	@PutMapping(value = "/{usuarioId}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId, @RequestBody Usuario usuarioAtualizado) {
		Usuario usuario = usuarioService.update(usuarioId, usuarioAtualizado);

		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuarioNovo) {
		Usuario usuario = usuarioService.create(usuarioNovo);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{usuarioId}")
				.buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{usuarioId}")
	public ResponseEntity<Usuario> apagar(@PathVariable Long usuarioId) {
		usuarioService.delete(usuarioId);
		return ResponseEntity.noContent().build();
	}

}
