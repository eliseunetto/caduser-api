package com.eliseu.caduser.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseu.caduser.domain.Usuario;
import com.eliseu.caduser.repositories.UsuarioRepository;
import com.eliseu.caduser.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + usuarioId + ", Tipo: " + Usuario.class.getName()));
	}
}
