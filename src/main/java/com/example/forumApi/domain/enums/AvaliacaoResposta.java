package com.example.forumApi.domain.enums;

public enum AvaliacaoResposta {

	CONFUSA(1),
	RAZOAVEL(2),
	BOA(3),
	ESCLARECEDORA(4),
	PERFEITA(5);
	
	int value;
	
	private AvaliacaoResposta(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public AvaliacaoResposta getAvaliacaoRespotaById(int value) {
		AvaliacaoResposta[] values = values();
		for (AvaliacaoResposta avaliacaoResposta : values) {
			if(avaliacaoResposta.getValue() == value)
				return avaliacaoResposta;
		}
		return null;
	}
}
