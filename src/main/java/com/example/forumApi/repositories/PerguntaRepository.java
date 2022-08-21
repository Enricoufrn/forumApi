package com.example.forumApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forumApi.domain.entities.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

}
