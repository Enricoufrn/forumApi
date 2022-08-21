package com.example.forumApi.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.forumApi.domain.enums.AvaliacaoResposta;

@Entity
public class Resposta {
	
	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String texto;
	private AvaliacaoResposta avaliacao;
	private Date dataPublicacao;
	
	@ManyToOne
	private Pergunta pergunta;
	
	public Resposta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public AvaliacaoResposta getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoResposta avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	
}
