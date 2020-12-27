package com.arthur_dev21.tarefadiarias.insfraestructure.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arthur_dev21.tarefadiarias.aplicattion.TarefaService;
import com.arthur_dev21.tarefadiarias.domain.tarefa.Tarefa;
import com.arthur_dev21.tarefadiarias.domain.tarefa.TarefaRepository;

@Controller
@RequestMapping(path="/tarefa")
public class PublicController {
	
	@Autowired
	TarefaService tarefaService;
	
	@Autowired
	TarefaRepository tarefarepository;
	
	
	@GetMapping(path = "/")
	public String index(Model model) {
		List<Tarefa> tarefas = tarefaService.tarefasPendentes();
		model.addAttribute("tarefas", tarefas);
		int total =  tarefaService.numTarefasConcluida();
		int tota2 = tarefaService.quantidadeTarefas();
		model.addAttribute("tarefaconcluida",total);
		model.addAttribute("tarefapedente",tota2);
		return "index";
	}
	
	@GetMapping(path= "/new")
	public String newTarefa(Model model) {
		return "tarefa-cadastro";
	}
	
    
	@PostMapping(path="/save")
	public String save(@ModelAttribute("tarefa") Tarefa tarefa , Model model) {
		tarefaService.salvartarefa(tarefa);
		int total =  tarefaService.numTarefasConcluida();
		int tota2 = tarefaService.quantidadeTarefas();
		model.addAttribute("tarefaconcluida",total);
		model.addAttribute("tarefapedente",tota2);
		List<Tarefa> tarefas = tarefaService.tarefasPendentes();
		model.addAttribute("tarefas", tarefas);
		return "index";
	} 
	
	@GetMapping(path= {"/concluir/{id}"} )
	public String concluirTarefa( @PathVariable("id") int id ,Model model ) {
	     Tarefa tarefanova = tarefaService.buscarPorId(id);
		
	     tarefanova.setConcluida(true);
	     tarefaService.salvartarefa(tarefanova);
	     int total =  tarefaService.numTarefasConcluida();
			int tota2 = tarefaService.quantidadeTarefas();
			model.addAttribute("tarefaconcluida",total);
			model.addAttribute("tarefapedente",tota2);
			List<Tarefa> tarefas = tarefaService.tarefasPendentes();
			model.addAttribute("tarefas", tarefas);
		return "index";
	}
	
	@GetMapping(path= {"/visualizar/{id}"})
	public String visualizar(@PathVariable("id") int id , Model model) {
		 Tarefa tarefanova = tarefaService.buscarPorId(id);
		 model.addAttribute("tarefa", tarefanova);
		return "tarefa-detalhes";
	}
	
	@PostMapping(path= {"/editar"})
	public String editar(Model model , Tarefa tarefa) {
		tarefaService.salvartarefa(tarefa);
		List<Tarefa> tarefas = tarefaService.tarefasPendentes();
		model.addAttribute("tarefas", tarefas);
		int total =  tarefaService.numTarefasConcluida();
		int tota2 = tarefaService.quantidadeTarefas();
		model.addAttribute("tarefaconcluida",total);
		model.addAttribute("tarefapedente",tota2);
		return "index";
		
	}
	
	
	
	
}
