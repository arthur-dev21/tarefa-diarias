package com.arthur_dev21.tarefadiarias.aplicattion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.arthur_dev21.tarefadiarias.domain.tarefa.Tarefa;
import com.arthur_dev21.tarefadiarias.domain.tarefa.TarefaRepository;

@Service
public class TarefaService {
   
	@Autowired
	TarefaRepository tarefarepository;
	
	
	public void salvartarefa(Tarefa tarefa) {
		tarefarepository.save(tarefa);
	}
	
	
	public List<Tarefa> tarefasPendentes(){
		List<Tarefa>tarefas = tarefarepository.tarefasPendentes();
		return tarefas;
	}
	
	public int quantidadeTarefas() {
		List<Tarefa> taf = tarefarepository.findAll();
		 int total= taf.size();
		 return total;
	}
	
	public int numtarefaspedente() {
		List<Tarefa> taf = tarefarepository.tarefasPendentes();
		int total= taf.size();
		return total;
	}
	
	public int numTarefasConcluida() {
		int total = quantidadeTarefas() - numtarefaspedente();
		return total;
	}
	
	public Tarefa buscarPorId(int id) {
		Optional<Tarefa> tarefa = tarefarepository.findById(id);
		Tarefa newtarefa = tarefa.get();
		return newtarefa;
	}
	
    
}
