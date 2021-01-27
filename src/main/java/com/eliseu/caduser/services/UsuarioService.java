package com.eliseu.caduser.services;

import java.util.List;
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

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + usuarioId + ", Tipo: " + Usuario.class.getName()));
	}

	public Usuario update(Long usuarioId, Usuario usuarioAtualizado) {
		Usuario usuario = findById(usuarioId);
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setLogin(usuarioAtualizado.getLogin());
		usuario.setSenha(usuarioAtualizado.getSenha());
		
		return usuarioRepository.save(usuario);
	}

	public Usuario create(Usuario usuarioNovo) {
		usuarioNovo.setId(null);
		return usuarioRepository.save(usuarioNovo);
	}

	public void delete(Long usuarioId) {
		findById(usuarioId);
		usuarioRepository.deleteById(usuarioId);
	}
	
}
