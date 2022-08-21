package com.example.forumApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumApi.domain.entities.Usuario;
import com.example.forumApi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public Usuario getUsuarioByid(@PathVariable(value = "id") Long usuarioId) {
		return usuarioService.getUsuarioById(usuarioId);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario novoUsuario){
		
		Usuario usuarioSalvo = usuarioService.addUsuario(novoUsuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId, @RequestBody Usuario dadosUsuario){
		
		Usuario usuario = usuarioService.getUsuarioById(usuarioId);
		
		usuario.setNome(dadosUsuario.getNome());
		usuario.setEmail(dadosUsuario.getEmail());
		
		Usuario usuarioAtt = usuarioService.addUsuario(usuario);
		
		return new ResponseEntity<Usuario>(usuarioAtt, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUsuarioById(@PathVariable(value = "id") Long usuarioId){
		usuarioService.deleteUsuarioById(usuarioId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
