package com.example.forumApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumApi.Exceptions.RespostaNaoEncontradaException;
import com.example.forumApi.domain.entities.Resposta;
import com.example.forumApi.repositories.RespostaRepository;

@Service
public class RespostaService {
	
	private final RespostaRepository respostaRepository;
	
	@Autowired
	public RespostaService(RespostaRepository respostaRepository) {
		this.respostaRepository = respostaRepository;
	}
	
	public Resposta addResposta(Resposta resposta) {
		return respostaRepository.save(resposta);
	}

	public Resposta getRespostaById(Long respostaId) {
		return respostaRepository.findById(respostaId)
				.orElseThrow(() -> new RespostaNaoEncontradaException("Resposta com id " + respostaId + "nao encontrada!"));
	}
	
	public List<Resposta> getAllRespostas(){
		return respostaRepository.findAll();
	}
	
	public void deleteRespostaById(Long respostaId) {
		respostaRepository.deleteById(respostaId);
	}
}
