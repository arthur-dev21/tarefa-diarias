package com.arthur_dev21.tarefadiarias.insfraestructure.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arthur_dev21.tarefadiarias.aplicattion.TarefaService;
import com.arthur_dev21.tarefadiarias.domain.tarefa.Tarefa;
import com.arthur_dev21.tarefadiarias.domain.tarefa.TarefaRepository;

@Controller
public class InicioController {
    
	@Autowired
	TarefaRepository tarefarepository;
	
	
	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	public String inicio(Model model) {
		List<Tarefa> tarefas = tarefaService.tarefasPendentes();
		model.addAttribute("tarefas", tarefas);
		int total =  tarefaService.numTarefasConcluida();
		int tota2 = tarefaService.quantidadeTarefas();
		model.addAttribute("tarefaconcluida",total);
		model.addAttribute("tarefapedente",tota2);
		return "index";
	}
}
