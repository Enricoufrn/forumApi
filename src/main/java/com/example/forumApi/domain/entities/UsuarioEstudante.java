package com.example.forumApi.domain.entities;

import com.example.forumApi.domain.enums.ClassificacaoUsuario;

public class UsuarioEstudante extends Usuario{
	
	ClassificacaoUsuario classificacao;

	public ClassificacaoUsuario getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoUsuario classificacao) {
		this.classificacao = classificacao;
	}
	
	
}
