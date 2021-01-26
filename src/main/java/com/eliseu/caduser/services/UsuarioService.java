package com.eliseu.caduser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseu.caduser.domain.Usuario;
import com.eliseu.caduser.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		
		return usuario.orElse(null);
	}
}
