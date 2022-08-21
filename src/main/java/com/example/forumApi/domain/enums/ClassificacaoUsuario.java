package com.example.forumApi.domain.enums;


public enum ClassificacaoUsuario {
	
	PODE_AJUDAR_MAIS(1),
	ESTA_MELHORANDO(2),
	PRESTATIVO(3),
	QUASE_PRO(4),
	PRO(5);
	
	int value;
	
	ClassificacaoUsuario(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public ClassificacaoUsuario getClassificacaoUsuarioByValue(int value) {
		ClassificacaoUsuario[] values = values();
		for (ClassificacaoUsuario classificacaoUsuario : values) {
			if(classificacaoUsuario.getValue() == value)
				return classificacaoUsuario;
		}
		return null;
	}
}
