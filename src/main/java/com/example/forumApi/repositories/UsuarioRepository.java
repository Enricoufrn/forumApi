package com.example.forumApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forumApi.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
