package com.example.forumApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumApi.Exceptions.UsuarioNaoEncontradoException;
import com.example.forumApi.domain.entities.Usuario;
import com.example.forumApi.repositories.PerguntaRepository;
import com.example.forumApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PerguntaRepository perguntaRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, PerguntaRepository perguntaRepository) {
		this.usuarioRepository = usuarioRepository;
		this.perguntaRepository = perguntaRepository;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario getUsuarioById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com id " + usuarioId + "nao encontrado!"));
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public void deleteUsuarioById(Long usuarioId) {
		apagaPerguntasUsuario(usuarioId);
		usuarioRepository.deleteById(usuarioId);
	}
	
	private void apagaPerguntasUsuario(Long usuarioId) {
		perguntaRepository.deleteAllInBatch(() -> perguntaRepository.findAll().stream()
				.filter(pergunta -> pergunta.getAutor().getId() == usuarioId)
				.iterator());
	}
	
}
