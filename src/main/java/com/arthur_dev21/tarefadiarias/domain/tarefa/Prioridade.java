package com.arthur_dev21.tarefadiarias.domain.tarefa;

public enum Prioridade {
   
	NORMAL("normal"),
	ALTA ("alta"),
	URGENTE("urgente");
	
	
	private String nome;
	
	
	private Prioridade(String nome) {
		this.nome=nome;
	}
}
