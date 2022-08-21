package com.example.forumApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumApi.Exceptions.PerguntaNaoEncontradaException;
import com.example.forumApi.domain.entities.Pergunta;
import com.example.forumApi.repositories.PerguntaRepository;

@Service
public class PerguntaService {

	private final PerguntaRepository perguntaRepository;
	
	@Autowired
	public PerguntaService(PerguntaRepository perguntaRepository) {
		this.perguntaRepository = perguntaRepository;
	}
	
	public Pergunta addPergunta(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}
	
	public Pergunta getPerguntaById(Long perguntaId){
		return perguntaRepository.findById(perguntaId)
				.orElseThrow(() -> new PerguntaNaoEncontradaException("Pergunta com id " + perguntaId + "nao encontrada!"));
	}
	
	public List<Pergunta> getAllPerguntas(){
		return perguntaRepository.findAll();
	}
	
	public void deletePerguntaById(Long perguntaId) {
		perguntaRepository.deleteById(perguntaId);
	}
}
