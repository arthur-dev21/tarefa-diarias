package com.arthur_dev21.tarefadiarias.domain.tarefa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository  extends JpaRepository<Tarefa, Integer>{
    
	@Query(value = "select * from tarefa where concluida = 0", nativeQuery = true)
	public List<Tarefa> tarefasPendentes();

	
	
	
}
